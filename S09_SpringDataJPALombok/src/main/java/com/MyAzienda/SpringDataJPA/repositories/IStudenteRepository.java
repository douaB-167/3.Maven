package com.MyAzienda.SpringDataJPA.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.MyAzienda.SpringDataJPA.models.StudenteOLD;

@Repository
public interface IStudenteRepository extends JpaRepository<StudenteOLD, Long> {

	List<StudenteOLD> findByCognome(String cognome);
	List<StudenteOLD> findByNomeAndCognome(String nome, String cognome);
	
	StudenteOLD findByEnroll(String enrollmentid);
	
	@Query("SELECT s FROM Studente s WHERE cognome LIKE %:last%")
	List<StudenteOLD> findByCognomeFragment(@Param("last") String cognome);
	
	@Query("SELECT s FROM Studente s WHERE cognome LIKE :last%")
	List<StudenteOLD> findByCognomeStartingWith(@Param("last") String cognome); // LIKE prefix%
	
	@Query("SELECT s FROM Studente s WHERE nome LIKE %:name")
	List<StudenteOLD> findByNomeEndingWith(@Param("name") String nome);   // LIKE %suffix
	
	/*
	 * findAll()
	 * findById(id)
	 * save(entity)
	 * deleteById(id)
	 * existById(id)
	 */
}
