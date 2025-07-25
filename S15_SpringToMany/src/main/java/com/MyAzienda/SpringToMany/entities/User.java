package com.MyAzienda.SpringToMany.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {


   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
       
   @Column(
       nullable = false
   )            
   private String name;
   
   public User() {}
   
   public Long getId() {
       return id;
   }
   public void setId(Long id) {
       this.id = id;
   }
   public String getName() {
       return name;
   }
   public void setName(String name) {
       this.name = name;
   }
   
   // 2° step -> collegare con relazione @OneToMany -- versione Relazione Bidirezionale
   @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
   private Set<Photo> photos;
   
   public List<Long> getPhotos() {
       List<Long> lista = new ArrayList<Long>();
       for (Photo p : photos) {
           lista.add(p.getId());
       }
       return lista;
   }

}
