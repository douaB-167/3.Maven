package com.MyAzienda.SpringReposDAL.repositories;

import java.util.List;

public interface IRepository<T> {

	//Lettura -> Query dal DB
		T getById(int id);
		List<T> getAll();

	//Scrittura -> Data Manipulation Language
	boolean create(T obj);
	boolean update(T obj);
	boolean delete(int id);	
}
