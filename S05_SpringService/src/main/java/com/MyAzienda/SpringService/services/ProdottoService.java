package com.MyAzienda.SpringService.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.MyAzienda.SpringService.models.Prodotto;

@Service
public class ProdottoService {

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
		return "Deleten non avvenuta!!";
	}
}
