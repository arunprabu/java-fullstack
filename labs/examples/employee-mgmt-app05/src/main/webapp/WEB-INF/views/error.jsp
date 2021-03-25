<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>General Error Page</title>
</head>

<spring:url value="/" var="contextPath" htmlEscape="true" />

<body>
<h1>
	Unexpected Error Occurred!  
</h1>

<p> ${exception.errorMsg != null ? exception.errorMsg : exception} </p>
<span> <a href="${contextPath}"> Back </a></span>
</body>
</html>
