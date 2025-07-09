package com.MyAzienda.SpringJDBC.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyAzienda.SpringJDBC.models.Studente;
import com.MyAzienda.SpringJDBC.repositories.StudenteRepository;

@Service
public class StudenteService  {
	
	@Autowired 
	private StudenteRepository repo;
	
	public List<Studente> elencoStudentiService(){
		return repo.getAll();
	}
	
	public Studente singoloStudente(int id) {
		return repo.getById(id);
	}
	
	public boolean createStudenteService(Studente s) {
		return repo.create(s);
	}
	
	public boolean updateStudenteService(Studente s) {
		return repo.update(s);
	}
	public boolean deleteStudenteService(int id) {
		return repo.delete(id);
	}
}
