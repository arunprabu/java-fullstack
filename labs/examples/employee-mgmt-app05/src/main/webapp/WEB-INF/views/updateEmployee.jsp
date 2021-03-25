<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Update Employee</title>
</head>

<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>

<spring:url value="/" var="contextPath" htmlEscape="true" />
<c:set var="userName" value="${sessionScope.userName}" />

<c:if test="${empty userName}">
	<c:redirect url="/login" />
</c:if>

<body>
	<span>Welcome <strong> <c:out value="${userName}" />
	</strong></span>

	<h2>Update Employee</h2>
	<form:form method="POST"
		action="${contextPath}/employee/update"
		modelAttribute="employee">
		<form:errors path="*" cssClass="errorblock" element="div" />
		<table>
			<tr>
				<td></td>
				<td><form:hidden path="id" /></td>
			</tr>
			<tr>
				<td>Name :</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Age :</td>
				<td><form:input path="age" /></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td><form:radiobutton path="gender" value="M" /> Male &nbsp; <form:radiobutton
						path="gender" value="F" /> Female</td>
			</tr>
			<tr>
				<td>Contractor:</td>
				<td><form:checkbox path="contractor" /></td>
			</tr>
			<tr>
				<td>Designation :</td>
				<td><form:input path="designation" /></td>
			</tr>
			<tr>
				<td>Skills:</td>
				<td><form:checkboxes path="skills" items="${skillList}" /></td>
			</tr>
			<tr>
				<td>Department :</td>
				<td><form:input path="department" /></td>
			</tr>
			<tr>
				<td><form:label path="address">Address:</form:label></td>
				<td><form:textarea cols="20" rows="3" path="address" /></td>
			</tr>
			<tr>
				<td><form:label path="country">Country:</form:label></td>
				<td><form:select path="country" items="${countries}" /></td>
			</tr>

			<tr height="50" align="center">
				<td></td>
				<td><input type="submit" value="Edit Save" />
					&nbsp;&nbsp;&nbsp;&nbsp; <a href="${contextPath}/employee/list">Back</a></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
