package com.MyAzienda.SpringDataJPA.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.MyAzienda.SpringDataJPA.repositories.IStudenteRepository;
import com.MyAzienda.SpringDataJPA.models.Studente;

@RestController
@RequestMapping("api/studenti")
public class StudenteController{
   
   
   private final IStudenteRepository repo;
   
   /*
    * Si può omettere l’autowired se ho un solo costruttore (solo dalla 4.3),
    * ma se ci sono più costruttori, devo metterlo perché Spring deve sapere
    * quale deve utilizzare per l’autowired..
    */
   @Autowired
   public StudenteController(IStudenteRepository repo) {
       this.repo = repo;
   }
   
   @GetMapping
   public List<Studente> getAll() {
       return repo.findAll();
   }
   
//   @GetMapping("{id}")
//   public Optional<Studente> findById(@PathVariable("id") int id) {
//       System.out.println("ricevo chiamata con id = " + id);
//       return repo.findById((long) id);
//   }
   
    // oppure
    @GetMapping("{id}")
    public Studente getById(@PathVariable int id) {
        return repo.findById((long) id).orElse(null);
    }
   
   @PostMapping
   public Studente save(@RequestBody Studente s) {
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
   
   /******* Query custom *******************/
   @GetMapping("cognome/{cognome}")
   public List<Studente> findByCognome(@PathVariable("cognome") String cognome) {
       return repo.findByCognome(cognome);
   }
   
   @GetMapping("nome/{nome}")
   public List<Studente> findByNome(@PathVariable("nome") String nome) {
	   return repo.findByNome(nome);
   }
   
   @GetMapping("nomeecognome/{nome}/{cognome}")
   public List<Studente> findByNomeAndCognome(@PathVariable("nome") String nome, @PathVariable("cognome") String cognome) {
       return repo.findByNomeAndCognome(nome, cognome);
   }
//   
//   @GetMapping("enrollmentid/{enroll}")
//   public Studente findByEnrollmentid(@PathVariable("enroll") String enroll) {
//       return repo.findByEnroll(enroll);
//   }
//   
   @GetMapping("/fragmentcognome/{cognome}")
   public List<Studente> getByFragmentCognome(@PathVariable("cognome") String cognome) {
       return repo.findByCognomeFragment(cognome);
   }
   
   @GetMapping("/startingcognome/{cognome}")
   public List<Studente> getByCognomeStartingWith(@PathVariable("cognome") String cognome) {
       return repo.findByCognomeStartingWith(cognome);
   }

   @GetMapping("endingnome/{nome}")
   public List<Studente> getByNomeEndingWith(@PathVariable("nome") String nome) {
       return repo.findByNomeEndingWith(nome);
   }
}