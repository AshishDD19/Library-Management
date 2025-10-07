package in.ashish.library.dao;


import java.util.ArrayList;

import in.ashish.library.dto.Books;

public interface BooksDAO {
	public boolean insertBook(Books b);
	public boolean updateBook(Books b);
	public boolean deleteBook(int bookId);
	public ArrayList<Books> getBooks();
	public ArrayList<Books> getBooks(String name);
	public ArrayList<Books> getBooks(int bookId);
	public ArrayList<Books> getAllBorrowed();
}
