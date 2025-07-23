package com.MyAzienda.SpringPhotos.controllers.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.MyAzienda.SpringPhotos.models.Photo;
import com.MyAzienda.SpringPhotos.services.IPhotoService;
import com.MyAzienda.SpringPhotos.services.PhotoService;

@RestController
@RequestMapping("api/photos")
public class PhotoController {
	
	@Autowired
	@Qualifier("mainPhotoService")
	private IPhotoService photoService;
	
//	public PhotoController(PhotoService photoService) {
//		this.photoService = photoService;
//	}
	
	@GetMapping
	public Iterable<Photo> getAll() {
		return photoService.getAll();
	}
	
	@GetMapping("{id}")
	public Photo getById(@PathVariable int id) {
		Optional<Photo> photo = photoService.getById(id);
		
		if (photo.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "photo id = " + id + " not found");
		}
		return photo.get();
	}
	
	

}
