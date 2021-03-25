<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Employees List</title>
</head>

<spring:url value="/" var="contextPath" htmlEscape="true" />
<c:set var="userName" value="${sessionScope.userName}" />

<c:if test="${empty userName}">
	<c:redirect url="/login" />
</c:if>

<body>
	<span>Welcome <strong> <c:out value="${userName}" /> </strong></span>
	<br>
	<h2>Employees List</h2>

	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Name</th>
			<th>Age</th>
			<th>Gender</th>
			<th>Contractor</th>
			<th>Skills</th>
			<th>Designation</th>
			<th>Department</th>
			<th>Address</th>
			<th>Country</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>

		<c:if test="${empty empList}">
			<tr>
				<td colspan="11" align="center">No record found to display.</td>
			</tr>
		</c:if>

		<c:forEach var="emp" items="${empList}">
			<tr>
				<td>${emp.name}</td>
				<td>${emp.age}</td>
				<td>${emp.gender}</td>
				<td>${emp.contractor ? "Yes" : "No"}</td>
				<td>${emp.skills}</td>
				<td>${emp.designation}</td>
				<td>${emp.department}</td>
				<td>${emp.address}</td>
				<td>${emp.country}</td>
				<td><a href="${contextPath}/employee/update/${emp.id}">Edit</a></td>
				<td><a href="${contextPath}/employee/delete/${emp.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />


	<a href="${contextPath}/employee">Add New Employee</a> &nbsp;&nbsp;
	<a href="${contextPath}/logout">Logout</a>
</body>
</html>