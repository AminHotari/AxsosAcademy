<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Project Manager Dashboard</title>
<link rel="stylesheet" type="text/css" href="/css/home.css">
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<header>
		<h2>Welcome, ${thisUser.firsName}!</h2>
		<a href="/logout" class="head">log out</a>
	</header>
	<main>
		<div class="top">
			<p>All Projects</p>
			<form action="/projects/new">
				<input type="submit" value="+ new project">
			</form>
		</div>
		<table class="table table-bordered">
		<tr>
			<th>Project</th>
			<th>Team Lead</th>
			<th>Due Date</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="project" items="${projects}">
		<tr>
			<td><a href="/projects/${project.id}">${project.title}</a></td>
			<td>${project.userCreate.firsName}</td>
			<td>${project.dueDate}</td>
			<td>
				<a href="/join/${project.id}">Join Team</a>
			</td>
		</tr>
		</c:forEach>
	</table>
	
	<p>Your Projects</p>
	<table class="table table-bordered">
		<tr>
			<th>Project</th>
			<th>Lead</th>
			<th>Due Date</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="project" items="${project}">
		<tr>
			<td><a href="/projects/${project.id}">${project.title}</a></td>
			<td>${project.userCreate.firsName}</td>
			<td>${project.dueDate}</td>
			<td>
				<c:choose>				
					<c:when test="${project.userCreate.id == thisUser.id }">
						<a href="/projects/edit/${project.id}">edit</a>
					</c:when>
					<c:otherwise>
						<a href="/leave/${project.id}">Leave Team</a>
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
		</c:forEach>
	</table>
		
		
	</main>
</body>
</html>