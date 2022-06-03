<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:import url="/WEB-INF/jsps/dashboard.jsp" />
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>View Balance</title>
<link href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
.body {
	font-family: 'Varela Round', sans-serif;
}

.mycss {
	background-image: url('/resources/images/healthcare.png');
}

.modal-login {
	color: #636363;
	width: 350px;
}

.modal-login .modal-content {
	padding: 20px;
	border-radius: 5px;
	border: none;
	background-color: Cornflowerblue;
}

.modal-login .modal-header {
	border-bottom: none;
	position: relative;
	justify-content: center;
}

.modal-login h4 {
	text-align: center;
	font-size: 26px;
	margin: 30px 0 -15px;
}

.modal-login .form-control:focus {
	border-color: #70c5c0;
}

.modal-login .form-control, .modal-login .btn {
	min-height: 40px;
	border-radius: 3px;
}

.modal-login .close {
	position: absolute;
	top: -5px;
	right: -5px;
}

.modal-login .modal-footer {
	background: #ecf0f1;
	border-color: #dee4e7;
	text-align: center;
	justify-content: center;
	margin: 0 -20px -20px;
	border-radius: 5px;
	font-size: 13px;
}

.modal-login .modal-footer a {
	color: #999;
}

.modal-login .avatar {
	position: absolute;
	margin: 0 auto;
	left: 0;
	right: 0;
	top: -70px;
	width: 95px;
	height: 95px;
	border-radius: 50%;
	z-index: 9;
	background: #60c7c1;
	padding: 15px;
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.1);
	background-color: white;
}

.modal-login .avatar img {
	width: 100%;
}

.modal-login.modal-dialog {
	margin-top: 80px;
}

.modal-login .btn {
	color: #fff;
	border-radius: 4px;
	background: #60c7c1;
	text-decoration: none;
	transition: all 0.4s;
	line-height: normal;
	border: none;
}

.modal-login .btn:hover, .modal-login .btn:focus {
	background: #45aba6;
	outline: none;
}

.trigger-btn {
	display: inline-block;
	margin: 100px auto;
}
</style>
</head>
<body style="background-color: #FFFFFF">
<c:if test="${error!=null}">
<h5 style="color: red">${error}</h5>
	</c:if>
	<div class="modal-dialog modal-login">
		<div class="modal-content">
			<div align="right"></div>
			<h4 class="modal-title">Transfer</h4>
			<div class="modal-header"><hr></div>
			<div class="modal-body">

				<div class="form-group">
					<div class="md-form">
						<form:form method="post" modelAttribute="transferForm"
							action="/transfer">
							<i class="fa fa-user prefix white-text"></i>
							<label for="orangeForm-name2">Account Number</label>
							<form:input type="text" id="accNo" class="form-control"
								path="accountNo" required="true" />
							<div class="md-form">
								<i class="fa fa-rupee prefix white-text"></i> <label
									for="orangeForm-name2">Amount</label>
								<form:input type="text" id="amount" class="form-control"
									path="amount" required="true" />
							</div>
							<div class="form-group">
								<br>
								<button type="submit"
									class="btn btn-primary btn-lg btn-block login-btn">Submit</button>
							</div>
						</form:form>
					</div>
				</div>

			</div>
		</div>
	</div>

</body>
</html>
