<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Ninja Gold Game</title>
<link rel="stylesheet" type="text/css" href="/css/index.css">
</head>
<body>
	<header>
        <h3>Your Gold:</h3>
        <input type="text" value= "${gold}">
    </header>
    <main>
        <form action="/process" method="post">
            <h4>Farm</h4>
            <p>(earns 10-20 gold)</p>
            <input type="submit" value="Find Gold!" class="find">
            <input type="hidden" name="find" value="farm">
        </form>
        <form action="/process" method="post">
            <h4>Cave</h4>
            <p>(earns 10-20 gold)</p>
            <input type="submit" value="Find Gold!" class="find">
            <input type="hidden" name="find" value="cave">
        </form>
        <form action="/process" method="post">
            <h4>House</h4>
            <p>(earns 10-20 gold)</p>
            <input type="submit" value="Find Gold!" class="find">
            <input type="hidden" name="find" value="house">
        </form>
        <form action="/process1" method="post">
            <h4>Quest</h4>
            <p>(earns/takes 0-50 gold)</p>
            <input type="submit" value="Find Gold!" class="find">
            <input type="hidden" name="find" value="quest">
        </form>

    </main>
    <footer>
        <h4>Activities:</h4>
        <textarea name="" id="" cols="110" rows="7" class="text">
        	<c:forEach var="active" items="${activites}">
        		<c:out value="${active}"></c:out> 	
        	</c:forEach>
        </textarea>
    </footer>
</body>
</html>