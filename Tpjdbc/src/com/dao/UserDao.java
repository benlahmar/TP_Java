/**
 * 
 */
package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import com.model.User;

/**
 * @author moi
 *
 */
public class UserDao implements IDao {

	@Override
	public int adduser(String nom, String prenom, String log, String pass, LocalDate date) {
		DBInteraction.connect();
		
		String sql="insert into user values(null,'"+nom+"','"+prenom+"','"+log+"','"+pass+"','"+LocalDate.now()+"')";
		int nb=DBInteraction.Maj(sql);
		DBInteraction.disconnect();
		return nb;
	}

	@Override
	public int adduser(User u) {
		DBInteraction.connect();
		
		String sql="insert into user values(null,'"+u.getNom()+"','"+u.getPrenom()+"','"+u.getLog()+"','"+u.getPass()+"','"+u.getDate()+"')";
		int nb=DBInteraction.Maj(sql);
		DBInteraction.disconnect();
		return nb;
	}

	@Override
	public User authentification(String log, String pass) {
		User u=null;
		DBInteraction.connect();
		String sql="select * from user where log='"+log+"' and pass='"+pass+"'";
		ResultSet rs = DBInteraction.Select(sql);
		try {
			if(rs.next())
			{
				u=new User(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), LocalDate.parse(rs.getDate(6).toString()));
				u.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBInteraction.disconnect();
		return u;
	}

}
