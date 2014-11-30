<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">


<title>Dashboard Template for Bootstrap</title>

<script type="text/javascript">
	function getDetails() {
		var firstName = window.localStorage.getItem('firstName');
		var lastName = window.localStorage.getItem('lastName');
		var userId = window.localStorage.getItem('userId');
		
		alert(firstName + " " + lastName + " " + userId);
		
		
		$.ajax({
			url : "music/Auth/getRecc",
			type : "GET",
			data : "userId=" + userId,
			///dataType : "json",
			success : function(data, textStatus, jqXHR) {
				alert("success");
			},
			error : function(jqXHR, textStatus, errorThrown) {
				alert('Could not process request.. ' + errorThrown);
				window.location.href = "login.jsp";
			}
		});
	}
	
	
	
	 //funaction for search type   
	  function searchType(Type){
	    var type = Type;
	    alert(type);

	 document.getElementById("searchButton").innerHTML = type;
	alert(element);

	  


	  }

	//function for search on search bar after pressing enter
	  function search(ele) {


	    if(event.keyCode == 13) {
	       alert('inside search after enter');
	        alert(ele.value);  
	        alert(document.getElementById("searchButton").innerHTML);      
	    }
	}


	
	</script>

</head>

<body onload="getDetails();">
	 
	 <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Project name</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#">Dashboard</a></li>
            <li><a href="#">Settings</a></li>
            <li><a href="#">Profile</a></li>
            <li><a href="#">Help</a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
    </nav>

    <div class="container-fluid" style="margin-top:80px;">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li class="active"><a href="#">Find Songs <span class="sr-only">(current)</span></a></li>
            <li><a href="#">Recommendations</a></li>
            <li><a href="#">Analytics</a></li>
            <li><a href="#">History</a></li>
          </ul>
          
        </div>
        <div class="col-sm-9 main">
          <h1 class="page-header">Dashboard</h1>


          <h2 class="sub-header">Search your songs here</h2>
        <!-- Search bar-->


<div class="row">
  <div class="col-lg-6">
    <div class="input-group">
      <div class="input-group-btn">
        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false" id="searchButton" >Type of Search <span class="caret"></span></button>
        <ul class="dropdown-menu" role="menu">
          <li><a id="Track" onClick ="searchType(this.id)">Track</a></li>
          <li><a id="Album" onClick ="searchType(this.id)">Album </a></li>
          <li><a id="Artist" onClick ="searchType(this.id)">Artist</a></li>
          <li><a id="Genre" onClick ="searchType(this.id)">Genre </a></li>
        </ul>
      </div><!-- /btn-group -->
      <input type="text" class="form-control" onkeydown="search(this)">
    </div><!-- /input-group -->
  </div><!-- /.col-lg-6 -->
</div><!-- /.row-->


        <!-- Search bar end-->
        

<!-- Table-->
<!--
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>#</th>
                  <th>Header</th>
                  <th>Header</th>
                  <th>Header</th>
                  <th>Header</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>1,001</td>
                  <td>Lorem</td>
                  <td>ipsum</td>
                  <td>dolor</td>
                  <td>sit</td>
                </tr>
                <tr>
                  <td>1,002</td>
                  <td>amet</td>
                  <td>consectetur</td>
                  <td>adipiscing</td>
                  <td>elit</td>
                </tr>
                <tr>
                  <td>1,003</td>
                  <td>Integer</td>
                  <td>nec</td>
                  <td>odio</td>
                  <td>Praesent</td>
                </tr>
              </tbody>
            </table>
          </div>
        -->

<!-- Table end-->

        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
   
   
   
  </body>
</html>