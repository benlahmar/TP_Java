package com.dao;

import java.time.LocalDate;

import com.model.User;



public interface IDao {

	public int adduser(String nom,String  prenom, String  log,String  pass, LocalDate date);
	public int adduser(User u );
	public User authentification(String log,String pass);
	
}
