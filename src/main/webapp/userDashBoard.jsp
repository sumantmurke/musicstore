<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">


<title>Dashboard</title>

<script type="text/javascript">

function getLists() {
	var userId = window.localStorage.getItem('userId');
	
	alert( userId);
	
	
	$.ajax({
		url : "music/Auth/getLikedItems",
		type : "GET",
		data : "userId=" + userId,
		dataType : "json",
		success : function(data, textStatus, jqXHR) {
			alert("success");
			window.location.href = "History.jsp";
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert('Could not process request.. ' + errorThrown);
			window.location.href = "userDashBoard.jsp";
		}
	});
}

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
	        alert(ele.value + " " + document.getElementById("searchButton").innerHTML);
	    	
	        var itemId = ele.value;
	        var itemType = document.getElementById("searchButton").innerHTML;
	        
	       // document.getElementById('reccotable').style.display = "none";
	    	//document.getElementById('searchtable').style.display = "block";
	        
	        $.ajax({
				url : "music/Auth/serachItems",
				type : "GET",
				data : "itemId=" + itemId + "&itemType=" + itemType,
				dataType : "json",
				success : function(data, textStatus, jqXHR) {
					alert("success" + data);
					window.location.href = "userDashBoard.jsp";
				},
				error : function(jqXHR, textStatus, errorThrown) {
					alert('Could not process request.. ' + errorThrown);
					window.location.href = "userDashBoard.jsp";
				}
			});
	    
	    }
	}


	function rates(track){
		alert("inside rates" + track);
		var ids = track.split("-");
		alert("splits " + ids[0] +" " + ids[1]);
		var rate = document.getElementById(ids[0]).value;
		alert(rate);
		//insertLikedItems
		var userId = window.localStorage.getItem('userId');
		$.ajax({
			url : "music/Auth/insertLikedItems",
			type : "POST",
			data : "userId=" + userId + "&itemId=" + ids[0] + "&rating=" + rate + "&itemType=" + ids[1],
			//dataType : "json",
			success : function(data, textStatus, jqXHR) {
				alert("success" + data);
				//window.location.href = "userDashBoard.jsp";
			},
			error : function(jqXHR, textStatus, errorThrown) {
				alert('Could not process request.. ' + errorThrown);
				window.location.href = "userDashBoard.jsp";
			}
		});
	}
	
	//rate album
	function rateAlbum(album){
		alert("inside rates" + album);
		var ids = album.split("-");
		alert("splits " + ids[0] +" " + ids[1]);
		var rate = document.getElementById(ids[0]).value;
		alert(rate);
		//insertLikedItems
		var userId = window.localStorage.getItem('userId');
		 $.ajax({
			url : "music/Auth/insertLikedItems",
			type : "POST",
			data : "userId=" + userId + "&itemId=" + ids[0] + "&rating=" + rate + "&itemType=" + ids[1],
			//dataType : "json",
			success : function(data, textStatus, jqXHR) {
				alert("success" + data);
				//window.location.href = "userDashBoard.jsp";
			},
			error : function(jqXHR, textStatus, errorThrown) {
				alert('Could not process request.. ' + errorThrown);
				window.location.href = "userDashBoard.jsp";
			}
		}); 
	}
	
	
	//add to cart
	function addtocart(){
		alert("inside add to cart");
		
		$.ajax({
			url : "music/Auth/addtocart",
			type : "POST",
			data : "userId=" + userId + "&itemId=" + ids[0] + "&rating=" + rate + "&itemType=" + ids[1],
			//dataType : "json",
			success : function(data, textStatus, jqXHR) {
				alert("success" + data);
				//window.location.href = "userDashBoard.jsp";
			},
			error : function(jqXHR, textStatus, errorThrown) {
				alert('Could not process request.. ' + errorThrown);
				window.location.href = "userDashBoard.jsp";
			}
		});
		
	}
	
	</script>

</head>

