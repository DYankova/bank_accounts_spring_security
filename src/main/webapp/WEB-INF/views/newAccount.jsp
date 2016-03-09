<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ct" tagdir="/WEB-INF/tags"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<ct:page title="New account">
	<form:form method="POST" action="${contextPath}/saveAccount"
		modelAttribute="account">
		<div class="form-group">
			<label for="username">User name: </label>
			<form:input id="usernameInput" class="form-control" path="username"></form:input>
			<form:errors path="username" cssclass="error"></form:errors>
		</div>

		<div class="form-group">
			<label for="accountNumber">AccountNumber: </label>
			<form:input id="accountNumberInput" class="form-control"
				path="accountNumber"></form:input>
			<form:errors path="accountNumber" cssclass="error"></form:errors>
		</div>

		<div class="form-group">
			<label for="amount">Initial Amount: </label>
			<form:input id="amountInput" class="form-control" path="amount"></form:input>
			<form:errors path="amount" cssclass="error"></form:errors>
		</div>

		<div class="form-group">
			<label for="accountCurrency"> Account Currency: </label>
			<form:select path="accountCurrency" class="form-control"
				id="accountCurrencyInput">
				<form:option value="">Select Currency</form:option>
				<form:option value="BGN">BGN</form:option>
				<form:option value="EUR">EUR</form:option>
			</form:select>
			<form:errors path="accountCurrency" cssclass="error"></form:errors>
		</div>


		<input type="submit" class="btn btn-primary" value="Submit"
			name="submitLogin" />
	</form:form>
</ct:page>
