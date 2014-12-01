<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>

<!-- Jquery -->
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
	
	
<script type="text/javascript">

function userLogin(){
	// alert('inside Login page');
	   var email = $('#email').val();
	   var password = $('#password').val();
	 
	// alert('Username : '+email);
	   
		$.ajax({
			url : "music/Auth/login",
		    type: "POST",
		    data : "email=" + email + "&password=" + password,
		    datatype : "json",
		    	success:function(data, textStatus, jqXHR){
		    		
		    		window.localStorage.setItem('userId', data.userId);
					window.localStorage.setItem('firstName', data.firstName);
					window.localStorage.setItem('lastName', data.lastName);
					
					console.log(window.localStorage.getItem('userId'));
					console.log(window.localStorage.getItem('firstName'));
					console.log(window.localStorage.getItem('lastName'));
					
			    	window.location.href="userDashBoard.jsp";  
			    },
		    error: function(jqXHR, textStatus, errorThrown){
		    	alert('Could not process request.. ' + errorThrown);
		    	window.location.href="index.jsp";
		    }
		});
}


//div show 
function showSignupDiv(){
//	alert("inside show div");
	document.getElementById('div1').style.display = "none";
	document.getElementById('signupdiv').style.display = "block";
	
//	alert("after show div");
}


function signup(){
	var fName= document.getElementById('firstName').value;
	var lName= document.getElementById('lastName').value;
	var emailId = document.getElementById('emailId').value;
	var pass = document.getElementById('pass').value;

	$.ajax({
		url : "music/Auth/signup",
	    type: "POST",
	    data : "email=" + emailId + "&password=" + pass +"&firstname="+fName+ "&lastname="+lName,
	    datatype : "json",
	    	success:function(data, textStatus, jqXHR){
	    		
		    	window.location.href="index.jsp";  
		    },
	    error: function(jqXHR, textStatus, errorThrown){
	    	alert('Could not process request.. ' + errorThrown);
	    	window.location.href="index.jsp";
	    }	
	});
	
	
	
}


</script>	
	
	
	
	
<body background="musicnote.jpg">
	<div class="container" id="div1">
		<div id="loginOptions"
			style="margin: 180px 0px 0px 50px; float: left;">


			<div
				style="background-color: #EBEBE0; -webkit-box-shadow: 3px 0px 5px #888888; -moz-box-shadow: 3px 0px 5px #888888; box-shadow: 3px 0px 5px #888888; padding: 30px; width: 300px;">

				<h2 class="form-signin-heading">Please sign in</h2>
				<label for="inputEmail" class="sr-only">Email address</label> <input
					type="email" id="email" class="form-control"
					placeholder="Email address" required autofocus> <label
					for="inputPassword" class="sr-only">Password</label> <input
					type="password" id="password" class="form-control"
					placeholder="Password" required>
				
				<button class="btn btn-lg btn-primary btn-block" type="submit"  onclick="userLogin()">Sign in</button>
			</div>

		</div>
		<div style="margin: 180px 0px 0px 0px; float: right;">
			<div
				style="background-color: #EBEBE0; -webkit-box-shadow: 3px 0px 5px #888888; -moz-box-shadow: 3px 0px 5px #888888; box-shadow: 3px 0px 5px #888888; padding: 30px; width: 300px;">

				<h2 class="form-signin-heading">Please sign up</h2>
				<button class="btn btn-lg btn-success btn-block" type="submit" onClick="showSignupDiv()">Sign
					up</button>

			</div>

		</div>
	</div>

	<!-- /container -->
	
	<div id="signupdiv"  style="display:none;">
		<div style=" margin:180px 450px;">
			<div
				style="background-color: #EBEBE0; -webkit-box-shadow: 3px 0px 5px #888888; -moz-box-shadow: 3px 0px 5px #888888; box-shadow: 3px 0px 5px #888888; padding: 30px; width: 300px;">

				<h2 class="form-signin-heading">Please sign up</h2>
				<!-- table for signup -->
				
				<table>
          <tbody>
            <tr>
              <td>
               <p>First Name</p>
              </td> 
              <td>
         <input type="text" class="input-block-level" placeholder="First Name" id="firstName">
              </td>
            </tr>
               
            <tr>
              <td>
               <p>Last Name</p>
              </td>
              <td>
          <input type="text" class="input-block-level" placeholder="Last Name" id="lastName">
            </td>
            </tr>

            <tr>
               <td>
               <p>Email Address</p>
              </td>
              <td>
        <input type="email" class="input-block-level" placeholder="Email address" id="emailId" onBlur="validateEmail()">
              </td>
            </tr>

            <tr>
               <td>
               <p>Password</p>
              </td>
              <td>
        <input type="password" class="input-block-level" placeholder="Password" title="Password must contain minimum 3 upper case, 2 lower case and 2 special chars" onBlur="passwordCheck()" id="pass">
              </td>
              <td>
                <i class="icon-question-sign"  title="Password must contain minimum 3 upper case, 2 lower case and 2 special chars"></i>
              </td> 
              
            </tr> 

            <tr>
               <td>
               <p>Confirm Password</p>
              </td>
              <td>
         <input type="password" class="input-block-level" placeholder="Password must be same" id="cpass" onBlur="PasswordMatch()">
              </td>
            </tr>
          </tbody>
        </table>
				
				
				<!-- table end -->
				<button class="btn btn-lg btn-success btn-block" type="submit" onClick="signup()">Sign
					up</button>

			</div>

		</div>
	</div>
	
</body>

</body>



</html>
