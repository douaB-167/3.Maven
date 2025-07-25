package com.MyAzienda.SpringToMany.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MyAzienda.SpringToMany.entities.Photo;
import com.MyAzienda.SpringToMany.services.PhotoService;

@RestController
@RequestMapping("s15/photos")
public class PhotoController {
	
	@Autowired
	private PhotoService photoService;
	
	@Autowired
	private String currentDateTimeFormatted;
	
	@GetMapping
	public Iterable<Photo> getAll(){
		System.out.println("La data-ora corrente nel PhotoController è: " + currentDateTimeFormatted);
		return photoService.getAll();
	}

}
