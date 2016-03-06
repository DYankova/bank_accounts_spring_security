<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="ct" tagdir="/WEB-INF/tags"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" /> 

<ct:page title="Bank register">
	<table class="table">
		<thead>
			<tr>
				<th>Username</th>
				<th>Account number</th>
				<th>Current amount</th>
				<th>Account currency</th>
			</tr>
		</thead>
		<c:if test="${not empty accounts}">
			<tbody>
				<c:forEach var="account" items="${accounts}">
					<tr>
						<td>${account.username}</td>
						<td>${account.accountNumber}</td>
						<td>${account.amount}</td>
						<td>${account.accountCurrency}</td>
					</tr>
				</c:forEach>
			</tbody>
		</c:if>
	</table>

	<button type="button" class="btn btn-primary"
		onclick="location = '${contextPath}${newAccountUrl}'">New
		account</button>
	<button type="button" class="btn btn-default"
		onclick="location = '${contextPath}${newOperationUrl}'">Operation</button>
</ct:page>