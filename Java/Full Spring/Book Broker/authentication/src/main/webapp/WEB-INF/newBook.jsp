<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Book Share</title>
</head>
<body>
	<header>
		<h2>Add a Book to Your Shelf!</h2>
		<a href="/books">back to the shelves</a>
	</header>
	<form:form action="/addBook" method="post" modelAttribute="addBook">
                <table>
                    <tr>
                    	<td><form:label path="title">Title:</form:label></td>
                        <td><form:input path="title"/></td>
                        <td><form:errors path="title"></form:errors></td>                      						
                    </tr>
                    <tr>
                        <td><form:label path="authorName">Author:</form:label></td>
                        <td><form:input path="authorName"/></td>
                        <td><form:errors path="authorName"></form:errors></td>
                    </tr>
                    <tr>
                        <td><form:label path="description">My thoughts:</form:label></td>
                        <td><form:input path="description"/></td>
                        <td><form:errors path="description"/></td>
                    </tr>                                                                  
                </table>
                <input type="submit" value="Submit" class="submit">
            </form:form>
</body>
</html>