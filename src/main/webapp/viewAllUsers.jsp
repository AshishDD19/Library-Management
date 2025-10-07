<%@page import="in.ashish.library.dto.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="in.ashish.library.dao.UserDAOImpl"%>
<%@page import="in.ashish.library.dao.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View all users</title>
</head>
<body>
	<%if(session.getAttribute("loginSuccess") != null){ %>
	<%UserDAO dao = new UserDAOImpl();%>
	<%ArrayList<User> ul = dao.getUser();%>
    <div class="heading">
            <h2>View All Users</h2>
            
            
     </div>
                        
             <%if(request.getAttribute("fail") != null){ %>
             <br><br> 
			<h3 class = "error" style="color: red"><%= request.getAttribute("fail") %></h3>
			<br><br> 
			<%} %>

             <%if(request.getAttribute("success") != null){ %>
			<br><br> 
			<h3 class = "error" style="color: green"><%= request.getAttribute("success") %></h3>
			<br><br>
			<%} %>
        <div class="users">
            <table border="1" >
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Phone</th>
                        <th>Mail</th>
                        <th>Remove</th>
                    </tr>

                </thead>
                <tbody>
                <%for(User u : ul){ %>
                    <tr>
                        <td><%=u.getUserId() %></td>
                        <td><%=u.getName() %></td>
                        <td><%=u.getPhone() %></td>
                        <td><%=u.getEmail() %></td>
                        <td><form action="deleteUser" method="post">
                                <input type="hidden" name="id" value="<%=u.getUserId() %>">
                                <input type="submit" value="Remove" id="btn">
                            </form>
                        </td>
                    </tr>
                   <%} %>
                </tbody>
            </table>
        </div>
        <%}else{
        	
          	request.setAttribute("fail", "session expired..!");
          	RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
          	rd.forward(request, response);
        }%>
       
</body>
</html>