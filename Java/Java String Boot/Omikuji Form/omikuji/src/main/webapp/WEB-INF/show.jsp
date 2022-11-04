<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<h1>Here's Your Omikuji</h1>
	<div class= "comment">
		<p>In <span>${number}</span> years, you will <br>
			live in <span></span>${city} with <br>
			<span>${person}</span> as your <br>
			roommate, <span>${hoppy}</span> <br>
			for a living. <br>
			The next time you<br>
			see a <span>${living}</span>, you will<br>
			have good luck.<br>
			Also, <span>${comment}</span> .<br>
		</p>
	</div>
	<div class="back"><a href="/" >Go Back</a></div>
</body>
</html>