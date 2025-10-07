package in.ashish.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import in.ashish.library.connection.Connector;
import in.ashish.library.dto.Books;

public class BooksDAOImpl implements BooksDAO {
	private Connection con;
	
	public BooksDAOImpl() {
		// TODO Auto-generated constructor stub
		this.con = Connector.requestConnection();
	}
	
	@Override
	public boolean insertBook(Books b) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		String query = "INSERT INTO BOOKS VALUES (0,?,?,'NOT ISSUED')";
		int i=0;
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, b.getBookTitle());
			ps.setString(2, b.getAuthor());
			
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
	public boolean updateBook(Books b) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		String query = "UPDATE BOOKS SET BOOK_TITLE=?, AUTHOR=?, ISSUED=? WHERE BOOK_ID = ?";
		int i=0;
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, b.getBookTitle());
			ps.setString(2, b.getAuthor());
			ps.setString(3, b.getIssued());
			ps.setInt(4, b.getBookId());
			
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
	public boolean deleteBook(int bookId) {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		String query = "DELETE FROM BOOKS WHERE BOOK_ID=?";
		int i=0;
		try {
			ps = con.prepareStatement(query);
	
			ps.setInt(1,bookId);
			
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
	public ArrayList<Books> getBooks() {
		// TODO Auto-generated method stub
		ArrayList<Books> list = new  ArrayList<Books>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Books b = null;
		String query = "SELECT * FROM BOOKS";
		
		try {
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				b = new Books();
				b.setBookId(rs.getInt("book_id"));
				b.setBookTitle(rs.getString("book_title"));
				b.setAuthor(rs.getString("author"));
				b.setIssued(rs.getString("issued"));
				
				list.add(b);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ArrayList<Books> getBooks(String name) {
		// TODO Auto-generated method stub
		ArrayList<Books> list = new  ArrayList<Books>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Books b = null;
		String query = "SELECT * FROM BOOKS WHERE BOOK_TITLE=? OR AUTHOR=?";
		
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, name);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				b = new Books();
				b.setBookId(rs.getInt("book_id"));
				b.setBookTitle(rs.getString("book_title"));
				b.setAuthor(rs.getString("author"));
				b.setIssued(rs.getString("issued"));
				
				list.add(b);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ArrayList<Books> getBooks(int bookId) {
		// TODO Auto-generated method stub
		ArrayList<Books> list = new  ArrayList<Books>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Books b = null;
		String query = "SELECT * FROM BOOKS WHERE BOOK_ID=?";
		
		try {
			ps = con.prepareStatement(query);
			ps.setInt(1, bookId);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				b = new Books();
				b.setBookId(rs.getInt("book_id"));
				b.setBookTitle(rs.getString("book_title"));
				b.setAuthor(rs.getString("author"));
				b.setIssued(rs.getString("issued"));
				
				list.add(b);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ArrayList<Books> getAllBorrowed() {
		// TODO Auto-generated method stub
		ArrayList<Books> list = new  ArrayList<Books>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Books b = null;
		String query = "SELECT * FROM BOOKS WHERE ISSUED = 'ISSUED'";
		
		try {
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				b = new Books();
				b.setBookId(rs.getInt("book_id"));
				b.setBookTitle(rs.getString("book_title"));
				b.setAuthor(rs.getString("author"));
				b.setIssued(rs.getString("issued"));
				
				list.add(b);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
