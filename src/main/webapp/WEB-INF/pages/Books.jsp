<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Book Management Screen</title>
</head>
<body>
    <div align="center">
        <h1>Book Depository</h1>
        <h3>
            <a href="newBook">New Book</a>
        </h3>
        <table border="1">
 
            <th>Title</th>
            <th>Author</th>
            <th>Type</th>
            <th>Borrower</th>
            <th>Action</th>
 
            <c:forEach var="book" items="${listBook}">
                <tr>
 
                    <td>${book.title}</td>
                    <td>${book.author}</td>
                    <td>${book.type}</td>
                    <td>${book.borrower}</td>
                    <td><a href="editBook?id=${book.id}">Edit</a>
                             <a
                        href="deleteBook?id=${book.id}">Delete</a></td>
 
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>