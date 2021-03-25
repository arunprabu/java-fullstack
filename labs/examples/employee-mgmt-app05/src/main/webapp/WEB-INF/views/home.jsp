<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Employee Management App</title>
<spring:url value="/" var="contextPath" htmlEscape="true" />
</head>
<body>
	<h1>Welcome to Employee Management App!</h1>
	<p> Current Time: ${serverTime} </p>
	<p> <a href="${contextPath}/login">Login</a>
</body>
</html>
