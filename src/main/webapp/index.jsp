<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<%@page isELIgnored="false" %>
<title>Course Management System</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css?version=1">

</head>


<body>
<div class="container">
<div class="box">
<h1>TO DO LIST</h1>
<p><a class="normal" href="${pageContext.request.contextPath}/tasks">List Tasks</a></p>
<p><a class="normal" href="${pageContext.request.contextPath}/tasks/form">Enter Task</a></p>
</div>
</div>
</body>
</html>
