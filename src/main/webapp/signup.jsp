<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>signup page</title>
</head>
<body>
    <h1>Signup Page</h1>
              <br><br>  
             <%if(request.getAttribute("fail") != null){ %>
			<h3 class = "error" style="color: red"><%= request.getAttribute("fail") %></h3>
			<%} %>
			<br><br>
    <form action="signup" method="post">
        <label for="name">Username:</label>
        <input type="text" id="name" name="name" required><br><br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>
        <label for="phone">Phone Number:</label>
        <input type="tel" id="phone" name="phone" required><br><br>
		<label for="pass">Password:</label>
        <input type="password" id="pass" name="pass" required><br><br>
        <label for="confirm">Confirm Password:</label>
        <input type="password" id="confirm" name="confirm" required><br><br>
        <input type="submit" value="Sign Up">
    </form>
    <p>Already have an account? <a href="login.jsp">Login here</a></p>
</body>
</html>