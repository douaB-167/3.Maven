package com.MyAzienda.SpringService.models;

public class Prodotto {

	private int id;
	private String nome;
	private String codice;
	private float prezzo;
	
	public Prodotto () {
		
	}
	
	public Prodotto (int id, String nome, String codice, float prezzo) {
		this.id = id;
		this.nome = nome;
		this.codice = codice;
		this.prezzo = prezzo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	@Override
	public String toString() {
		return "Prodotto [id=" + id + ", nome=" + nome + ", codice=" + codice + ", prezzo=" + prezzo + "]";
	}
	
}
