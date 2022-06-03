<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:import url="/WEB-INF/jsps/header.jsp" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<style>
.myclass {
	background-color: Cornflowerblue;
	color: white;
	padding: 12px;
}

.modal-register {
	color: #636363;
	width: 450px;
}

.modal-register .modal-content {
	padding: 10px;
	border-radius: 5px;
	border: none;
	background-color: Cornflowerblue;
	width: 500px;
}

.modal-register .modal-header {
	border-bottom: none;
	position: relative;
	justify-content: center;
}

.modal-register h4 {
	text-align: center;
	font-size: 26px;
	margin: 10px 0 -15px;
}

.modal-register .form-control:focus {
	border-color: #70c5c0;
}

.modal-register .form-control, .modal-login .btn {
	min-height: 30px;
	border-radius: 3px;
	}

.modal-register .close {
	position: absolute;
	top: -5px;
	right: -5px;
}

.modal-register .modal-footer {
	background: #ecf0f1;
	border-color: #dee4e7;
	text-align: center;
	justify-content: center;
	margin: 0 -20px -20px;
	border-radius: 5px;
	font-size: 13px;
}

.modal-register .modal-footer a {
	color: #999;
}

.modal-register .avatar {
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

.modal-register .avatar img {
	width: 100%;
}

.modal-register.modal-dialog {
	margin-top: 13px;
}

.modal-register .btn {
	color: #fff;
	border-radius: 4px;
	background: #60c7c1;
	text-decoration: none;
	transition: all 0.4s;
	line-height: normal;
	border: none;
}

.modal-register .btn:hover, .modal-register .btn:focus {
	background: #45aba6;
	outline: none;
}
</style>
<body style="background-color: #FFFFFF">
	<div class="modal-dialog modal-register">
		<div class="modal-content">
			<h4 class="modal-title">Account </h4>
			<div class="modal-body">
				<!-- Form register -->
				<form:form class="myclass" method="POST"
					modelAttribute="registrationForm"
					action="${pageContext.request.contextPath}/registerCustomer">
					<c:if test="${error != 'NULL'}">
						<h4 style="color: red">${error}</h4>
					</c:if>
					<div class="md-form">

						<form:input type="hidden" id="orangeForm-name2"
							class="form-control" path="cid" />

					</div>
					<div class="md-form">
						<i class="fa fa-user prefix white-text"></i> <label
							for="orangeForm-name2">From</label>
						<form:input type="text" id="orangeForm-name2" class="form-control"
							path="firstName" required="true" />

					</div>
					<div class="md-form">
						<i class="fa fa-user prefix white-text"></i> <label
							for="orangeForm-name2">To</label>
						<form:input type="text" id="orangeForm-name2" class="form-control"
							path="lastName" required="true" />

					</div>
					
					<div class="md-form">
						<i class="fa fa-mobile prefix white-text"></i> <label
							for="orangeForm-mobile">Bank no</label>
						<form:input type="mobile" id="orangeForm-mobile2"
							class="form-control" path="bankNo" required="true" minlength="10"
							maxlength="10" />
					</div>
					
					<div class="md-form">
						<i class="fa fa-address prefix white-text"></i> <label
							for="orangeForm-name2">Address</label>
						<form:input type="text" id="orangeForm-name2" class="form-control"
							path="address" required="true" />

					</div>

					<div class="md-form">
						<i class="fa fa-address prefix white-text"></i> <label
							for="orangeForm-name2">Amount</label>
						<form:input type="text" id="orangeForm-name2" class="form-control"
							path="amount" required="true" />

					</div> 
					<div class="md-form">
						<i class="fa fa-address prefix white-text"></i> <label
							for="orangeForm-name2">  Amount less</label>
						<form:input type="text" id="orangeForm-name2" class="form-control"
							path="amount_sent" required="true" />

					</div>
					
					<div class="md-form">
						<i class="fa fa-mobile prefix white-text"></i> <label
							for="orangeForm-mobile">Mobile</label>
						<form:input type="mobile" id="orangeForm-mobile2"
							class="form-control" path="mobile" required="true" minlength="10"
							maxlength="10" />
					</div>
					<div class="md-form">
						<i class="fa fa-envelope prefix white-text"></i> <label
							for="orangeForm-email2">Email</label>
						<form:input type="email" id="orangeForm-email2"
							class="form-control" path="email" required="true" />

					</div>
					
					<div class="md-form">
						<i class="fa fa-password prefix white-text"></i> <label
							for="orangeForm-password">Password</label>
						<form:input type="password" id="orangeForm-email2"
							class="form-control" path="password" required="true" />

					</div>
					<br>
					<c:choose>
						<c:when test="${customer.cid!=null}">
							<div class="md-form">
								<label class="col-md-4 control-label" for="button1id"></label> <i
									class="fa fa-text prefix white-text"></i>
								<button style="background-color: green" type="submit"
									id="button1id" name="button1id" class="btn btn-info btn-sm">Update</button>
								<button onclick="/viewStudents" style="background-color: grey"
									type="submit" id="button2id" name="button2id"
									class="btn btn-info btn-sm">Cancel</button>
							</div>
						</c:when>

						<c:otherwise>
							<div class="md-form">
								<label class="col-md-4 control-label" for="button1id"></label> <i
									class="fa fa-text prefix white-text"></i>
								<button style="background-color: green" type="submit"
									id="button1id" name="button1id" class="btn btn-info btn-sm">Register</button>

								<button style="background-color: grey" type="reset"
									id="button2id" name="button2id" class="btn btn-info btn-sm">Reset</button>
							</div>
						</c:otherwise>
					</c:choose>
				</form:form>

				<!-- Form register -->
			</div>
		</div>
	</div>


</body>

</html>