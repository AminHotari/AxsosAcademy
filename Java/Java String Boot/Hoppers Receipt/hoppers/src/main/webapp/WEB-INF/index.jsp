<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Simple Receipt</title>
</head>
<body>
	<h1>Customer Name: <c:out value="${customerName}" /></h1>
	<p>Item name: <c:out value="${itemName}" ></c:out></p>
	<p>Price:$ <c:out value="${price}" ></c:out></p>
	<p>Description: <c:out value="${description}" ></c:out></p>
	<p>Vendor: <c:out value="${vendor}" /></p>
</body>
</html>