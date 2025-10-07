<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>login page</title>
</head>
<body>
    <h1>Login Page</h1>
    
                   
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
			
    <form action="login" method="post">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>
        <label for="pass">Password:</label>
        <input type="password" id="pass" name="pass" required><br><br>
        <input type="submit" value="Login">
    </form>
    <p>Don't have an account? <a href="signup.jsp">Register here</a></p>
</body>
</html>