package com.MyAzienda.SpringToMany.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyAzienda.SpringToMany.entities.User;
import com.MyAzienda.SpringToMany.repositories.IUserRepository;

@Service
public class UserService {
	
	@Autowired
	private IUserRepository repo;
	
	public UserService() {}
	
	public Iterable<User> getAll(){
		return repo.findAll();
	}

}
