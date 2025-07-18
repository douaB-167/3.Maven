package com.MyAzienda.SpringDataJPA.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MyAzienda.SpringDataJPA.models.StudenteOLD;
import com.MyAzienda.SpringDataJPA.repositories.IStudenteRepository;

@RestController
@RequestMapping("api/studenti")
public class StudenteController {
	
	@Autowired
	private final IStudenteRepository repo;
	
	public StudenteController(IStudenteRepository repo) {
		this.repo = repo;
	}
	
	@GetMapping
	public List<StudenteOLD> getAll() {
		return repo.findAll();
	}
	
	@GetMapping("{id}")
	public Optional<StudenteOLD> findById(@PathVariable("id") int id) {
		System.out.println("ricevo chiamata con id = " + id);
		return repo.findById((long) id);
	}
	
//	// oppure
//	@GetMapping("{id}")
//	public Studente getById(@PathVariable int id) {
//		return repo.findById((long) id).orElse(null);
//	}
	
	@PostMapping
	public StudenteOLD save(@RequestBody StudenteOLD s) {
		return repo.save(s);
	}
	
	@DeleteMapping("{id}")
	public void deleteById(@PathVariable("id") int id) {
		repo.deleteById((long) id);
	}
	
	@GetMapping("esiste/{id}")
	public boolean existById(@PathVariable("id") int id) {
		return repo.existsById((long) id);
	}
	
	
	/*******   Query custom *******************/
	@GetMapping("cognome/{cognome}")
	public List<StudenteOLD> findByCognome(@PathVariable("cognome") String cognome) {
		return repo.findByCognome(cognome);
	}
	
	@GetMapping("nomeecognome/{nome}/{cognome}")
	public List<StudenteOLD> findByNomeAndCognome(@PathVariable("nome") String nome, @PathVariable("cognome") String cognome) {
		return repo.findByNomeAndCognome(nome, cognome);
	}
	
	@GetMapping("enrollmentid/{enroll}")
	public StudenteOLD findByEnrollmentid(@PathVariable("enroll") String enroll) {
		return repo.findByEnroll(enroll);
	}
	
	@GetMapping("/fragmentcognome/{cognome}")
	public List<StudenteOLD> getByFragmentCognome(@PathVariable("cognome") String cognome) {
		return repo.findByCognomeFragment(cognome);
	}
	
	@GetMapping("/startingcognome/{cognome}")
	public List<StudenteOLD> getByCognomeStartingWith(@PathVariable("cognome") String cognome) {
		return repo.findByCognomeStartingWith(cognome);
	}

	@GetMapping("endingnome/{nome}")
	public List<StudenteOLD> getByNomeEndingWith(@PathVariable("nome") String nome) {
		return repo.findByNomeEndingWith(nome);
	}
	
}
