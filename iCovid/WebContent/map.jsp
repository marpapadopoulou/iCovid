<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


 


<!doctype html>
<html lang="en">

<head>


<script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>
    <script
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBhOLkFOsO14LjW4PVUVCja9PnvutCyuIc&callback=initMap&libraries=&v=weekly"
      defer
    ></script>
    

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">

<link
	href="https://fonts.googleapis.com/css2?family=Quicksand&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="style.css" />
<title>iCovid</title>

 
    
</head>

<body>
		
	<%@page import="java.util.ArrayList"%> 
		
		
		
	<!-- Optional JavaScript; choose one of the two! -->

	<!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
		crossorigin="anonymous"></script>
	<script src="https://kit.fontawesome.com/de5d6b149f.js"
		crossorigin="anonymous"></script>


	<!--navigation bar-->
	<nav
		class="navbar navbar-expand-md navbar-fixed-top navbar-light bg-light sticky-top"
		role="navigation">
		<div class="container-fluid">
			<a class="navbar-brand" href="index.jsp"><img src="img/logo.png"></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a href="index.jsp" class="nav-link">
							Home </a></li>
					
					<!--  If user is logged in hide the register panel-->
					<c:if test='${not empty loguser}'>
							<a href="test.jsp"
							class="nav-link"> Take the test </a>
						
					</c:if>
					<c:if test='${ empty loguser}'>	
							<a href="registration.jsp"
							class="nav-link"> Take the test </a>
					</c:if>
					<li class="nav-item"><a href="about.jsp" class="nav-link">
							About </a></li>
				</ul>
			</div>
		</div>
	</nav>

<% 
 	ArrayList<String> markers= new ArrayList<String>();
 	markers=(ArrayList<String>) session.getAttribute("coords");	
 	System.out.println(markers);
 %>	
 	
 	
<script>
		var markers=[
			<c:forEach var="marker" items="${markers}">
				{"latLng":[<c:out value="${marker.lat}" />
						   <c:out value="${marker.lng}" />]
				}
			</c:forEach>	
		];
			
		function initMap(){
				var map;
				var options={
					zoom:8,
					center:{lat:40.6, lng:22.07}
					}
				map = new google.maps.Map(document.getElementById("map"),options);
			
			for( i = 0; i < markers.length; i++ ) {
			    var position = new google.maps.LatLng(markers[i][1],markers[i][2]);

			    marker = new google.maps.Marker({
			      position: position,
			      map: map
			    });
			} 
			    
		}	
					
</script>
  
<h1 class="landing-text">Risk Map</h1>
<div id="map"></div>

 
	<!--footer-->
	<footer class="container-fluid text center">
		<h3>Contact us</h3>
		<a href="#" class="fas fa-phone-alt"></a> <a href="#"
			class="fab fa-facebook"> </a> <a href="#" class="fab fa-linkedin-in">
		</a> <a href="#" class="fas fa-envelope"></a> <a href="#"
			class="fab fa-twitter"></a>
	</footer>

</body>
</html>