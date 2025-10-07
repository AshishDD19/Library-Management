package in.ashish.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import in.ashish.library.connection.Connector;
import in.ashish.library.dto.User;

public class UserDAOImpl implements UserDAO {

	private Connection con;
	public UserDAOImpl() {
		// TODO Auto-generated constructor stub
		this.con = Connector.requestConnection();
	}
	@Override
	public boolean insertUser(User u) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		String query = "INSERT INTO USER VALUES (0,?,?,?,?)";
		int i=0;
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, u.getName());
			ps.setString(2, u.getPass());
			ps.setString(3, u.getEmail());
			ps.setLong(4, u.getPhone());
			
			i = ps.executeUpdate();
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i > 0) {
			return true;
		}
		else {
			return false;
		}
		
		
	}

	@Override
	public boolean updateUser(User u) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		String query = "UPDATE USER SET NAME=?, PASSWORD=?, EMAIL=?,PHONE=?  WHERE USER_ID=? ";
		int i=0;
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, u.getName());
			ps.setString(2, u.getPass());
			ps.setString(3, u.getEmail());
			ps.setLong(4, u.getPhone());
			
			ps.setInt(5, u.getUserId());
			
			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(i > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean deleteUser(int userId) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		String query = "DELETE FROM USER WHERE USER_ID = ?";
		int i = 0;
		try {
			ps = con.prepareStatement(query);
			ps.setInt(1, userId);
			
			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i>0) {
			return true;
			
		}
		else {
			return false;
		}
	
		
	}

	@Override
	public User getUser(String email, String pass) {
		// TODO Auto-generated method stub
		User u = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "SELECT * FROM USER WHERE EMAIL=? AND PASSWORD=?";
		
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, pass);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				u = new User();
				u.setUserId(rs.getInt("user_id"));
				u.setName(rs.getString("name"));
				u.setPass(rs.getString("password"));
				u.setEmail(rs.getString("email"));
				u.setPhone(rs.getLong("phone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public User getUser(long phone, String email) {
		// TODO Auto-generated method stub
		User u = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "SELECT * FROM USER WHERE EMAIL=? AND PHONE=?";
		
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, email);
			ps.setLong(2, phone);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				u = new User();
				u.setUserId(rs.getInt("user_id"));
				u.setName(rs.getString("name"));
				u.setPass(rs.getString("password"));
				u.setEmail(rs.getString("email"));
				u.setPhone(rs.getLong("phone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public ArrayList<User> getUser() {
		// TODO Auto-generated method stub
		User u = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<User> list = new ArrayList<User>();
		
		String query = "SELECT * FROM USER";
		try {
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()) {
				u =  new User();
				u.setUserId(rs.getInt("user_id"));
				u.setName(rs.getString("name"));
				u.setPass(rs.getString("password"));
				u.setEmail(rs.getString("email"));
				u.setPhone(rs.getLong("phone"));
				
				list.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
