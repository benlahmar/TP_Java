package com.dao;


public class Test {

	public static void main(String[] args)  {
		String sql="insert into user values(0,'koko','uu','log','pass','2014-02-10')";
		DBInteraction.connect();
		int nb=DBInteraction.Maj(sql);
		DBInteraction.disconnect();
System.out.println(nb);
	}

}
