<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="xyz.willz.entities.AdminParking" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	</head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link rel="stylesheet" href="./resources/css/fontawesome/css/all.css">
<body>
	
	<% 
		AdminParking data = (AdminParking)session.getAttribute("dataToBeUpdated");
	%>
	<main style="text-align: center; padding: 20px; margin: 5px;">
	
	<h1>Update Info Of this Parking</h1>
	
	<form action="updateparking" method="post" style="margin-top: 15vh; background: tomato;">
		
		  <div class="form-row justify-content-center" style="text-align: center;">
		    <div class="form-group col-md-6" style="max-width: 400px;">
		      <label for="latitude">Latitude</label>
		      <input value=<%= data.getLatitude() %> type="text" class="form-control" id="Latitude" required="true" >
		    </div>
		    <div class="form-group col-md-6" style="max-width: 400px;">
		      <label for="Longitude">Longitude</label>
		      <input value=<%= data.getLongitude() %> type="text" class="form-control" id="Longitude" required="true" > 
		    </div>
		  </div>

		<div class="form-row justify-content-center" >
		    <div class="form-group col" style="max-width: 265px;">
		      <label for="vacant">Vacant</label>
		      <input value=<%= data.getVacant() %> type="text" class="form-control" id="vacant" value=<%= data.getVacant() %>>
		    </div>
		    <div class="form-group col" style="max-width: 265px;">
		      <label for="occupied">Occupied</label>
		      <input value=<%= data.getOccupied() %> type="text" class="form-control" id="occupied">
		    </div>
		    <div class="form-group col" style="max-width: 265px;">
		      <label for="total">Total</label>
		      <input value=<%= data.getTotal() %> type="text" class="form-control" id="total" >
		    </div>
		</div>
		
		<div class="form-group" style="text-align: center;">
	    	<label for="parkingAddress">Address</label>
	    	<input value=<%= data.getParkingName() %> type="text" class="form-control" id="parkingAddress" placeholder="Address" required="true" style="max-width: 500px; margin-left: 30%; margin-right: 30%; margin: auto;">
		</div>
		
		<button type="submit" class="btn btn-danger" style="width: 150px;">Update</button>
		
	</form>
	
	</main>
	
		<!-- JS, Popper.js, and jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
 	
 	<style>
		input{
			text-align: center;
		} 		

 	</style>
	
</body>
</html>