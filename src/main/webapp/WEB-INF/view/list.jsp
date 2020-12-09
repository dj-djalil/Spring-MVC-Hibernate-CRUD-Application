<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/abc/css/bootstrap.min.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath }/abc/css/style.css">
</head>
<body>

	<div class="container">
		<h3 class="header">Customer Relationship Management</h3>
		<hr>
		<a type="button" class="btn btn-warning" href="show-customer-form">New Customer</a>
		<table class="table table-striped">
			<thead>

				<tr>
					<th scope="col">First Name</th>
					<th scope="col">Last Name</th>
					<th scope="col">Email</th>
					<th scope="col"></th>
					<th scope="col"></th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${customers}" var="item">
					<tr>

						<td>${item.firstName}</td>
						<td>${item.lastName}</td>
						<td>${item.email}</td>
						<td scope="col"><a href="show-update-form?id=${item.id}" type="button"
							class="btn btn-primary">Update</a></td>
						<td scope="col"><a href="deleteCustomer?id=${item.id}" type="button" class="btn btn-danger" onclick="if(!confirm('are you sure ?')){return false}">Delete</a></td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
	</div>
	<img alt="cource"
		src="${pageContext.request.contextPath}/abc/img/logo.jpg">
</body>
</html>