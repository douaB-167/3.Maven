package com.MyAzienda.SpringToMany.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
}
