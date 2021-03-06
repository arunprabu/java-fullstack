<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<div class="container">
		<h1>Welcome to Spring Security Training!</h1>
		<p>
			Hello <b><c:out value="${pageContext.request.remoteUser}" /></b>
		</p>

		<c:url value="/logout" var="logoutUrl" />
		<form action="${logoutUrl}" method="post" id="logoutForm">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
		<script>
 			function formSubmit() {
				document.getElementById("logoutForm").submit();
			} 
		</script>

		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<h2>
				<a href="javascript:formSubmit()"> Logout</a>
			</h2>
		</c:if>

		<P>The time on the server is ${serverTime}.</P>
	</div>
</body>
</html>
