<%@page import="in.ashish.library.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update account</title>
</head>
<body>
	<%if(session.getAttribute("loginSuccess") != null){ %>
		<%User u = (User)session.getAttribute("loginSuccess"); %>
	
		    <h1>Update Profile</h1>
              <br><br>  
             <%if(request.getAttribute("fail") != null){ %>
			<h3 class = "error" style="color: red"><%= request.getAttribute("fail") %></h3>
			<%} %>
			<br><br>
    <form action="updateUser" method="post">
        <label for="name">Username:</label>
        <input type="text" id="name" name="name" value="<%=u.getName() %>" required><br><br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="<%=u.getEmail() %>" required><br><br>
        <label for="phone">Phone Number:</label>
        <input type="tel" id="phone" name="phone" value = "<%=u.getPhone()  %>" required><br><br>
        <input type="submit" value="Update">
    </form>
    <%}else{
	
      	request.setAttribute("fail", "session expired..!");
      	RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
      	rd.forward(request, response);
	} %>
</body>
</html>