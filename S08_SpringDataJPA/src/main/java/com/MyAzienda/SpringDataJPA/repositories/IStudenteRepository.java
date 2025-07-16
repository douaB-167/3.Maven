package com.MyAzienda.SpringDataJPA.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.MyAzienda.SpringDataJPA.models.Studente;

@Repository
public interface IStudenteRepository extends JpaRepository<Studente, Long>{

	List<Studente> findByCognome(String cognome);
	List<Studente> findByNome(String nome);
	List<Studente> findByNomeAndCognome(String nome, String cognome);
	
	//query custom
	@Query("SELECT s FROM Studente s WHERE cognome LIKE %:last%")
	List<Studente> findByCognomeFragment(@Param("last") String cognome);
	
	@Query("SELECT s FROM Studente s WHERE cognome LIKE :lastname%") //LIKE prefix%
	List<Studente> findByCognomeStartingWith(@Param("lastname") String cognome);
	
	@Query("SELECT s FROM Studente s WHERE nome LIKE %:name") //LIKE prefix%
	List<Studente> findByNomeEndingWith(@Param("name") String nome);
	
	/*
	 * findAll()
	 * findById(id)
	 * save(entity)
	 * deleteById(id)
	 * existsById(id)
	 */
	
}
