<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Read Share</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="head">
	<h1>Save Travels</h1>
	<table class="table table-bordered">
		<tr>
			<th>Expense</th>
			<th>Vendor</th>
			<th>Amount</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="ex" items="${expenses1}">
		<tr>
			<td><a href="/expenses/${ex.id}"><c:out value="${ex.name1}"></c:out></a></td>
			<td><c:out value="${ex.vendor}"></c:out></td>
			<td>$<c:out value="${ex.amount}"></c:out></td>
			<td><a href="/expenses/edit/${ex.id}">edit</a> | <form action="/expenses/${ex.id}" method="post">
			<input type="hidden" name="_method" value="delete"><input type="submit" value="delete"></form></td>
		</tr>
		</c:forEach>
	</table>
	</div>
	<div class="body">
	<form:form action="/expenses" method="post" modelAttribute="expense">
		<h2>Add an expense:</h2>
		<table>
			<tr class="in">
				<td><form:label path="name1">Expense Name:</form:label></td>
				<td><form:errors path="name1"/></td>
				<td><form:input path= "name1"/></td>
			</tr>
			<tr class="in">
				<td><form:label path="vendor">Vendor:</form:label></td>
				<td><form:errors path="vendor"></form:errors></td>
				<td><form:input path= "vendor"/></td>
			</tr>
			<tr class="in">
				<td><form:label path="amount">Amount:</form:label></td>
				<td><form:errors path="amount"></form:errors></td>
				<td><form:input path= "amount"/></td>
			</tr>
			<tr class="in">
				<td><form:label path="description">Description:</form:label></td>
				<td><form:errors path="description"></form:errors></td>
				<td><form:textarea path="description" cols="20" rows="5"></form:textarea></td>
			</tr>
		</table>
		<input type="submit" value="Submit">
	</form:form>
	</div>
</body>
</html>