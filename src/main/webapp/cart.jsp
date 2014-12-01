<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
<title>Cart</title>
</head>
<body>
<!-- Header -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">MusicLibrary</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="userDashBoard.jsp">Dashboard</a></li>
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
   <div class="col-sm-9 main"style="margin-top:35px; ">  
   <h2>Cart</h2> 
   
 <!-- table for cart  -->  
   <% if (session.getAttribute("itemspurchase") != null) { %> 
<div id="searchtable" class="table-responsive" style="margin-top:20px; ">
            
              <table id="example" class="table table-hover">
					<thead>
						<tr>
							<th>Item Id</th>
							<th>Type</th>
							<th>Price</th>
							
						</tr>
					</thead>
					<tbody>
					<c:forEach var="item" items="${itemsPurchasedListisThere}" >
						 <tr>
							<td id="itemid">${item.getItemId()}</td>
							<td id="albumid">${item.getItemType()}</td>
							<td id="albumid">${item.getPrice()}</td>
						</tr> 
						</c:forEach>
					</tbody>
					 
				</table>
          
          </div>

 <%  } else {%> 
 
 <h2>No Cart Found</h2>
 
 <% } %>
 
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