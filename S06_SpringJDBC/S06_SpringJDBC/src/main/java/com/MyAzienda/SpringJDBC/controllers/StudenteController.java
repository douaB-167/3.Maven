package com.MyAzienda.SpringJDBC.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MyAzienda.SpringJDBC.models.Studente;
import com.MyAzienda.SpringJDBC.services.StudenteService;

@RestController
@RequestMapping("api/studenti")
public class StudenteController {
	
	@Autowired
	private StudenteService service;
	
	@GetMapping
	public List<Studente> elencoStudenti(){
		return service.elencoStudentiService();
	}
	
	@GetMapping("{id}")
	public Studente singoloStudente(@PathVariable int id) {
		return service.singoloStudente(id);
	}

}
