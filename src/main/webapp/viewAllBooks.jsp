<%@page import="in.ashish.library.dto.Books"%>
<%@page import="java.util.ArrayList"%>
<%@page import="in.ashish.library.dao.BooksDAOImpl"%>
<%@page import="in.ashish.library.dao.BooksDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View all books</title>
</head>
<body>
	<%if(session.getAttribute("loginSuccess") != null){ %>
		<%BooksDAO dao = new BooksDAOImpl();%>
		<%ArrayList<Books> bl = dao.getBooks(); %>
    <div class="heading">
            <h2>View All Books</h2>
        </div>
        <div class="users">
            <table border="1" >
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Author</th>
                        <th>Remove</th>
                    </tr>

                </thead>
                <tbody>
                <%for(Books b : bl){ %>
                    <tr>
                        <td><%=b.getBookId() %></td>
                        <td><%=b.getBookTitle() %></td>
                        <td><%=b.getAuthor() %></td>
                        <td><form action="deleteBooks" method="post">
                                <input type="hidden" name="id" value="<%=b.getBookId()%>">
                                <input type="submit" value="Remove" id="btn" style="color: red">
                            </form>
                        </td>
                    </tr>
                  <%} %>
                </tbody>
            </table>
        </div>
    <%}else{
    	request.setAttribute("fail", "session expired..!");
    	RequestDispatcher rd  = request.getRequestDispatcher("login.jsp");
    	rd.forward(request, response);
    	}
    	%>
    
</body>
</html>