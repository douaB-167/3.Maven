package com.MyAzienda.SpringPhotos.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.MyAzienda.SpringPhotos.models.Photo;

@Repository
public interface IPhotoRepository extends CrudRepository<Photo, Integer>{

}
