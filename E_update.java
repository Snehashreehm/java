<!DOCTYPE html>
<html lang="en" 
<head>
<meta charset="utf-8">
<title>Employee update</title>
<link rel="stylesheet" href="main.css">
</head>
<body>
<div class="emp">
		<h1>Employee</h1>
		<hr>
	<form method="POST">
<input type="text" name="ID" id="ID" class="form-control">
<input type="text" name="Employee First Name" id="firstName" class="form-control">				
<input type="text" name="Last name" id ="lastName" class="form-control">
<input type="text" name="Employement ID" id="EmpID" class="form-control">
<input type="text" name="Start Date" id="start" class="form-control">
<input type="text" name="Designation" id="designation" class="form-control">
<input type="text" name="Department" id="department"class="form-control">
<input type="text" name="End Date" id="end" class="form-control">
<input type="text" name="DOB" id="dob" class="form-control">
<input type="text" name="Status" id="status" class="form-control">
<input type="text" name="Reporting Manager" id="reporting" class="form-control">
<input type="text" name="Gender" id="gender" class="form-control">
<input type="text" name="Blood Group" id="blood" class="form-control">
<input type="text" name="Address" id="address" class="form-control">		
<button type="button" onClick="CreateEmp()" class="btn btn-primary"> Create</button><br><br>
<input type="text"  id="options" name="ID" class="form-control">
<input type="button" class="btn btn-primary" onclick="findEmp()" value="Retrive">
<input type="button" value="update" class="btn btn-primary" onclick="updatestoreEmp()">
<input  type="button" class="btn btn-primary" onclick="deleteEmp()" value="Delete">
</form>		
</div>
	<script>
function CreateEmp() 
{
			let http= new XMLHttpRequest();
			 var Employee=new Object();
			   Employee.id = document.getElementById("ID").value;
			   Employee.firstname = document.getElementById("firstName").value;
			   Employee.lastname = document.getElementById("lastName").value;
			   Employee.employeeid = document.getElementById("EmpID").value;
			   Employee.startdate = document.getElementById("start").value;
			   Employee.designation = document.getElementById("designation").value;
			   Employee.departement = document.getElementById("department").value;
				 Employee.enddate = document.getElementById("end").value;
			   Employee.dob = document.getElementById("dob").value;
			   Employee.status = document.getElementById("status").value;
			   Employee.reportingmanager = document.getElementById("reporting").value;
			   Employee.gender = document.getElementById("gender").value;
			   Employee.bloodgroup= document.getElementById("blood").value;
			   Employee.address = document.getElementById("address").value;
			  console.log(Employee.id);

			  for(x in Employee){
				  if(Employee[x]=="")
				  		Employee[x]=null;
			  }
			 var url="http://localhost:8080/addemp";
			  http.open('POST', url, true);
        
				http.setRequestHeader( 'Access-Control-Allow-Origin', '*');
				http.setRequestHeader('Content-type', 'application/json');
				http.onreadystatechange = function() {//Call a function when the state changes.
					if( http.readyState == 4 && (http.status == 200 || http.status==400) ){
						alert(http.responseText);
					}
				}
				http.send(JSON.stringify(Employee));
			  
			  //document.getElementById("demo").innerHTML = x;
			}

			function deleteEmp() {

				var id = document.getElementById("options").value;
				if(id==null || id=="")
				{
					alert("Please Enter Id for delete");
					return;
				}
				let http= new XMLHttpRequest();

				var url="http://localhost:8080/deleteemp";
			    http.open('DELETE', url, true);

				//Send the proper header information along with the request
				http.setRequestHeader( 'Access-Control-Allow-Origin', '*');
				http.setRequestHeader('Content-type', 'application/json');
				http.setRequestHeader("id",id);

				http.onreadystatechange = function() {//Call a function when the state changes.
					if( http.readyState == 4 && (http.status == 200 || http.status==400) ){
						alert(http.responseText);
					}
				}
				http.send();

			}

			function findEmp() {

				var id = document.getElementById("options").value;
				if(id==null || id=="")
				{
					alert("Please Enter Id for retreive");
					return;
				}
				let http= new XMLHttpRequest();

				var url="http://localhost:8080/findemp";
			    http.open('GET', url, true);

				//Send the proper header information along with the request
				http.setRequestHeader( 'Access-Control-Allow-Origin', '*');
				http.setRequestHeader('Content-type', 'application/json');
				http.setRequestHeader("id",id);

				http.onreadystatechange = function() {//Call a function when the state changes.
					if( http.readyState == 4 && (http.status == 200 || http.status==400) ){
						if(http.status==400)
						{
							alert("Employee not found");
							return;
						}
						var data=JSON.parse(http.response);

						alert("Employee Found \n Name:  "+data.firstname+" "+data.lastname+
							"\n Designation:  "+data.designation +"\n Departement:  "+data.departement);
					}
				}
				http.send();
			}


			function updatestoreEmp() {

				var id = document.getElementById("options").value;

				if(id==null || id=="")
				{
					alert("Please Enter Id for retreive");
					return;
				}
				
				// simple encryption using xor operation

				localStorage.setItem("data",id^658);
				window.location.href="EmpUpdate.html";
			}



			</script>
</body>
</html>
	
				
				
    
