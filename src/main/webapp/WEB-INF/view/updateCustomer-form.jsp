<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!--  spring tag form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Customer</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/abc/css/bootstrap.min.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath }/abc/css/style.css">
</head>
<body>
	<div class=" updateCustomerForm container-fluid">
		<h3>New Customer</h3>
		<form:form action="updateCustomer" method="POST"
			modelAttribute="upCustomer">
			<form:hidden path="id" />
			<label> First Name : <form:input path="firstName"
					class="form-control" placeholder="First name" />
			</label>
			<br>
			<label> Last Name : <form:input path="lastName"
					class="form-control" placeholder="last name" />
			</label>
			<br>
			<label> Email : <form:input path="email" class="form-control"
					placeholder="email" />
			</label>
			<input type="submit" value="Update" class="btn btn-primary" />

		</form:form>
		<a href="${pageContext.request.contextPath}/customer/list"> Back
			to List</a>
	</div>
</body>
</html>