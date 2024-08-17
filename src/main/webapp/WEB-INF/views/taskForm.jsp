<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<%@ page isELIgnored="false" %>
<meta charset="UTF-8">
<title>Add Task</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css?version=1">
</head>
<body>
	<div class="container">
		<div align="center">
			<h2>Enter / EdIt Task</h2>
			<table>
				<form:form modelAttribute="task" action="enterTask" method="post">
					<form:hidden path="id" />
					<tr>
                    						<td class="taskprop">Description:</td>
                    						<td><form:input path="description" size="30" cssClass="large-input"/></td>
                    						<td><form:errors path="description" class="error" /></td>
                    					</tr>

                    					<tr>
                    						<td class="taskprop">Date:</td>
                    						<td><form:input path="date" size="30" cssClass="large-input"/></td>
                    						<td><form:errors path="date" class="error" /></td>
                    					</tr>

                    					<tr>
                    						<td class="taskprop">Level:</td>
                    						<td><form:input path="level" size="30" cssClass="large-input"/></td>
                    						<td><form:errors path="level" class="error" /></td>
                    					</tr>

                    					<tr>
                    						<td></td>
                    						<td align="center"><form:button>Submit</form:button></td>
                    						<td></td>
                    					</tr>
				</form:form>
			</table>
		</div>
	</div>
</body>
</html>