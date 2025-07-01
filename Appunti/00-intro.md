L'annotation è un'istruzione metadati che viene aggiunta al codice sorgente, fornendo informazioni aggiuntive al framework.
@SpringBootApplication dichiara qual è il file che contiene il main ossia da dove partire 

devtool: aggiorna e salva tutte le volte quando il server è attivo
Tomcat started on port 8080 (http) with context path '/'
The context path of a web application defines the URL that end users will access the application from
http:localhost:8080/api/persone

Controllers 
il/i file che si interfaccerà/ranno con l'esterno
@RestController
@RequestMapping(".../...")

/*** 3° esempio di DI -> Dependency Injection con @Autowired
    Spring inietterà la dipendenza "service" per noi...quando serve *****/
public ProdottoController() {
    System.out.println("start del costruttore prodottoController");
}

@Autowired
private ProdottoService service;

//GET
@GetMapping
public List<Prodotto> elencoProdotti(){
    System.out.println("start del service elencoProdotti");
    System.out.println("toString del service = " + service.toString());
    return service.getAllProdotti();
}
@GetMapping("{id}")
public Prodotto dettaglioProdotto(@PathVariable int id) {
    return service.getProdottoById(id);
}

@GetMapping("titolo")
public String test() {
    return "<HTML> <H1> buongiorno dal metodo non service </H1> </HTML>";
}

//POST
@PostMapping
public Prodotto inserisciProdotto(@RequestBody Prodotto p) {
    return service.addProdotto(p);
}
@PostMapping("inserisci")
public Prodotto inserisciProdotto(@RequestBody Prodotto p) {
    System.out.println(p.getId());
    System.out.println(p.toString());
    p.setId(prodotti.size()+1);
    System.out.println(p.toString());
    prodotti.add(p);
    return p;
}

//DELETE
@DeleteMapping("{id}")
public String cancellaProdottoById(@PathVariable int id) {
    return service.deleteProdotto(id);
}
Models
all'interno di questo pacchetto mettiamo tutte le definizioni delle classi es: 
public class Prodotto {
	
	private int id;
	private String nome;
	private String codice;
	private float prezzo;
	
	public Prodotto () {
		
	}
	
	public Prodotto (int id, String nome, String codice, float prezzo) {
		this.id = id;
		this.nome = nome;
		this.codice = codice;
		this.prezzo = prezzo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	@Override
	public String toString() {
		return "Prodotto [id=" + id + ", nome=" + nome + ", codice=" + codice + ", prezzo=" + prezzo + "]";
	}
}

Services
@Service
definisce le istanze e i metodi relativi alla classe che poi verranno implementati nel pacchetto controllers
private List<Prodotto> prodotti = new ArrayList<Prodotto>() {{
    add(new Prodotto(1, "bullone dia. 22", "BL212", 2.50f));
    add(new Prodotto(2, "vite filetto a gas", "VT3212", 4.50f));
    add(new Prodotto(3, "lavatrice a cestello", "LAV100", 270.90f));
}};

//restituisce l'elenco dei prodotti (getAll)
public List<Prodotto> getAllProdotti(){
    return prodotti;
}

//restituisce un singolo oggetto (getById)
public Prodotto getProdottoById(int varId) {
    for(int i = 0; i < prodotti.size(); i++) {
        if(prodotti.get(i).getId() == varId) {
            return prodotti.get(i);
        }
    }
    return null;
}

//in creazione avremo add....
public Prodotto addProdotto(Prodotto p) {
    System.out.println("prodotto prima del setId: " + p.toString());
    p.setId(prodotti.size()+1);
    System.out.println("prodotto dopo del setId: " + p.toString());
    prodotti.add(p);
    return p;
}

//delete
public String deleteProdotto(int varId) {
    for(int i = 0; i < prodotti.size(); i++) {
        if(prodotti.get(i).getId() == varId) {
            prodotti.remove(i);
            return "Delete del prodotto";
        }
    }
    return "Delete non avvenuta!!";
}