<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>${languageEdit.name}</title>
</head>
<body>
	<a href="/languages">Dashboard</a>
	<form action="/languages/${languageEdit.id}" method="post">		
		<input type="hidden" name="_method" value="delete"><input type="submit" value="delete">
	</form>
	
	<form:form action="/languages/${languageEdit.id}" method="post" modelAttribute="language">
		<input type="hidden" name="_method" value="put">
		<h2>Edit Expense:</h2>
		<table>
			<tr class="in">
				<td><form:label path="name">Name:</form:label></td>
				<td><form:errors path="name"/></td>
				<td><form:input path= "name" value="${languageEdit.name}"/></td>
			</tr>
			<tr class="in">
				<td><form:label path="creator">Creator:</form:label></td>
				<td><form:errors path="creator"></form:errors></td>
				<td><form:input path= "creator" value="${languageEdit.creator}"/></td>
			</tr>
			<tr class="in">
				<td><form:label path="version">Version:</form:label></td>
				<td><form:errors path="version"></form:errors></td>
				<td><form:input path= "version" value="${languageEdit.version}"/></td>
			</tr>
		</table>
		<input type="submit" value="Submit">
	</form:form>
</body>
</html>