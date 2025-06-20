package com.MyAzienda.SpringService.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MyAzienda.SpringService.models.Prodotto;
import com.MyAzienda.SpringService.services.ProdottoService;

@RestController
@RequestMapping("api/prodotti")
public class ProdottoController {
	
	/**
	 * primo esempio di DI -> Dependency Injection
	 */
	//prima modalità: inizializzazione della proprietà
	//private final ProdottoService service = new ProdottoService();
	
	//seconda modalità: inizializzazione con il costruttore
	private final ProdottoService service;
	
	public ProdottoController(ProdottoService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<Prodotto> elencoProdotti(){
		return service.getAllProdotti();
	}

}
