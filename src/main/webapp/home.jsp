<%@page import="in.ashish.library.dto.Books"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home page</title>
</head>
<body>
	<%@ include file="header.jsp" %>
				 <br><br>  
             <%if(request.getAttribute("success") != null){ %>
			<h3 class = "error" style="color: green"><%= request.getAttribute("success") %></h3>
			<%} %>
			 <%if(request.getAttribute("fail") != null){ %>
			<h3 class = "error" style="color: red"><%= request.getAttribute("fail") %></h3>
			<%} %>
			
			<h1>Library Management</h1>
			<%if(session.getAttribute("loginSuccess") != null){ %>
				<%User u = (User)session.getAttribute("loginSuccess"); %>
					<%if(u.getUserId() == 1){%>
					<h1>Welcome <%=u.getName() %> (Admin)</h1>
					<%}else{ %>
					<h1>Welcome <%=u.getName() %></h1>
					<%} %>
			<%}%>
			
			
			<%if(session.getAttribute("loginSuccess") != null){ %>
				<%if(request.getAttribute("bookList") != null){ %>
				<h1>Search books</h1>
				
				<%ArrayList<Books> bl = (ArrayList<Books>)request.getAttribute("bookList"); %>
				<table border="1">
					<thead>
						<tr>
							<th>Book Id</th>
							<th>Book Title</th>
							<th>Author</th>
						</tr>
					</thead>
					<tbody>
						<%for(Books b:bl){%>
							<tr>
								<td><%=b.getBookId() %></td>
								<td><%=b.getBookTitle() %></td>
								<td><%=b.getAuthor() %></td>
							</tr>
						<%} %>
					</tbody>
				</table>
				<%} %>
			<%}%>
	
</body>
</html>