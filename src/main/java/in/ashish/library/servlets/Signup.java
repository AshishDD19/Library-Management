package in.ashish.library.servlets;

import java.io.IOException;

import in.ashish.library.dao.UserDAO;
import in.ashish.library.dao.UserDAOImpl;
import in.ashish.library.dto.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class Signup extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User u = new User();
		UserDAO dao = new UserDAOImpl();
		
		u.setName(req.getParameter("name"));
		u.setEmail(req.getParameter("email"));
		u.setPhone(Long.parseLong(req.getParameter("phone")));
		if(req.getParameter("pass").equals(req.getParameter("confirm"))) {
			u.setPass(req.getParameter("pass"));
			boolean res = dao.insertUser(u);
			if(res) {
				req.setAttribute("success", "Registered");
				RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
				rd.forward(req, resp);
			}
			else {
				req.setAttribute("fail", "failed to register..!");
				RequestDispatcher rd = req.getRequestDispatcher("signup.jsp");
				rd.forward(req, resp);
			}
			
		}
		else {
			req.setAttribute("fail", "Password mismatch..!");
			RequestDispatcher rd = req.getRequestDispatcher("signup.jsp");
			rd.forward(req, resp);
		}
				
	}

}
