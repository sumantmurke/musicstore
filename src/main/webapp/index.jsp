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
		    	success:function(data, textStatus, jqXHR){
		    		
			    	window.location.href="userDashBoard.jsp";    
			    },
		    error: function(jqXHR, textStatus, errorThrown){
		    	alert('Could not process request.. ' + errorThrown);
		    	window.location.href="login.jsp";
		    }
		});
}
</script>	
	
	
	
	
<body background="musicnote.jpg">
	<div class="container">
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
				<button class="btn btn-lg btn-success btn-block" type="submit">Sign
					in</button>

			</div>

		</div>
	</div>

	<!-- /container -->
</body>

</body>



</html>
