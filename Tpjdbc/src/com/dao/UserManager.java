package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.model.Invitation;
import com.model.User;

public class UserManager implements IDao {

	@Override
	public int adduser(String nom, String prenom, String log, String pass, LocalDate date) {
		DBInteraction.connect();
		String sql="insert into user values(null,'"+nom+"','"+prenom+"','"+log+"','"+pass+"','"+date+"')";
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
		ResultSet rs = DBInteraction.Select("select * from user where log='"+log+ "' and pass='"+pass+"'");
		try {
			if(rs.next())
			{
				u=new User(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),LocalDate.parse(rs.getDate(6).toString()));
				u.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public int updatepassword(String pass, int idu) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> allUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isLogExist(String log) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int inviter(int idus, int idur) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int inviter(User us, User ur) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int accpter(int idr, int ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Invitation> invitations(int idu) {
		// TODO Auto-generated method stub
		return null;
	}

}
