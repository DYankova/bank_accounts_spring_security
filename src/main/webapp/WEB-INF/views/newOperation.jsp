<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ct" tagdir="/WEB-INF/tags"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<ct:page title="New operation">

	<form:form method="POST" action="${contextPath}/saveOperation"
		modelAttribute="operation">

<div class="form-group">
		<label for="accountNumber">AccountNumber: </label>
		<form:select path="accountNumber" class="form-control" id="accountNumberInput">
			<c:forEach var="account" items="${accounts}">
				<form:option value="${account.accountNumber}">${account.accountNumber}</form:option>
			</c:forEach>
		</form:select>
		<form:errors path="accountNumber" cssclass="error"></form:errors></div>
		
<div class="form-group">
		<label for="operation">Operation: </label>
		<form:select path="operation" class="form-control" id="operationInput">
			<form:option value="">Select Operation</form:option>
			<form:option value="deposit">Deposit</form:option>
			<form:option value="withdraw">Withdraw</form:option>
		</form:select>
		<form:errors path="operation" cssclass="error"></form:errors></div>
	
<div class="form-group">
		<label for="amount">Amount: </label>
		<form:input id="amountInput" class="form-control" path="amount" />
		<form:errors path="amount" cssclass="error"></form:errors></div>
		
		<div class="form-group">
		<label for="currency">Currency: </label>
		<form:select path="currency" class="form-control" id="currencyInput">
			<form:option value="">Select Currency</form:option>
			<form:option value="BGN">BGN</form:option>
			<form:option value="EUR">EUR</form:option>
		</form:select>
		<form:errors path="currency" cssclass="error"></form:errors></div>

		<input type="submit" value="Submit" name="submitLogin" />
	</form:form>
</ct:page>
