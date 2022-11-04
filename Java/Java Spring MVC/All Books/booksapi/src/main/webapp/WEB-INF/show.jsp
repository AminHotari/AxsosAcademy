<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Insert title here</title>
</head>
<body>
	<h1>${book.title }</h1>
	<h3>Description:${book.description } </h3>
	<h3>Language: ${book.language } </h3>
	<h3>Number of Pages: ${book.numberOfPages } </h3>

</body>
</html>