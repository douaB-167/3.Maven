package com.MyAzienda.SpringJDBC.repositories;

import java.util.List;

public interface IRepositoryRead<T> {
	
	//Lettura -> Query dal DB
	T getById(int id);
	List<T> getAll();

}
