package com.MyAzienda.SpringThymeLeaf.controllers.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.MyAzienda.SpringThymeLeaf.models.Photo;

@RestController
public class PhotoController {
	
	private List<Photo> list;
	
	public PhotoController() {
		list = new ArrayList<>();
		list.add(new Photo(1, "./img/01.png"));
		list.add(new Photo(2, "./img/02.png"));
		list.add(new Photo(3, "./img/03.png"));
	}
	
	@RequestMapping("api/photo")
	public Iterable<Photo> getAll(){
		return list;
	}
	
	@RequestMapping("api/photo/{id}")
	public Photo getById(@PathVariable int id) {
		Optional<Photo> photo = ((Collection<Photo>) getAll())
															.stream()
															.filter(ph -> ph.getId() == id)
															.findFirst();
		if(photo.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "photo id = " + id + " not found");
		}
		return photo.get();
	}
}
