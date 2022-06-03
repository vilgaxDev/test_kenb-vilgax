<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Issue-Tracker App</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<script type="text/javascript">


var languages=['java','c','c++'];

var person={
		firstName:"",
		lastName:"",
		address:""
		
		
};

function getObject(){
	person.firstName=document.getElementById("firstName").value;
	person.lastName=document.getElementById("lastName").value;
	person.address=document.getElementById("address").value;
}


function showPerson()
{
	document.getElementById("fname").value=person.firstName;
	document.getElementById("lname").value=person.lastName;
	document.getElementById("addr").value=person.address;
}

function showMessage(){
	alert('Welcome To JavaScript.');
}

function addLanguage(){
	
	languages.push(document.getElementById("t1").value);
	document.getElementById("demo").innerHTML=languages;
}
function showAllLanguage(){
	
	document.getElementById("demo").innerHTML=languages;
}
function deleteLanguage(){
	languages.splice(document.getElementById("t4").value,1);
	document.getElementById("demo").innerHTML=languages;
}
function updateLanguage(){
	languages[document.getElementById("t2").value]=document.getElementById("t3").value;
	document.getElementById("demo").innerHTML=languages;
}

</script>
</head>
<body style="background-color: #FFFFFF">
<div>
<h1>Language-Tracker app using vanilla JS+HTML</h1>
<button style="background-color: red" type="button" class="btn btn-info btn-sm" onclick="showMessage()">Show Alert</button><br><br>
<input id="t1" type="text" placeholder="Value">&nbsp;&nbsp;<button style="background-color: green" type="button" class="btn btn-info btn-sm" onclick="addLanguage()">ADD</button><br><br>
<button type="button" style="background-color: orange" class="btn btn-info btn-sm" onclick="showAllLanguage()">VIEW ALL</button><br><br>

<input id="t2" type="text" placeholder="index">&nbsp;<input id="t3" type="text" placeholder="Value">&nbsp;&nbsp;<button type="button" style="background-color: pink" onclick="updateLanguage()">UPDATE</button><br><br>
<input id="t4" type="text" placeholder="index">&nbsp;&nbsp;<button type="button" style="background-color: red" onclick="deleteLanguage()">DELETE</button>
</div>
<br><br>	
<textarea id="demo"></textarea><br><br>	

<label>First Name</label><input type="text"  placeholder="First Name" id="firstName">&nbsp;&nbsp;
<label>Last Name</label><input type="text"  placeholder="last Name" id="lastName">&nbsp;&nbsp;
<label>Address</label><input type="text"  placeholder="Address" id="address"><br><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button style="background-color: green" type="submit" class="btn btn-info btn-sm" onclick="getObject()">Submit</button>&nbsp;&nbsp;&nbsp;<button style="background-color: orange" type="submit" class="btn btn-info btn-sm" onclick="showPerson()">View Person</button>
<br>
<br>
<div>
<input type="text" id="fname">
<input type="text" id="lname">
<input type="text" id="addr">
</div>
</body>
</html>