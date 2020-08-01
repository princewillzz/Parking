<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link rel="stylesheet" href="./resources/css/fontawesome/css/all.css">
    <link rel="stylesheet" href="./resources/css/index.css">
</head>
<body>
	
	<main style="text-align: center;">
		
		<h1>Find Parking</h1>
		
			<!-- The Booking Form Container -->
		<form action="bookparking" method="post" class="BookingForm py-3 my-3">
		    
		    <div class="form-group EnterLocationContainer" id="EnterLocationContainer">
		      <input name="parkingName" type="text" id="EnterLocation" class="EnterLocation form-control my-3 py-3 mx-auto" placeholder="Enter Location" /> 
		    </div>
		    
		  <!-- <div class="row px-3 py-3">
		    <div class="col">
		      <label for="Arrival mx-auto">Arrival</label>
		      <select name="arrivalDate" class="form-control" id="ArrivalDate"></select>
		      <select name="arrivalTime" class="form-control " id="ArrivalTime"></select>
		    </div>
		    <div class="col">
		      <label for="Departure">Departure</label>
		      <select name="departureDate" class="form-control" id="DepartureDate"></select>
		      <select name="departureTime" class="form-control" id="DepartureTime"></select>
		    </div>
		  </div> -->
		  
		  <button type="submit" class="btn btn-info w-75">Find Parking</button>
		
		</form>
		<!-- End Of Booking Form -->
		
	
	</main>
	
	
		<!-- JS, Popper.js, and jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

</body>
</html>