<body onload="getDetails();">
	<%--  <%@include file="navbar.jsp"% --%>>
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
            <li><a href="Recommendation.jsp">Recommendations</a></li>
            <li><a href="cart.jsp">Cart</a></li>
            <li><a href="#"  onclick="getLists();">History</a></li>
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
        

<!-- Search Table for track-->
<% if (session.getAttribute("isTrackFound") != null) { %>
<div id="searchtable" class="table-responsive" style="margin-top:20px; ">
            
              <table id="example" class="table table-hover">
					<thead>
						<tr>
							<th>Track Id</th>
							<th>Album Id</th>
							<th>Artist Id</th>
							<th>Genre Id</th>
							<th>Price</th>
							<th>Rate</th>
							<th style="display:none;">Type</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="item" items="${searchedTracks}" >
					
						 <tr>
							<td id="trackid">${item.getTrackId()}</td>
							
							<td id="albumid">${item.getAlbumId()}</td>
							
							<td id="artistid">${item.getArtistId()}</td>
							
							<td id="genreid">${item.getGenreIds()}</td>
							
							<td id="price">${item.getPrice()}</td>
								
							<td><input id="${item.getTrackId()}" type="text" placeholder="0-99" maxlength="2" size="2"></td>
								
							<td id="type" data-type="${item.getType()}" style="display:none;"></td>
						
							<td><button
									class="btn btn-success" id="${item.getTrackId()}-${item.getType()}" type="button" onclick="rates(this.id)">Rate</button></td>
									
							<td><button class="btn btn-primary" type="button" onClick="addtocart();">Add to Cart</button></td>
							
							
						
							
							
						</tr> 
						</c:forEach>
					</tbody>
					 
				</table>
          
          </div>
<%  } %>

<% if (session.getAttribute("isAlbumFound") != null) { %>

<div id="albumtable"class="table-responsive" style="margin-top:20px;">
           
              <table id="example" class="table table-hover">
					<thead>
						<tr>
							
							<th>Album Id</th>
							<th>Artist Id</th>
							<th>Genre Id</th>
							<th>Price</th>
							<th>Rate</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="item" items="${searchedAlbums}" >
					
						 <tr>
							
							
							<td id="albumid">${item.getAlbumId()}</td>
							
							<td id="artistid">${item.getArtistId()}</td>
							
							<td id="genreid">${item.getGenreIds()}</td>
							
							<td id="price">${item.getPrice()}</td>
							
							<td><input id="${item.getAlbumId()}"  type="text" placeholder="0-99" maxlength="2" size="2"></td>
							
							<td><button
									class="btn btn-success" type="button" id="${item.getAlbumId()}-${item.getType()}" onclick="rateAlbum(this.id)">Rate</button></td>
							
							
						</tr> 
						</c:forEach>
					</tbody>
					 
				</table>
          
          </div>

<%  } %>

<!--Search Table end-->


<!-- Table recco 
<div id="reccotable"class="table-responsive" style="margin-top:20px;">
            <h2>Here are some recommended songs for you</h2>
              <table id="example" class="table table-hover">
					<thead>
						<tr>
							<th>Track Id</th>
							<th>Album Id</th>
							<th>Artist Id</th>
							<th>Genre Id</th>
							<th>Price</th>
							<th>Rate</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="item" items="${tracks}" >
					
						 <tr>
							<td id="trackid">${item.getTrackId()}</td>
							
							<td id="albumid">${item.getAlbumId()}</td>
							
							<td id="artistid">${item.getArtistId()}</td>
							
							<td id="genreid">${item.getGenreIds()}</td>
							
							<td id="price">${item.getPrice()}</td>
							
							<td><input id="pricevalue"  type="text" placeholder="0-99" maxlength="2" size="2"></td>
							
							<td><button
									class="btn btn-success" type="button" onclick="rate()">Rate</button></td>
							
							
						</tr> 
						</c:forEach>
					</tbody>
					 
				</table>
          
          </div>
          -->
         <!-- table recco finish --> 

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