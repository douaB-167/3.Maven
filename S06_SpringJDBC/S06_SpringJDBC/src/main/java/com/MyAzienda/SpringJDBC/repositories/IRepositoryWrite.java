package com.MyAzienda.SpringJDBC.repositories;

public interface IRepositoryWrite<T> {
	
	//Scrittura -> Data Manipulation Language
	boolean create(T obj);
	boolean update(T obj);
	boolean delete(int id);

}
