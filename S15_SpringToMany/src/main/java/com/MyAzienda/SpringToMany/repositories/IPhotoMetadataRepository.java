package com.MyAzienda.SpringToMany.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.MyAzienda.SpringToMany.entities.PhotoMetadata;

@Repository
public interface IPhotoMetadataRepository extends CrudRepository<PhotoMetadata, Long> {

}
