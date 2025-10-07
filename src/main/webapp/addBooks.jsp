<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add books page</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<%if(session.getAttribute("loginSuccess") != null){ %>	  
             <%if(request.getAttribute("success") != null){ %>
			<h3 class = "error" style="color: green"><%= request.getAttribute("success") %></h3>
			<%} %>
			    <%if(request.getAttribute("fail") != null){ %>
			<h3 class = "error" style="color: red"><%= request.getAttribute("fail") %></h3>
			<%} %>
    <form action="addBooks" method="post">
        <label for="title">Book Title:</label>
        <input type="text" id="title" name="title" required><br><br>
        <label for="author">Author:</label>
        <input type="text" id="author" name="author" required><br><br>
        <input type="submit" value="Add Book">
    </form>
    <%}else{
	
      	request.setAttribute("fail", "session expired..!");
      	RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
      	rd.forward(request, response);
	} %>
</body>
</html>