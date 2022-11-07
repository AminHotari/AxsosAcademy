<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Edit My Task</title>
</head>
<body>
	<div class="body">
	<form:form action="/expenses/${expenseEdit.id}" method="post" modelAttribute="expense">
		<input type="hidden" name="_method" value="put">
		<h2>Edit Expense:</h2>
		<a href="">Go back</a>
		<table>
			<tr class="in">
				<td><form:label path="name1">Expense Name:</form:label></td>
				<td><form:errors path="name1"/></td>
				<td><form:input path= "name1" value="${expenseEdit.name1}"/></td>
			</tr>
			<tr class="in">
				<td><form:label path="vendor">Vendor:</form:label></td>
				<td><form:errors path="vendor"></form:errors></td>
				<td><form:input path= "vendor" value="${expenseEdit.vendor}"/></td>
			</tr>
			<tr class="in">
				<td><form:label path="amount">Amount:</form:label></td>
				<td><form:errors path="amount"></form:errors></td>
				<td><form:input path= "amount" value="${expenseEdit.amount}"/></td>
			</tr>
			<tr class="in">
				<td><form:label path="description">Description:</form:label></td>
				<td><form:errors path="description"></form:errors></td>
				<td><form:textarea path="description" cols="20" rows="5" placeholder="${expenseEdit.description}"></form:textarea></td>
			</tr>
		</table>
		<input type="submit" value="Submit">
	</form:form>
	</div>
</body>
</html>