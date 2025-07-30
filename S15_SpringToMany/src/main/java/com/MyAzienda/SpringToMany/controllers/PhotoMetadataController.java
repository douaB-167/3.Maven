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

import com.MyAzienda.SpringToMany.entities.PhotoMetadata;
import com.MyAzienda.SpringToMany.services.PhotoMetadataService;

@RestController
@RequestMapping("s15/photometadata")
public class PhotoMetadataController {
   
   @Autowired
   private PhotoMetadataService photoMetadataService;
   
   @GetMapping
   public Iterable<PhotoMetadata> getAll() {
       return photoMetadataService.getAll();
   }
   
   @GetMapping("{id}")
   public PhotoMetadata getById(@PathVariable Long id) {
       Optional<PhotoMetadata> photoMetadata = photoMetadataService.getById(id);
       if (photoMetadata.isEmpty()) {
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "PhotoMetadata id = " + id + " not found");
       }
       return photoMetadata.get();
   }
   
   @PostMapping("/add/{idPhoto}")
   public PhotoMetadata addOne(@RequestBody PhotoMetadata photoMD, @PathVariable Long idPhoto) {
	    return photoMetadataService.add(photoMD, idPhoto);
	}
   
   @PutMapping("/update/{idPhoto}")
   public PhotoMetadata update(@RequestBody PhotoMetadata photoMD, @PathVariable Long idPhoto) {
	    return photoMetadataService.update(photoMD, idPhoto);
	}

   @DeleteMapping("/delete/{id}")
   public void delete(@PathVariable Long id) {
   	photoMetadataService.delete(id);
   }
}