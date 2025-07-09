package com.MyAzienda.SpringJDBC.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.MyAzienda.SpringJDBC.models.Docente;

@Repository
public class DocenteRepository implements IRepositoryRead<Docente>, IRepositoryWrite<Docente>{

	@Override
	public boolean create(Docente obj) {
		// TODO Auto-generated method stub
		boolean result = false;
		
		try {
			Connection conn = ConnectionSingleton.getInstance().getConnection();
			String query = "INSERT INTO Docente (nome, cognome, materia) VALUES"
					+ "(?, ?, ?);";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, obj.getNome());
			ps.setString(2, obj.getCognome());
			ps.setString(3, obj.getMateria());
			
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
	public boolean update(Docente obj) {
		// TODO Auto-generated method stub
		boolean result = false;
		
		try {
			Connection conn = ConnectionSingleton.getInstance().getConnection();
			
			int id = obj.getId();
			Docente d = this.getById(id);
			
			if(d != null) {
				System.out.println("d.getNome() = " + d.getNome());
				System.out.println("obj.getNome() = " + obj.getNome());
				d.setNome(obj.getNome() == null ? d.getNome() : obj.getNome());
				d.setCognome(obj.getCognome());
				d.setMateria(obj.getMateria());
				
				String query = "UPDATE Docente SET"
						+ " nome = ?, "
						+ " cognome = ?, "
						+ " materia = ?"
						+ " WHERE docenteId = ?; ";
				
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1, d.getNome());
				ps.setString(2, d.getCognome());
				ps.setString(3, d.getMateria());
				ps.setInt(4,  d.getId());
				
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
			
			String query = "DELETE FROM Docente WHERE docenteId = ?";
			
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
	public Docente getById(int id) {
		// TODO Auto-generated method stub
		Docente docente = null; // Inizializza a null, verrà popolato se trovato
		
		try {
			Connection conn = ConnectionSingleton.getInstance().getConnection();
			
			String query = "SELECT docenteId, nome, cognome, materia from Docente where docenteId = ?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, id); // Imposta il parametro 'id' nella query
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) { // Se viene trovato un risultato
				docente = new Docente();
				docente.setId(rs.getInt("docenteId"));
				docente.setNome(rs.getString("nome"));
				docente.setCognome(rs.getString("cognome"));
				docente.setMateria(rs.getString("materia"));
			}
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return docente;
	}

	@Override
	public List<Docente> getAll() {
		// TODO Auto-generated method stub
		List<Docente> elenco = new ArrayList<Docente>();
		try {
			Connection conn = ConnectionSingleton.getInstance().getConnection();
			String query = "SELECT docenteId, nome, cognome, materia FROM docente;";
			//? placeholder, successivamente ti darò l'informazione
			PreparedStatement ps = conn.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Docente d = new Docente();
				d.setId(rs.getInt("docenteId"));
				d.setNome(rs.getString("nome"));
				d.setCognome(rs.getString("nome"));
				d.setMateria(rs.getString("materia"));
				
				elenco.add(d);
			}
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return elenco;
	}

}
