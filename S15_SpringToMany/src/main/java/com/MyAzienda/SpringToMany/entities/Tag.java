package com.MyAzienda.SpringToMany.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tags")
public class Tag {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   
   private String text;
   
   public Long getId() {
       return id;
   }
   
   public void setId(Long id) {
       this.id = id;
   }
   
   public String getText() {
       return text;
   }
   
   public void setText(String text) {
       this.text = text;
   }
   
   // 3° step -> collegare con relazione @ManyToMany alla tabella Photo attraverso bridge photo_tag
   //questo "tags" lo troviamo sulls classe Photo
   @ManyToMany(mappedBy = "tags")
   private Set<Photo> photos;
   
   public List<Long> getPhotos(){
	   List<Long> lista = new ArrayList<Long>();
	   for (Photo p : photos) {
		   lista.add(p.getId());
	   }
	   return lista;
   }
   
   public Set<Photo> tutteFoto(){
	   return photos;
   }
   
   public void removePhoto(Photo photo) {
	   this.photos.remove(photo);
	   photo.getTags().remove(this);
   }
   
}
