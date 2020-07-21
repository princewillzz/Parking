<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="xyz.willz.entities.BookingInfo"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirmation</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link rel="stylesheet" href="./resources/css/fontawesome/css/all.css">
    <link rel="stylesheet" href="./resources/css/confirmation.css">
</head>
<body>
	<%@ include file="./navbar.jsp" %>

	<%
		BookingInfo bookingInfo = (BookingInfo)session.getAttribute("bookingInfo");
	%>
	<div class="heading">
	  <% if(bookingInfo.isAvailable()) { %>
	  <h1>Confirm Details</h1>
	  <% } else { %>
	  <h1>Parking Full</h1>
	  <% } %>
	</div>
	<main>
	<!-- The Booking Form Container -->
	  <form action="<% if(bookingInfo.isAvailable()){ %>https://google.com<% } else{ %>https://github.com<% } %>" class="confirmationForm">
	  
	  	<div class="form-group ParkingNameContainer" id="ParkingNameContainer">
	      <input name="parkingName" value="<%= bookingInfo.getParkingName() %>" type="text" id="ParkingName" class="form-control my-3 py-3 mx-auto" readonly/>
		</div>
		<% if(!bookingInfo.isAvailable()){ %>
		<label class="w-100 mx-auto" for="heading"><i class="fas fa-hand-point-down text-danger" style="transform: rotate(20deg);"></i>(Change Location or details)<i class="fas fa-hand-point-down text-danger" style="transform: rotate(-20deg);"></i></label>
		<% } %>
	    <div class="row px-3 py-3">
		    <div class="col">
		      <label for="Arrival mx-auto">Arrival</label>
		      <select name="arrivalDate" class="form-control" id="ArrivalDate">
		      	<option value="<%= bookingInfo.getArrivalDate() %>"><% out.print(bookingInfo.getArrivalDate()); %></option>		      
		      </select>
		      <select name="arrivalTime" class="form-control " id="ArrivalTime">
		      	<option value="<%= bookingInfo.getArrivalTime() %>"><% out.print(bookingInfo.getArrivalTime()); %></option>
		      </select>
		    </div>
		    <div class="col">
		      <label for="Departure">Departure</label>
		      <select name="departureDate" class="form-control" id="DepartureDate">
		      	<option value="<%= bookingInfo.getDepartureTime() %>"><% out.print(bookingInfo.getDepartureDate()); %></option>
		      </select>
		      <select name="departureTime" class="form-control" id="DepartureTime">
		      	<option value="<%= bookingInfo.getDepartureTime() %>"><% out.print(bookingInfo.getDepartureTime()); %></option>
		      </select>
		    </div>	
		</div>
		  <% if(bookingInfo.isAvailable()) { %> 
			<button type="submit" class="btn btn-primary w-75">Confirm Booking</button>
			<% } else { %>
			<button type="submit" class="btn btn-danger w-75 disabled">Find Parking</button>
			<% } %>
	
	  </form>
	<!-- End Of Booking Form -->
	</main>	
	

	<%@ include file="./footer.jsp" %>
	
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
	
	<script src="./resources/js/booking.js" type="text/javascript"></script>
</body>
</html>