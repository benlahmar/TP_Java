package com.dao;

import java.time.LocalDate;
import java.util.List;

import com.model.Invitation;
import com.model.User;



public interface IDao {

	public int adduser(String nom,String  prenom, String  log,String  pass, LocalDate date);
	public int adduser(User u );
	public User authentification(String log,String pass);
	
	public int updatepassword(String pass, int idu);
	
	public List<User> allUsers();
	public boolean isLogExist(String log);
	
	
	
	public int inviter(int idus, int idur);
	
	public int inviter(User us, User ur);
	
	public int accpter(int idr, int ids);
	
	public List<Invitation> invitations(int idu);
	
	
}
