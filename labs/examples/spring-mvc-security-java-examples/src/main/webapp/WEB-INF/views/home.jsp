<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<div class="container">
		<h1>This is secured!</h1>
		<p>
			Hello <b><c:out value="${pageContext.request.remoteUser}" /></b>
		</p>

		<c:url value="/logout" var="logoutUrl" />
		<c:url value="/admin" var="adminUrl" />
		<form action="${logoutUrl}" method="post" id="logoutForm">
<%-- 			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" /> --%>
		</form>
		<script>
			function formSubmit() {
				document.getElementById("logoutForm").submit();
			}
		</script>

		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<p><a href="${adminUrl}"> Admin </a> | <a href="javascript:formSubmit()"> Logout</a></p>
		</c:if>

		<P>The time on the server is ${serverTime}.</P>
	</div>
</body>
</html>
