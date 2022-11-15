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
	<h2>Edit Project</h2>
	<form:form action="/projects/edit/${editProject.id}" method="post" modelAttribute="editProject">
		<input type="hidden" name="_method" value="put">
        <table>
            <tr>
            	<td><form:label path="title">Project Title:</form:label></td>
                <td><form:input path="title" value="${editProject.title }"/></td>
                <td><form:errors path="title"></form:errors></td>                      						
            </tr>
            <tr>
                <td><form:label path="description">Project Description:</form:label></td>
                <td><form:input path="description" value="${editProject.description }"/></td>
                <td><form:errors path="description"></form:errors></td>
            </tr>
            <tr>
                <td><form:label path="dueDate">Due Date:</form:label></td>
                <td><form:input path="dueDate" type="date" value="${editProject.dueDate }"/></td>
                <td><form:errors path="dueDate"/></td>
            </tr>                                                                  
        </table>
        <input type="submit" value="Submit" class="submit">
    </form:form>
    <a href="/dashboard"><input type="submit" value="Cancel" class="submit"></a>
</body>
</html>