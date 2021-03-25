<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="true" %>
<html>
<head>
	<title>Login</title>
</head>
<body>
<%-- HttpSession session = request.getSession(); --%>
<%-- Username: ${sessionScope.user.username} --%>

<form:form target="login" method="POST">
	<p>${error}</p>
	<p>Enter Username: <form:input path="username" /> </p>
	<p>Enter Password: <form:password path="password" /> </p>
	<p><button type="submit" value="Submit">Submit</button> <button type="reset" value="Reset">Reset</button> </p>
</form:form>

</body>
</html>
