<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %> 
<title>Recommendation</title>
<script type="text/javascript">

function getReccos() {
	var trackReccomended = window.localStorage.getItem("trackReccomended");
	var albumReccomended = window.localStorage.getItem("albumReccomended");
	var artistReccomended = window.localStorage.getItem("artistReccomended");
	var genreReccomended = window.localStorage.getItem("genreReccomended");
	var userId = window.localStorage.getItem("userId");
	
	 $.ajax({
			url : "music/Auth/reccomended",
			type : "GET",
			data : "userId=" + userId + "&tracksRecc=" + trackReccomended + "&albumRecc=" + albumReccomended + "&artistRecc=" + artistReccomended + "&genreRecc=" + genreReccomended,
			success : function(data, textStatus, jqXHR) {
				console.log("sucess in reccomondatin " + data);
			},
			error : function(jqXHR, textStatus, errorThrown) {
				alert('Could not process request.. ' + errorThrown);
				window.location.href = "userDashBoard.jsp";
			}
		});
}
</script>
</head>

<body onload="getReccos();">
<%@include file="navbar.jsp"%>

<h3 style="margin-top:55px; "> Recommended Tracks </h3>
<% if (session.getAttribute("isReccTracks") != null) { %>
<div id="searchtable" class="table-responsive" >
              <table id="example" class="table table-hover">
					<thead>
						<tr>
							<th>Track Id</th>
							<th>Score</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="item" items="${reccomTracks}" >
						 <tr>
							<td id="trackid">${item.getTrackId()}</td>
							<td id="price">${item.getRating()}</td>
						</tr> 
						</c:forEach>
					</tbody>
				</table>
          </div>
<%  } else {%> 
No tracks recommended
<% } %> 

<h3 style="margin-top:30px; "> Recommended Albums </h3>
<% if (session.getAttribute("isReccAlbums") != null) { %>
<div id="searchtable" class="table-responsive" >
              <table id="example" class="table table-hover">
					<thead>
						<tr>
							<th>Album Id</th>
							<th>Score</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="item" items="${reccomAlbums}" >
						 <tr>
							<td id="albumId">${item.getAlbumId()}</td>
							<td id="rating">${item.getRating()}</td>
						</tr> 
						</c:forEach>
					</tbody>
				</table>
          </div>
<%  } else {%> 
No albums recommended
<% } %> 

<h3 style="margin-top:30px; "> Recommended Artist </h3>
<% if (session.getAttribute("isReccArtist") != null) { %>
<div id="searchtable" class="table-responsive" >
              <table id="example" class="table table-hover">
					<thead>
						<tr>
							<th>Artist Id</th>
							<th>Score</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="item" items="${reccomArtists}" >
						 <tr>
							<td id="artistID">${item.getArtistId()}</td>
							<td id="rating">${item.getRating()}</td>
						</tr> 
						</c:forEach>
					</tbody>
				</table>
          </div>
<%  } else {%> 
No artist recommended
<% } %> 


<h3 style="margin-top:30px; "> Recommended Genres </h3>
<% if (session.getAttribute("isReccGenres") != null) { %>
<div id="searchtable" class="table-responsive" >
              <table id="example" class="table table-hover">
					<thead>
						<tr>
							<th>Artist Id</th>
							<th>Score</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="item" items="${reccomGenres}" >
						 <tr>
							<td id="artistID">${item.setGenreId()}</td>
							<td id="rating">${item.getRating()}</td>
						</tr> 
						</c:forEach>
					</tbody>
				</table>
          </div>
<%  } else {%> 
No genre recommended
<% } %> 
</body>
</html>