package com.MyAzienda.SpringJDBC.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyAzienda.SpringJDBC.models.Docente;
import com.MyAzienda.SpringJDBC.repositories.DocenteRepository;

@Service
public class DocenteService {

	@Autowired 
	private DocenteRepository repo;
	
	public List<Docente> elencoDocentiService(){
		return repo.getAll();
	}
	
	public Docente singoloDocente(int id) {
		return repo.getById(id);
	}
	
	public boolean createDocenteService(Docente d) {
		return repo.create(d);
	}
	
	public boolean updateDocenteService(Docente d) {
		return repo.update(d);
	}
	public boolean deleteDocenteService(int id) {
		return repo.delete(id);
	}
	
}
