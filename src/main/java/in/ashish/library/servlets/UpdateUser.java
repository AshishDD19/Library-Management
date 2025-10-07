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
@WebServlet("/updateUser")
public class UpdateUser extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession(false);
		
		if(session.getAttribute("loginSuccess") != null) {
			User u = (User)session.getAttribute("loginSuccess");
			UserDAO dao = new UserDAOImpl();
			u.setName(req.getParameter("name"));
			u.setEmail(req.getParameter("email"));
			u.setPhone(Long.parseLong(req.getParameter("phone")));
			
			boolean res = dao.updateUser(u);
			if(res) {
				req.setAttribute("success", "updated succussfull");
				RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
				rd.forward(req, resp);
			}
			else {
				req.setAttribute("fail", "failed to update");
				RequestDispatcher rd = req.getRequestDispatcher("update.jsp");
				rd.forward(req, resp);
			}
			
		}
		else {
			req.setAttribute("fail", "session expired");
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
		}
		
	}

}
