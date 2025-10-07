package in.ashish.library.servlets;

import java.io.IOException;

import in.ashish.library.dao.UserDAO;
import in.ashish.library.dao.UserDAOImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/deleteUser")
public class DeleteUser extends HttpServlet{
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession(false);
		if(session != null) {
			UserDAO dao = new UserDAOImpl();
			int id = Integer.parseInt(req.getParameter("id")) ;
			boolean res = dao.deleteUser(id);
			
			if(res) {
		      	req.setAttribute("success", "deleted user");
		      	RequestDispatcher rd = req.getRequestDispatcher("viewAllUsers.jsp");
		      	rd.forward(req, resp);
			}
			else {
		      	req.setAttribute("fail", "unable to delete");
		      	RequestDispatcher rd = req.getRequestDispatcher("viewAllUsers.jsp");
		      	rd.forward(req, resp);
			}
		}
		else {
			
	      	req.setAttribute("fail", "session expired..!");
	      	RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
	      	rd.forward(req, resp);
		}
	}
}
