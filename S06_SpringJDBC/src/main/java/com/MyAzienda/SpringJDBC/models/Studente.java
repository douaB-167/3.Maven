package com.MyAzienda.SpringJDBC.models;

import java.util.Date;

public class Studente extends Persona {

	private String matricola;
	private Date dataNascita;
	
	public Studente() {
		super();
	}

	public Studente(String nome, String cognome, String matricola, Date dataNascita) {
		super(nome, cognome);
		this.matricola = matricola;
		this.dataNascita = dataNascita;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	@Override
	public String toString() {
		return "Studente [matricola=" + matricola + ", dataNascita=" + dataNascita + "]";
	}
	
}
