<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Omikuji</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<h1>Send an Omikuji!</h1>
	<form action="/omikuji" method="post">
    <label for="number">Pick any number from 5 to 25</label>
    <input type="number" name="number" min="5" max="25">

    <label for="city">Enter the name of any city.</label>
    <input type="text" name="city">

    <label for="person">Enter the name of any real person.</label>
    <input type="text" name="person">

    <label for="hobby">Enter professional endeavor or hobby.</label>
    <input type="text" name="hobby">

    <label for="living">Enter any type of living thing.</label>
    <input type="text" name="living">

    <label for="comment">Say something nice to someone:</label>
    <textarea name="comment" id="" cols="20" rows="5"></textarea>

    <label for="send">Send and show a friend</label>
    <input type="submit" value="Send" class="submit">
    </form>
</body>
</html>