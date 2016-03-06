<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="title"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-2.2.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${title}</title>
</head>
<body>

	<nav class="navbar navbar-default">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="${contextPath}">BankAccounts</a>
			</div>
		</div>
	</nav>

	<div class="container">
		<h2>
			<center>${title}</center>
		</h2>
		<jsp:doBody />
	</div>
</body>
</html>