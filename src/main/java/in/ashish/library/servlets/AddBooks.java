package in.ashish.library.servlets;

import java.io.IOException;

import in.ashish.library.dao.BooksDAO;
import in.ashish.library.dao.BooksDAOImpl;
import in.ashish.library.dto.Books;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/addBooks")
public class AddBooks extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession(false);
		if(session != null) {
			Books b = new Books();
			BooksDAO dao = new BooksDAOImpl();
			
			b.setBookTitle(req.getParameter("title"));
			b.setAuthor(req.getParameter("author"));
			
			boolean res = dao.insertBook(b);
			if(res) {
		      	req.setAttribute("success", "Book added");
		      	RequestDispatcher rd = req.getRequestDispatcher("addBooks.jsp");
		      	rd.forward(req, resp);
			
			}
			else {
		      	req.setAttribute("fail", "unable to add..!");
		      	RequestDispatcher rd = req.getRequestDispatcher("addBooks.jsp");
		      	rd.forward(req, resp);
			}
			
		}
		else{
	
		    	
	      	req.setAttribute("fail", "session expired..!");
	      	RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
	      	rd.forward(req, resp);
		
		}
	}
}
