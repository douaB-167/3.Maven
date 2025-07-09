package com.MyAzienda.SpringJDBC.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.MyAzienda.SpringJDBC.models.Studente;

@Repository
public class StudenteRepository implements IRepositoryRead<Studente>, IRepositoryWrite<Studente>{

	@Override
	public boolean create(Studente obj) {
		// TODO Auto-generated method stub
		boolean result = false;
		
		try {
			Connection conn = ConnectionSingleton.getInstance().getConnection();
			//INSERT INTO Studente (nome, cognome, matricola dataNascita)
			String query = "INSERT INTO Studente (nome, cognome, matricola, dataNascita) VALUES"
					+ "(?, ?, ?, ?);";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, obj.getNome());
			ps.setString(2, obj.getCognome());
			ps.setString(3, obj.getMatricola());
			ps.setDate(4, obj.getDataNascita());
			
			int rowsReturned = ps.executeUpdate();
			
			if(rowsReturned > 0) {
				result = true;
			}
			
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return result;
	}

	@Override
	public boolean update(Studente obj) {
		// TODO Auto-generated method stub
		boolean result = false;
		
		try {
			Connection conn = ConnectionSingleton.getInstance().getConnection();
			
			int id = obj.getId();
			Studente s = this.getById(id);
			
			if(s != null) {
				System.out.println("s.getNome() = " + s.getNome());
				System.out.println("obj.getNome() = " + obj.getNome());
				s.setNome(obj.getNome() == null ? s.getNome() : obj.getNome());
				s.setCognome(obj.getCognome());
				s.setMatricola(obj.getMatricola());
				s.setDataNascita(obj.getDataNascita());
				
				String query = "UPDATE Studente SET"
						+ " nome = ?, "
						+ " cognome = ?, "
						+ " matricola = ?, "
						+ " dataNascita = ?"
						+ " where studenteId = ?; ";
				
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1, s.getNome());
				ps.setString(2, s.getCognome());
				ps.setString(3, s.getMatricola());
				ps.setDate(4, s.getDataNascita());
				ps.setInt(5,  s.getId());
				
				int rowsReturned = ps.executeUpdate();
				
				if(rowsReturned > 0) {
					result = true;
				}
			}
			
			conn.close();
		} catch (Exception e) {
			System.out.println(" Update exception = " + e.getMessage());
		}
		
		return result;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		boolean result = false;
		
		try {
			Connection conn = ConnectionSingleton.getInstance().getConnection();
			
			String query = "DELETE FROM Studente WHERE studenteId = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			
			int rowsReturned = ps.executeUpdate();
			
			if(rowsReturned > 0) {
				result = true; 
			}
			
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return result;
	}

	@Override
	public Studente getById(int id) {
		
		Studente studente = null; // Inizializza a null, verrà popolato se trovato
		
		try {
			Connection conn = ConnectionSingleton.getInstance().getConnection();
			
			String query = "select studenteId, nome, cognome, matricola, dataNascita from studente where studenteId = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id); // Imposta il parametro 'id' nella query
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) { // Se viene trovato un risultato
				studente = new Studente();
				studente.setId(rs.getInt("studenteId"));
				studente.setNome(rs.getString("nome"));
				studente.setCognome(rs.getString("cognome"));
				studente.setMatricola(rs.getString("matricola"));
				studente.setDataNascita(rs.getDate("dataNascita"));
			}
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return studente;
	}


	@Override
	public List<Studente> getAll() {
		List<Studente> elenco = new ArrayList<Studente>();
		try {
			Connection conn = ConnectionSingleton.getInstance().getConnection();
			String query = "select studenteId, nome, cognome, matricola, dataNascita from studente";
			//? placeholder, successivamente ti darò l'informazione
			PreparedStatement ps = conn.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Studente s = new Studente();
				s.setId(rs.getInt("studenteId"));
				s.setNome(rs.getString("nome"));
				s.setCognome(rs.getString("nome"));
				s.setMatricola(rs.getString("matricola"));
				s.setDataNascita(rs.getDate("dataNascita"));
				
				elenco.add(s);
			}
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return elenco;
	}

	
}
