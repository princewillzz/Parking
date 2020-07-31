<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="xyz.willz.entities.AdminParking"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link rel="stylesheet" href="./resources/css/fontawesome/css/all.css">
    
</head>
<body>
	<%@ include file="./navbar.jsp" %>
	<%
		if(session.getAttribute("admin") == null || session.getAttribute("user") != null) {
			response.sendRedirect("login.jsp");
			return;
		}
	%>
	<% if(session.getAttribute("parkingDetails") != null) {
		ArrayList<AdminParking> allData = (ArrayList<AdminParking>)session.getAttribute("parkingDetails");
	%>
	<main style="padding-top: 50px; text-align: center;">
	<h1>All Parking</h1>
	<table class="table table-striped table-hover">
        <thead>
          <tr>
            <th scope="col">SI.</th>
            <th scope="col">Parking Name</th>
            <th scope="col">Latitude</th>
            <th scope="col">Longitude</th>
            <th scope="col">Vacant</th>
            <th scope="col">Occupied</th>
            <th scope="col">Total</th>
            <th scope="col">Update</th>
          </tr>
        </thead>
        <tbody>
 
        <% for(int i = 0; i < 3; i++){ %>	
          <tr>
            <th scope="row"><%= i %></th>
            <td><%= allData.get(i).getParkingName() %></td>
            <td><%= allData.get(i).getLatitude() %></td>
            <td><%= allData.get(i).getLongitude() %></td>
            <td><%= allData.get(i).getVacant() %></td>
            <td><%= allData.get(i).getOccupied() %></td>
            <td><%= allData.get(i).getTotal() %></td>
            <td><button type="button" class="btn btn-success"><a href="updateparking?id=<%= allData.get(i).getId() %>" style="color: white;">Update</a></button></td>
          </tr>
          <% } %>
          
        </tbody>
        
      </table>
      <% } else { %>
      		<h1>No Details Found</h1>
      <% } %>
	
	</main>

		<!-- JS, Popper.js, and jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</body>
</html>