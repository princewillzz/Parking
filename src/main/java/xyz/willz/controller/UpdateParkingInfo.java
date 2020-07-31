package xyz.willz.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import xyz.willz.entities.AdminParking;

@WebServlet("/updateparking")
public class UpdateParkingInfo extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Integer id = Integer.valueOf((String)request.getAttribute("id"));
		try{
			Integer id = Integer.valueOf(request.getParameter("id"));
			HttpSession session = request.getSession();
			List<AdminParking> allData = (List<AdminParking>)session.getAttribute("parkingDetails");
			AdminParking data = allData.get(id);
			session.setAttribute("dataToBeUpdated", data);
		} catch(Exception e) {
			System.out.println("Error");
			response.sendRedirect("index.jsp");
		}
		System.out.println("preprocesses");
		try {
//			RequestDispatcher rd = request.getRequestDispatcher("updateparking.jsp");
//			rd.forward(request, response);
			response.sendRedirect("updateparking.jsp");
		} catch(Exception e) {
			System.out.println("Error dispatcher");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("About to update Data");
		
		response.sendRedirect("admin");
	}
}
