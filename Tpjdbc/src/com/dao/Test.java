package com.dao;

import java.time.LocalDate;

import com.model.User;

public class Test {

	public static void main(String[] args)  {
		UserManager um=new UserManager();
		//int nb=um.adduser("fff", "bbb", "eee", "ddd", LocalDate.now());
		//System.out.println(nb);

	User us = um.authentificate("eee", "ddd");
	if(us!=null)
		System.out.println("Bonjour Mr "+us.getNom());
	else
		System.err.println("login ou password incorrect..!");
	}

}
