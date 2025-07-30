package com.MyAzienda.SpringToMany.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyAzienda.SpringToMany.entities.Photo;
import com.MyAzienda.SpringToMany.entities.Tag;
import com.MyAzienda.SpringToMany.repositories.IPhotoRepository;
import com.MyAzienda.SpringToMany.repositories.ITagRepository;

@Service
public class TagService {

	@Autowired
   private ITagRepository tagRepository;
   
   @Autowired
   private IPhotoRepository repoPhoto;
   
   public TagService() {}
   
   public Iterable<Tag> getAll() {
       return tagRepository.findAll();
   }
   
   public Optional<Tag> getById(Long id) {
       return tagRepository.findById(id);
   }
   
   public Tag create(Tag tag) {
		return tagRepository.save(tag);
	}
	
	public Optional<Tag> addTag2Photo(Tag tag, Long idPhoto) {
		Photo photoAddTag = repoPhoto.findById(idPhoto).get();
		photoAddTag.getTags().add(tag);
		repoPhoto.save(photoAddTag);
		return tagRepository.findById(tag.getId());
	}
	
	public Optional<Tag> update(Tag tag) {
		Optional<Tag> foundTag = tagRepository.findById(tag.getId());
		
		if (foundTag.isEmpty()) {
			return Optional.empty();
		}
		
		foundTag.get().setText(tag.getText());
		tagRepository.save(foundTag.get());
		return foundTag;
	}
	
	public boolean delete(Long id) {
		Optional<Tag> foundTag = tagRepository.findById(id);
		if (foundTag.isEmpty()) {
			return false;
		}

		Set<Photo> fotoTag = foundTag.get().tutteFoto();

		Set<Photo> copySet = new HashSet<>(fotoTag); // Creazione di una copia
	    for (Photo p : copySet) {
	    	foundTag.get().removePhoto(p);
	    }
		
		tagRepository.delete(foundTag.get());
		return true;
	}
	   
}
