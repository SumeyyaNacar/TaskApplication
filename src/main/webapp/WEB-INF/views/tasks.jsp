<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!-- jstl  -->
<!--jstl-- jsp içinde daha az java kodu yazmamızı sağlayan bir yapı -->
<!DOCTYPE html>
<html>
<head>
<%@ page isELIgnored="false" %>
<meta charset="UTF-8">
<title>course-project</title>

<link rel="stylesheet"  href="${pageContext.request.contextPath}/resources/css/style.css?version=1">
</head>
<body>
	<div class="container">
		<h2>Task Lıst</h2>
		<table>

			<tr style="background-color:#b8888c; color:white">
				<th>ID</th>
				<th>Task Description</th>
				<th>Date</th>
				<th>Level</th>
				<th>Edit/Delete</th>
			</tr>

			<c:forEach items="${tasks}" var="task" varStatus="status">

				<!-- create an "update" link with Course id -->
				<c:url var="updateLink" value="/tasks/update">
					<c:param name="id" value="${task.id}" />
				</c:url>

				<!-- create an "delete" link with Course id -->
				<c:url var="deleteLink" value="/tasks/delete">
					<c:param name="id" value="${task.id}" />
				</c:url>

				<tr
					style="background-color:${status.index % 2==0? '#ece4cc':'#d9aaaa'}">
					<td>${task.id}</td>
					<td>${task.description}</td>
					<td>${task.date}</td>
					<td>${task.level}</td>

					<td>
						<!-- show the links -->

						<a class="update" href="${updateLink}">Edit</a>
						<a class="delete" href="${pageContext.request.contextPath}/tasks/delete/${task.id}">Delete</a>
						<!--   <a class="delete" href="${deleteLink}"> Delete</a>-->
					</td>

				</tr>
			</c:forEach>
		</table>
		<p><a class="normal" href="${pageContext.request.contextPath}/tasks/form">Enter Task</a>
	</div>
</body>
</html>