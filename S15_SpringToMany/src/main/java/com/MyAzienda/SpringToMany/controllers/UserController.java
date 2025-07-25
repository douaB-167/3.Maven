package com.MyAzienda.SpringToMany.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MyAzienda.SpringToMany.entities.User;
import com.MyAzienda.SpringToMany.services.UserService;

@RestController
@RequestMapping("s15/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@Autowired
	private String currentDateTimeFormatted;
	
	@GetMapping
	public Iterable<User> getAll(){
		System.out.println("La data-ora corrente nel UserController è: " + currentDateTimeFormatted);
		return service.getAll();
	}

}
