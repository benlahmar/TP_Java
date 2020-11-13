/**
 * 
 */
package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.model.Invitation;
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

	@Override
	public int updatepassword(String pass, int idu) {
		DBInteraction.connect();
		
		String sql="update user set pass='"+pass+"' where id="+idu;
		int nb=DBInteraction.Maj(sql);
		DBInteraction.disconnect();
		return nb;
	}

	@Override
	public List<User> allUsers() {
		List<User> us=new ArrayList<User>();
		DBInteraction.connect();
		ResultSet rs = DBInteraction.Select("select * from user");
		try {
			while(rs.next())
			{
				User u=new User(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), LocalDate.parse(rs.getDate(6).toString()));
				u.setId(rs.getInt(1));
				us.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBInteraction.disconnect();
		
		return us;
	}

	@Override
	public boolean isLogExist(String log) {
		boolean exist=false;
		DBInteraction.connect();
		ResultSet rs = DBInteraction.Select("select * from user where log='"+log+"'");
		try {
			
			if( rs.next()!=false)
				exist=true;
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return exist;
	}

	@Override
	public int inviter(int idus, int idur) {
		DBInteraction.connect();
		boolean us=false, ur=false;
		String sql2="select * from user where id="+idus;
		String sql3="select * from user where id="+idur;
		try {
			 us=DBInteraction.Select(sql2).next();
			 ur=DBInteraction.Select(sql3).next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int nb=0;
		if(us && ur) {
		String sql="insert into invitation(idusend ,idurecieve) values("+idus+","+idur+")";
		nb=DBInteraction.Maj(sql);
		}
		DBInteraction.disconnect();
		return nb;
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
