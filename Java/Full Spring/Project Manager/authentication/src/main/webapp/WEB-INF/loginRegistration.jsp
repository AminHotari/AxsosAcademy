<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Project Manager</title>
<link rel="stylesheet" type="text/css" href="/css/loginRegistration.css">
</head>
<body>
	<header>
		<h1>Project Manager</h1>
		<p>A place for teams to manage projects.</p>
	</header>
	<main>
        <div class="form">
            <h2>Register</h2>
            <br><br>
            <form:form action="/register" method="post" modelAttribute="newUser">
                <table>
                	<tr>
                        <td><form:label path="firsName">First Name:</form:label></td>
                        <td><form:input path="firsName"/></td>
                        <td><form:errors path="firsName"></form:errors></td>
                    </tr>
                    <tr>
                        <td><form:label path="lastName">Last Name:</form:label></td>
                        <td><form:input path="lastName"/></td>
                        <td><form:errors path="lastName"></form:errors></td>
                    </tr>                
                    <tr>
                        <td><form:label path="email">Email:</form:label></td>
                        <td><form:input path="email"/></td>
                        <td><form:errors path="email"></form:errors></td>
                    </tr>
                    <tr>
                        <td><form:label path="password">Password:</form:label></td>
                        <td><form:input path="password" type="password"/></td>
                        <td><form:errors path="password"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="confirm">Confirm PW:</form:label></td>
                        <td><form:input path="confirm" type="password"/></td>
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
                        <td><form:input path="password" type="password"/></td>
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