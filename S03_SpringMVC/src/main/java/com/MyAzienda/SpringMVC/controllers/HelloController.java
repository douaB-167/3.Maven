package com.MyAzienda.SpringMVC.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //Questa è una classe controller, sopratutto per il web
@RequestMapping("api/saluti")
public class HelloController {

	@GetMapping("saluta")
	public String saluta() {
		return "saluti dalla get";
	}
	
	//stampa il primo metodo
	@PostMapping("saluta")
	public String saluta2() {
		System.out.println("saluti dalla post");
		return "saluti dalla post";
	}
}
