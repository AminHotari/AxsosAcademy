<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>${show.name}</title>
</head>
<body>
	<a href="/languages">Dashboard</a>
	<p><c:out value ="${show.name}"/></p>
	<p><c:out value="${show.creator}"/></p>
	<p><c:out value="${show.version}"/></p>
	<a href="/languages/edit/${show.id}">edit</a>
	<form action="/languages/${show.id}" method="post">		
		<input type="hidden" name="_method" value="delete"><input type="submit" value="delete">
	</form>
</body>
</html>