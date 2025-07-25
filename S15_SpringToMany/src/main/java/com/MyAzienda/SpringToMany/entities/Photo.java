package com.MyAzienda.SpringToMany.entities;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="photos")
public class Photo {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   
   @Column(
       length = 200,
       name = "main_url",
       nullable = false,
       unique = true
           )
   private String url;
   
   @Column(
       columnDefinition = "TEXT"
       )
   private String description;
       
   private String title;

   public Photo() {}

   public Photo(Long id, String url) {
       super();
       this.id = id;
       this.url = url;
   }

   public Long getId() {
       return id;
   }

   public void setId(Long id) {
       this.id = id;
   }

   public String getUrl() {
       return url;
   }

   public void setUrl(String url) {
       this.url = url;
   }
   
   public String getTitle() {
       return title;
   }

   public void setTitle(String title) {
       this.title = title;
   }

   public String getDescription() {
       return description;
   }

   public void setDescription(String description) {
       this.description = description;
   }
   
   // 2° step > collegare con relazione @ManyToOne alla classe User (tabella users)
   @ManyToOne
   @JoinColumn(name = "user_id")
   private User user;
   
   public User getUser() {
	   return this.user;
   }
   
   public void setUser(User user) {
	   this.user = user;
   }
   
   // 3° step -> collegare con relazione @ManyToMany alla tabella Tag con tabella bridge photo_tag
   @ManyToMany(fetch = FetchType.EAGER)
   @JoinTable(
		   name = "photo_tag",
		   joinColumns = @JoinColumn(name = "photo_id"),
		   inverseJoinColumns = @JoinColumn(name = "tag_id")
		   )
   private Set<Tag> tags;
   
   public Set<Tag> getTags(){
	   return tags;
   }
   
   public void setTags(Set<Tag> tags) {
	   this.tags = tags;
   }
   
   // 4° step -> relazione @OneToOne con PhotoMetadata
   @OneToOne(cascade = CascadeType.ALL, mappedBy = "photo")
   private PhotoMetadata photoMetadata;
   
   public PhotoMetadata getPhotoMetadata() {
	   return photoMetadata;
   }
   
}
