<%@page import="in.ashish.library.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>header</title>
</head>

<body>
    <header>
        <h1>Library Management System</h1>
        <nav>
        <%if(session.getAttribute("loginSuccess") != null) { %>
        	<% User u = (User)session.getAttribute("loginSuccess");%>
            <!-- admin -->
            <%if(u.getUserId()==1){ %>
            <a href="viewAllUsers.jsp">View All Users</a>|
            <a href="addBooks.jsp">Add Books</a> |
            <a href="updateBooks.jsp">update Books</a> |
			<%} %>

            <!-- user  -->
            <a href="viewAllBooks.jsp">View All Books</a> |
			<form action="searchBooks" method = "post" >
				<input type="text" name="bookname"  placeholder="Search Books">
				<input type="submit" value="Seacrh" style="background-color: blue">
			</form>



            <a href="home.jsp">Home</a> |
 
            <a href="update.jsp">Update Profile</a>
            <form action="logout" method="post">
                <input type="submit" value="Logout" style="background-color: red;">
            </form>
          <%}else{%>
              <a href="login.jsp">Login</a> |
              <a href="signup.jsp">Sign Up</a>
          <%} %>
      	
        </nav>
        <hr>
    </header>
</body>

</html>