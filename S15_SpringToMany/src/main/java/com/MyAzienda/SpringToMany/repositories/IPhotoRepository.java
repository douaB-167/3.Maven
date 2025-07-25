package com.MyAzienda.SpringToMany.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.MyAzienda.SpringToMany.entities.Photo;

@Repository
public interface IPhotoRepository extends CrudRepository<Photo, Long> {

	public Optional<Photo> findByTitle(String title);
}
