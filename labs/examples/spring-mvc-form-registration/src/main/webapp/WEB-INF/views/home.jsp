<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello ${message}  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<p> <a href="/spring-mvc-form-registration/register">Register</a>
</body>
</html>
