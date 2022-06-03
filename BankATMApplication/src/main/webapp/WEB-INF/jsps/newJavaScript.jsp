<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<script type="text/javascript">
	
	var employee={
			firstName:"",
			lastName:"",
			email:"",
			designation:""
			
			
	};
	
	function addEmployee()
	{
		employee.firstName=document.getElementById("fname").value;
		employee.lastName=document.getElementById("lname").value;
		employee.email=document.getElementById("email").value;
		employee.designation=document.getElementById("designation").value;
		alert(employee.designation);
	}
	function viewEmployee()
	{
		alert(employee.firstName);
		
		document.getElementById("fn").value=employee.firstName;
		document.getElementById("ln").value=employee.lastName;
		document.getElementById("el").value=employee.email;
		document.getElementById("dg").value=employee.designation; 
		alert("view");
	}
	function updateEmployee()
	{
		
	}
	function deleteEmployee()
	{
		
	}
	
	
	
	</script>
</head>
<body style="background-color: orange">
<form class="form-horizontal">
<fieldset>

<!-- Form Name -->
<legend>Register</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">First Name</label>  
  <div class="col-md-4">
  <input id="fname"  type="text" placeholder="First Name" class="form-control input-md">
  
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Last Name</label>  
  <div class="col-md-4">
  <input id="lname"  type="text" placeholder="Last Name" class="form-control input-md">
  
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Email</label>  
  <div class="col-md-4">
  <input id="email"  type="email" placeholder="Email" class="form-control input-md">
 
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="selectbasic">Designation</label>
  <div class="col-md-4">
    <select id="designation"  class="form-control">
      <option value="Trainee">Trainee</option>
      <option value="Software Engineer">Software Engineer</option>
      <option value="Sr.Software Engineer">Sr.Software Engineer</option>
    </select>
  </div>
</div>

<!-- Button (Double) -->
<div class="form-group">
  <div class="col-md-8" align="center">
    <button  type="submit" onclick="addPerson()" class="btn btn-success">Submit</button>
    <button type="reset"  class="btn btn-danger">Reset</button>
  </div>
</div>
<br><br>
<div class="form-group" align="center">
 <div class="col-md-4">
<button type="button" onclick="viewEmployee()" style="background-color: green" type="submit" class="btn btn-info btn-sm"">View</button>
<button onclick="updateEmployee()" style="background-color: black" type="submit" class="btn btn-info btn-sm" >Update</button>
<button  onclick="deleteEmployee()" style="background-color: red" type="submit" class="btn btn-info btn-sm">Delete</button>
</div>
</div>


<div>
<!-- <h1 id="fn"></h1>
<h1 id="ln"></h1>
<h1 id="el"></h1>
<h1 id="dg"></h1> -->

<input type="text" id="fn">
<input type="text" id="ln">
<input type="text" id="el">
<input type="text" id="dg">
</div>

</fieldset>
</form>
</body>
</html>