package com.MyAzienda.SpringPhotos.controllers.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.MyAzienda.SpringPhotos.models.Photo;
import com.MyAzienda.SpringPhotos.services.IPhotoService;
import com.MyAzienda.SpringPhotos.services.PhotoService;

@RestController
@RequestMapping("admin/api/photos")
public class AdminPhotoController {
	
	@Autowired
	@Qualifier("mainPhotoService")
	private IPhotoService photoService;
	
//	public AdminPhotoController() {}
	
	public AdminPhotoController(PhotoService photoService) {
		this.photoService = photoService;
	}
	
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
	
	@PostMapping
	public Photo create(@RequestBody Photo photo) {
		return photoService.create(photo);
	}

	@PutMapping("{id}")
	public Photo update(@PathVariable int id, @RequestBody Photo photo) {
		Optional<Photo> updatePhoto = photoService.update(id, photo);

		if (updatePhoto.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "photo id = " + id + " not found");
		}
		return updatePhoto.get();
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable int id) {
		boolean isDeleted = photoService.delete(id);
		
		if (isDeleted == false) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "photo id = " + id + " not deleted");
		}
	}
}
