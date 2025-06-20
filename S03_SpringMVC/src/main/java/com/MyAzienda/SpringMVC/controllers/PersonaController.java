package com.MyAzienda.SpringMVC.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MyAzienda.SpringMVC.models.Persona;

@RestController
//questa è una classe controller, rest controller
@RequestMapping("/api/persone")
public class PersonaController {
	
	//devtool: aggiorna e salva tutte le volte quando il server è attivo
	//Tomcat started on port 8080 (http) with context path '/'
	//The context path of a web application defines the URL that end users will access the application from
	//http:localhost:8080/api/persone
	
	//CRUD -> Read = GET
	
	@GetMapping("anagrafica")
	public Persona retPersona() {
		Persona p = new Persona("Mario", "Rosii", 34);
		return p;
	}
	
	@GetMapping("elenco")
	public List<Persona> elencoPersona(){
		List<Persona> elenco = new ArrayList<Persona>();
		elenco.add(new Persona("Mario", "Rossi", 34));
		elenco.add(new Persona("Ezio", "Rossi", 14));
		elenco.add(new Persona("Pippo", "Verdi", 54));
		return elenco;
	}
	
	//http://localhost:8080/api/persone/nuova?nome=varNome&cognome=varCognome&eta=varEta
	@GetMapping("nuova")
	public Persona nuovaPersona(
			@RequestParam(name="nome") String varNome,
			@RequestParam(name="cognome") String varCognome,
			@RequestParam(name="eta") int varEta
			) {
		return new Persona(varNome, varCognome, varEta);
	}
	
	//CRUD -> Create = POST
	
	@PostMapping("inserisci")
	public Persona inserisciPersona(@RequestBody Persona p) {
		return p;
	}

}
