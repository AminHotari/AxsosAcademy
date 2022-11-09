<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Login & Registration</title>
<link rel="stylesheet" type="text/css" href="/css/loginRegistration.css">
</head>
<body>
	<header>
		<h1>Welcome!</h1>
		<p>Join our growing community</p>
	</header>
	<main>
        <div class="form">
            <h2>Register</h2>
            <br><br>
            <form:form action="/register" method="post" modelAttribute="newUser">
                <table>
                    <tr>
                        <td><form:label path="userName">User Name:</form:label></td>
                        <td><form:errors path="userName"></form:errors></td>
                        <td><form:input path= "userName"/></td>                       						
                    </tr>
                    <tr>
                        <td><form:label path="email">Email:</form:label></td>
                        <td><form:input path="email"/></td>
                        <td><form:errors path="email"></form:errors></td>
                    </tr>
                    <tr>
                        <td><form:label path="password">Password:</form:label></td>
                        <td><form:input path="password"/></td>
                        <td><form:errors path="password"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="confirm">Confirm PW:</form:label></td>
                        <td><form:input path="confirm"/></td>
                        <td><form:errors path="confirm"/></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Submit" class="submit"></label></td>
                    </tr>
                </table>
            </form:form>
        </div>
        <div class="vertical"></div>
        <div class="form">
            <h2>Log in</h2>
            <br><br>
            <form:form action="/login" method="post" modelAttribute="newLogin">
                <table>                                      
                    <tr>
                        <td><form:label path="email">Email:</form:label></td>
                        <td><form:input path="email"/></td>
                        <td><form:errors path="email"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="password">Password:</form:label></td>
                        <td><form:input path="password"/></td>
                        <td><form:errors path="password"/></td>                  
                    <tr>
                        <td><input type="submit" value="Submit" class="submit"></label></td>
                    </tr>
                </table>
            </form:form>
        </div>
    </main>
</body>
</html>