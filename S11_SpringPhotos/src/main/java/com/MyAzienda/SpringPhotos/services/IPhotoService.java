package com.MyAzienda.SpringPhotos.services;

import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;

import com.MyAzienda.SpringPhotos.models.Photo;

public interface IPhotoService {
	
	public Iterable<Photo> getAll();
	
	public Optional<Photo> getById(@PathVariable int id);
	
	public Photo create(Photo photo);
	
	public Optional<Photo> update(int id, Photo photo);
	
	public boolean delete(int id);

}
