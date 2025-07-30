package com.MyAzienda.SpringToMany.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.MyAzienda.SpringToMany.entities.Tag;
import com.MyAzienda.SpringToMany.services.TagService;

@RestController
@RequestMapping("s15/tags")
public class TagController {
   
   @Autowired
   private TagService service;
   
   @GetMapping
   public Iterable<Tag> getAll() {
       return service.getAll();
   }
   
   @GetMapping("{id}")
   public Tag getById(@PathVariable Long id) {
       Optional<Tag> tag = service.getById(id);
       
       if (tag.isEmpty()) {
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tag id = " + id + " not found");
       }
       return tag.get();
   }
   
   @PostMapping
	public Tag createTag(@RequestBody Tag tag) {
		return service.create(tag);
	}
	
   @PostMapping("/add2Photo/{idPhoto}")
   public Optional<Tag> addTag2Photo(@RequestBody Tag tag, @PathVariable Long idPhoto) {
	    return service.addTag2Photo(tag, idPhoto);
	}
   
   @PutMapping("/update")
   public Optional<Tag> update(@RequestBody Tag tag) {
	    return service.update(tag);
	}
	
   @DeleteMapping("/delete/{id}")
   public void delete(@PathVariable Long id) {
   	if(service.getById(id).isEmpty()) {
	    	throw new ResponseStatusException(HttpStatus.FOUND, "TAG NOT found");
	    }
   	service.delete(id);
   }
}
