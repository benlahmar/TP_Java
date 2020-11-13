package com.dao;

import java.time.LocalDate;

import com.model.User;

public class Test {

	public static void main(String[] args)  {
		
		UserDao um=new UserDao();
//		int nb=um.adduser("beta", "beta", "xx", "xx", LocalDate.now());
//		System.out.println(nb);
		User u = um.authentification("xfx", "xx");
		if(u!=null)
			System.out.println("Bonjour Mr   "+u.getNom());
		else
			System.out.println("login ou pass incorrect...!");
	}

}
