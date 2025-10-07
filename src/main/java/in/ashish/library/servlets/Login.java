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
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDAO dao = new UserDAOImpl();
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		
		User u = dao.getUser(email, pass);
		
		if(u != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("loginSuccess", u);
			
			req.setAttribute("success", "Login success");
			RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
			rd.forward(req, resp);
		}else {
			req.setAttribute("fail", "Invalid login credentials");
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
		}
	}
}
