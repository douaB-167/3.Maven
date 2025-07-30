package com.MyAzienda.SpringToMany.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.MyAzienda.SpringToMany.entities.Photo;
import com.MyAzienda.SpringToMany.repositories.IPhotoRepository;

@Service
public class PhotoService {

	@Autowired
	private IPhotoRepository repo;
	
	public PhotoService() {}
	
	public Iterable<Photo> getAll(){
		return repo.findAll();
	}
	
	public Optional<Photo> findById(@PathVariable Long id) {
		return repo.findById(id);
	}
}
