package com.MyAzienda.SpringToMany.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.MyAzienda.SpringToMany.entities.Tag;

@Repository
public interface ITagRepository extends CrudRepository<Tag, Long>{

}
