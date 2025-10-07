package in.ashish.library.dao;

import java.util.ArrayList;

import in.ashish.library.dto.User;

public interface UserDAO {
	public boolean insertUser(User u);
	public boolean updateUser(User u);
	public boolean deleteUser(int userId);
	public User getUser(String email,String pass);
	public User getUser(long phone, String email);
	public ArrayList<User> getUser();
}
