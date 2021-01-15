<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


 <%@page import="java.util.ArrayList"%> 


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
<link rel="stylesheet" href="styleNew.css" />
<title>iCovid</title>

<script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
	 
<script type="text/javascript">	 

<% ArrayList<Float> list= new ArrayList<Float>();%>
<%list= (ArrayList<Float>)request.getAttribute("coords");%>
     //2d array
<%float[][] arr = new float[list.size()/2][2]; %>
 
 
 var arr = [];
//populating the 2d array with each user's coords
<% for (int reg=0; reg<list.size(); reg++) { %>
 	<% for (int i=0; i<list.size()/3; i++) { %>
 	arr.push([]);
 		<% for (int j=0 ; j<3; j++) { %>
		 	arr[<%= i %>][<%=j%>] = <%= list.get(reg++) %>;
	 <% } %>
   <% } %>
 <% } %>
	 
 for (var i in arr) 
 {
    console.log("row " + i);
    for (var j in arr[i]) 
      {
       console.log(" " + arr[i][j]);
      }
 }
		
	function initMap(){
		var options={
			zoom:8,
			center:new google.maps.LatLng(40.6,22.07)
		}
		var map = new google.maps.Map(document.getElementById("map"),options);
					    
	
	addMarkers(map,arr);
}
	
	
	function addMarkers(map,locations){
		
		for(var i = 0; i < arr.length; i++ ) {
			
			
			const coord=arr[i];
			
			
			var position = new google.maps.LatLng(coord[0],coord[1]);
			
			if(coord[2] <= 33){
			var marker = new google.maps.Marker({
			   position: position,
			   map: map,
			   icon:'http://maps.google.com/mapfiles/kml/paddle/grn-circle.png',
				
			 });
			}
			
			if (coord[2] > 33 &&coord[2] <= 66){
				
				var marker = new google.maps.Marker({
				   position: position,
				   map: map,
				   icon:'http://maps.google.com/mapfiles/kml/paddle/orange-circle.png',
					
				 });
			}
			if(coord[2] > 66){
				var marker = new google.maps.Marker({
				   position: position,
				   map: map,
				   icon:'http://maps.google.com/mapfiles/kml/paddle/red-circle.png',
				});
				
			}
		}
	}
						
</script>

</head>

<body>
		
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
					<li class="nav-item"><a href='${pageContext.request.contextPath}/#about' class="nav-link">
							About </a></li>
				</ul>
				
				<c:if test='${not empty sessionScope.loguser}'> 
	
					<form action="logout" method="get">
						<div class="button nameuser">Logged as, ${sessionScope.loguser.name}</div>
						<a href='${pageContext.request.contextPath}/logout' class="button logout">Logout </a>
					</form>
	
			  	</c:if> 
				<c:if test='${ empty loguser}'>
					<a href="login.jsp" class="signIn-btn"> Sign in</a>
				</c:if>
			</div>
		</div>
	</nav>




 
<h1 class="landing-text-map">Live Covid-19 cases map</h1>
<div id="map"></div>
<div class="map-info">
	<p>This map illustrates the epidemiological levels per region according to the users of the application that took the test.
	The results are displayed in green markers by users with a low probability of getting sick, in orange markers with a medium propability of getting sick and in red markers with a high probability of getting sick.
	Discover possible cases in your area and protect yourself from getting exposed to coronavirus.</p>
</div>
 
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