<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="/WEB-INF/jsps/dashboard.jsp" />
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.myclass {
	color: white;
	padding: 15px;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: #FFFFFF">
	<form class="" action="">
			<h3 style="color: black">Loan Statement</h3>
			<hr>
			<table class="table">
				<thead>
					<tr style="color: black">
						<th>Date</th>
						<th>Transaction Type</th>
						<th>EMI Amount</th>
						<th>EMI Reamaining</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${getLoanTransactions}" var="trans">
						<tr>
							<td><c:out value="${trans.transDate}" /></td>
							<td><c:out value="${trans.transactionType}" /></td>
							<td><c:out value="${trans.emi}" /></td>
							<td><c:out value="${loanAccount.loanEMIRemaining}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
	</form>
</body>
</html>