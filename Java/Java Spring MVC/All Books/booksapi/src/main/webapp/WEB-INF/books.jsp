<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Read Share</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/allBook.css"/>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/app1.js"></script>
</head>
<body>
	<table class="table table-bordered">
		<thead>		
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Language</th>
				<th>Number of pages</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var= "theBook" items="${books1}" >
			<tr>
				<td>${theBook.id }</td>
				<td><a href="/books/${theBook.id}">${theBook.title }</a> </td>
				<td>${theBook.language }</td>
				<td>${theBook.numberOfPages }</td>
			
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>