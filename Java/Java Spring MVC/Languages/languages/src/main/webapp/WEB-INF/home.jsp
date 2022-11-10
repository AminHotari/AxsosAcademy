<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<table class="table table-bordered">
		<tr>
			<th>Name</th>
			<th>Creator</th>
			<th>Version</th>
			<th>action</th>
		</tr>
		<c:forEach var="lang" items="${language1}">
		<tr>
			<td><a href="/languages/${lang.id}"><c:out value="${lang.name}"></c:out></a></td>
			<td><c:out value="${lang.creator}"></c:out></td>
			<td><c:out value="${lang.version}"></c:out></td>
			<td><a href="/languages/edit/${lang.id}">edit</a> | <form action="/languages/${lang.id}" method="post">
			<input type="hidden" name="_method" value="delete"><input type="submit" value="delete"></form></td>
		</tr>
		</c:forEach>
	</table>
	
	<form:form action="/languages" method="post" modelAttribute="language">
		<table>
			<tr class="in">
				<td><form:label path="name">Name:</form:label></td>
				<td><form:errors path="name"/></td>
				<td><form:input path= "name"/></td>
			</tr>
			<tr class="in">
				<td><form:label path="creator">Creator:</form:label></td>
				<td><form:errors path="creator"></form:errors></td>
				<td><form:input path= "creator"/></td>
			</tr>
			<tr class="in">
				<td><form:label path="version">Version:</form:label></td>
				<td><form:errors path="version"></form:errors></td>
				<td><form:input path= "version"/></td>
			</tr>
		</table>
		<input type="submit" value="Submit">
	</form:form>
</body>
</html>