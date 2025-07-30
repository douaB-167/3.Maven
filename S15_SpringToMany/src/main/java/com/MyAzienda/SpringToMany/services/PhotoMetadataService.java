package com.MyAzienda.SpringToMany.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyAzienda.SpringToMany.entities.Photo;
import com.MyAzienda.SpringToMany.entities.PhotoMetadata;
import com.MyAzienda.SpringToMany.repositories.IPhotoMetadataRepository;
import com.MyAzienda.SpringToMany.repositories.IPhotoRepository;

@Service
public class PhotoMetadataService {

	@Autowired
   private IPhotoMetadataRepository repoMD;
   
   @Autowired
   private IPhotoRepository repoPhoto;
   
   public PhotoMetadataService() {}
   
   public Iterable<PhotoMetadata> getAll() {
       return repoMD.findAll();
   }
   
   public Optional<PhotoMetadata> getById(Long id) {
       return repoMD.findById(id);
   }

   public PhotoMetadata add(PhotoMetadata photoMD, Long idPhoto) {
		Photo photoAddMetadata = repoPhoto.findById(idPhoto).get();
		
		if (photoAddMetadata.getPhotoMetadata() == null) {
			PhotoMetadata metadata = new PhotoMetadata();
			
			metadata.setWidth(photoMD.getWidth());
			metadata.setHeight(photoMD.getHeight());
			metadata.setCreated(new Date());
			
			metadata.setPhoto(photoAddMetadata);
			
			return repoMD.save(metadata);
		}
		return null;
	}
	
	public PhotoMetadata update(PhotoMetadata photoMD, Long idPhoto) {
		Photo photoAddMetadata = repoPhoto.findById(idPhoto).get();
		PhotoMetadata metadata;
		if (photoAddMetadata.getPhotoMetadata() == null) {
			metadata = new PhotoMetadata();
			
			metadata.setWidth(photoMD.getWidth());
			metadata.setHeight(photoMD.getHeight());
			metadata.setCreated(new Date());
			
			metadata.setPhoto(photoAddMetadata);
			
			return repoMD.save(metadata);
			
		} else {
			metadata = photoAddMetadata.getPhotoMetadata();
			metadata.setWidth(photoMD.getWidth());
			metadata.setHeight(photoMD.getHeight());
			metadata.setCreated(new Date());
			
			metadata.setPhoto(photoAddMetadata);
			
			return repoMD.save(metadata);
		}
	}
	
	public boolean delete(Long id) {
		Optional<PhotoMetadata> foundPhoto = repoMD.findById(id);
		
		if (foundPhoto.isEmpty()) {
			return false;
		}
		
		repoMD.deleteById(id);
		
		System.out.println("foundPhoto -> " + foundPhoto.get().toString());
		repoMD.delete(foundPhoto.get());
		return true;
	}
	   
}
