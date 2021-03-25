<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Registration Successful!  
</h1>

<P>  Username is ${user.username} </P>
<P>  Country is ${user.country} </P>
<p> <a href="/spring-mvc-form-registration/login">Login</a>
</body>
</html>
