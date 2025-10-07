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
@WebServlet("/deleteBooks")
public class DeleteBooks extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession(false);
		if(session != null) {
			
			BooksDAO dao = new BooksDAOImpl();
			
			int id = Integer.parseInt(req.getParameter("id")) ;
			
			boolean res = dao.deleteBook(id);
			if(res) {
		      	req.setAttribute("success", "Book deleted");
		      	RequestDispatcher rd = req.getRequestDispatcher("viewAllBooks.jsp");
		      	rd.forward(req, resp);
			
			}
			else {
		      	req.setAttribute("fail", "unable to delete..!");
		      	RequestDispatcher rd = req.getRequestDispatcher("viewAllBooks.jsp");
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
