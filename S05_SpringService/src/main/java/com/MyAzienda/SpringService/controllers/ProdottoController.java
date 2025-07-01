package com.MyAzienda.SpringService.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MyAzienda.SpringService.models.Prodotto;
import com.MyAzienda.SpringService.services.ProdottoService;

@RestController
@RequestMapping("api/prodotti")
public class ProdottoController {
	
	/***** primo approccio: per utilizzare il ProdottoService devo sempre istanziare l'oggetto prodserv
	 * Problema: mi crea tanti oggetti "prodserv" in memoria..... ***********/
//	@GetMapping
//	public List<Prodotto> elencoProdotti(){
//		ProdottoService prodserv = new ProdottoService();
//		return prodserv.getAllProdotti();
//	}
//	
//	@GetMapping("{id}")
//	public Prodotto dettaglioProdotto(@PathVariable int id) {
//		ProdottoService prodserv = new ProdottoService();
//		return prodserv.getProdottoById(id);
//	}
	
	/**
	 * primo esempio di DI -> Dependency Injection
	 */
	//prima modalità: inizializzazione della proprietà
	//private final ProdottoService service = new ProdottoService();
	
	//seconda modalità: inizializzazione con il costruttore
//	private final ProdottoService service;
//	
//	public ProdottoController(ProdottoService service) {
//		this.service = service;
//	}
//	
//	@GetMapping
//	public List<Prodotto> elencoProdotti(){
//		return service.getAllProdotti();
//	}
//
//	@GetMapping("{id}")
//	public Prodotto dettaglioProdotto(@PathVariable int id) {
//		return service.getProdottoById(id);
//	}
	
	/**
	 * 2° esempio di DI -> inizializzazione del service come argomento del costruttore
	 */
//	private final ProdottoService service;
//	
//	public ProdottoController(ProdottoService service) {
//		this.service = new ProdottoService();
//	}
//	
//	@GetMapping
//	public List<Prodotto> elencoProdotti(){
//		return service.getAllProdotti();
//	}
//
//	@GetMapping("{id}")
//	public Prodotto dettaglioProdotto(@PathVariable int id) {
//		return service.getProdottoById(id);
//	}
	
	/**
	 * 3° esempio di DI -> Dependency Injection con @Autowired
	 		Spring inietterà la dipendenza "service" per noi...quando serve *****/
	public ProdottoController() {
		System.out.println("start del costruttore prodottoController");
	}
	
	@Autowired
	private ProdottoService service;
	
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
	
	@PostMapping
	public Prodotto inserisciProdotto(@RequestBody Prodotto p) {
		return service.addProdotto(p);
	}
	
	@DeleteMapping("{id}")
	public String cancellaProdottoById(@PathVariable int id) {
		return service.deleteProdotto(id);
	}
}
