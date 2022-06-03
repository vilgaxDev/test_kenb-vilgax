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
	background-color: Cornflowerblue;
	color: white;
	padding: 12px;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: #f8f8f4">

	<body style="background-color: #FFFFFF">
		<div class="modal-dialog modal-login">
			<div class="modal-content">


				<div class="modal-header">


				</div>
				<div class="modal-body">
					<form class="" action="">
						<p>
						<h3 style="color:   black">Hello 
						<td><c:out value="${customerInfo.firstName}"  /></td>
							,<a style="color: grey" href="/registerOpener"></a> </h3>
						</p>
						<div class="modal-dialog modal-login">
							<body style="background-color: #f4f4f8">
							<div class="modal-content">
								<div align="center">
								<h4 class="modal-title">Loan Balance</h4>
								</div>
								<a href=""class="btn btn-info btn-sm"><span
								  class="glyphicon glyphicon-show"></span> Loan Balance KES 29, 005 </a>
										
								<div class="modal-header">
									<h4 class="modal-title">Quick Actions</h4>
									<a href=""class="btn btn-info btn-sm"><span
										class="glyphicon glyphicon-show"></span> Payment</a>
										<a href=""class="btn btn-info btn-sm"><span
											class="glyphicon glyphicon-show"></span> Loan </a>
											<a href=""class="btn btn-info btn-sm"><span
												class="glyphicon glyphicon-show"></span> Pay loan</a>
									</div>

							 </body>
							 </div>
							</div>
							</div>
						<hr>


					<form class="" action="">
							<h3 style="color: black">Recent Transactions</h3>
							<hr>
							<!-- <table class="table">
								<thead>
									<tr style="color: black">
										<th>Date</th>
										<th>Transaction Type</th>
										<!-- <th>Amount</th> -->
										<!-- <th>Balance</th> -->
									<!-- </tr>
								</thead>
								<tbody>
									 -->
										<!-- <tr>
											<td><c:out value="${customerInfo.firstName}" /></td>
											<td><c:out value="${trans.transactionType}" /></td>
											<td><c:out value="${trans.ammount}" /></td>
											<%-- <td><c:out value="${trans.closingBalance}" /></td> --%>
											<%-- <td><a href="updatetransent?id=${trans.id}"
												class="btn btn-info btn-sm"><span
												class="glyphicon glyphicon-edit"></span> Edit</a></td> --%>
										</tr> -->
									
								<!-- </tbody>
							</table> -->
					</form>
						
						<table class="table">
							<thead>
							<tr >
								<th style="color: black">From</th>
								<td><c:out value="${customerInfo.firstName}" />
									<td> +
										<c:out value= "${customerInfo.amount}" />
										<label
										for="orangeForm-mobile">KES</label>
									</td>
								</td>
								<tr>
									<th>Bank: number </th>
									<td><c:out value="${customerInfo.bankNo}" /></td>
								</tr>
							</tr>
							<tr>
								<th>To</th>
								<td><c:out value="${customerInfo.lastName}" /> 
								 <td>-
									 <c:out value="${customerInfo.amount_sent}" />
									<label
										for="orangeForm-mobile">KES</label>
								</td>

							</tr>
							<tr>
								<th>Mobile No </th>
								<td><c:out value="${customerInfo.mobile}" /></td>
							</tr>


							<tr >
								<th style="color: black">From</th>
								<td><c:out value="${customerInfo.firstName}" />
									<td> +
										<c:out value= "${customerInfo.amount}" />
										<label
										for="orangeForm-mobile">KES</label>
									</td>
								</td>
								<tr>
									<th>Bank: number </th>
									<td><c:out value="${customerInfo.bankNo}" /></td>
								</tr>
							</tr>
							<!-- <tr>
								<th>Email</th>
								<td><c:out value="${customerInfo.email}" /></td>
							</tr>
							<tr>
								<th>Address</th>
								<td><c:out value="${customerInfo.address}" /></td>
							</tr>
							<tr>
								<th>MobileNo</th>
								<td><c:out value="${customerInfo.mobileNo}" /></td>
							</tr>
							
							<tr>
								<th>Email</th>
								<td><c:out value="${customerInfo.email}" /></td>
							</tr> -->
							<tr>
								<td><a href="updateCustomer?id=${customerInfo.cid}"
									   class="btn btn-info btn-sm"><span
										class="glyphicon glyphicon-edit"></span> Update</a></td>
								<td><a href="backToDashboard"
									   class="btn btn-info btn-sm"><span
										class="glyphicon glyphicon-edit"></span> Back</a></td>
							</tr>


							</thead>
							<tbody>

							<%-- <td><a href="deletecustomerInfoent?id=${customerInfo.id}"
                                            class="btn btn-info btn-sm"><span
                                                class="glyphicon glyphicon-remove"></span> Delete</a></td>
                                    </tr>
                                 --%>
						</table>

					</form>
				</div>
				
			</div>
		</div>

		
</body>
</html>
