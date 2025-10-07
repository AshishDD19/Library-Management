package in.ashish.library.servlets;

import java.io.IOException;
import java.util.ArrayList;

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
@WebServlet("/searchBooks")
public class SearchBooks extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession(false);
		if(session != null) {
			BooksDAO dao = new BooksDAOImpl();
			String name = req.getParameter("bookname");
			
			ArrayList<Books> bList = dao.getBooks(name);
			if(!bList.isEmpty()) {
				req.setAttribute("bookList", bList);
				RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
				rd.forward(req, resp);
			}
			else {
				req.setAttribute("fail", "no such books");
				RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
				rd.forward(req, resp);
			}
			
		}else {
			req.setAttribute("fail", "session expired");
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
		}
	}
}
