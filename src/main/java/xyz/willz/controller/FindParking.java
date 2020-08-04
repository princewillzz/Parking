package xyz.willz.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import xyz.willz.dao.ParkingsDao;
import xyz.willz.entities.AdminParking;

@WebServlet("/findparkings")
public class FindParking extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final HttpSession session = req.getSession();
		
		try {
			session.removeAttribute("parkings");
		} catch(Exception e) {
			System.out.println("Exception: " + e);
		}
		
		try {System.out.println("Finding Parkings");
			
			final String address = req.getParameter("address");
			ParkingsDao parkingsDao = new ParkingsDao();
			List<AdminParking> parkings = parkingsDao.findParkings(address);

			session.setAttribute("parkings", parkings);
			System.out.println("sending You Parkings");
		} catch(Exception e) {
			System.out.println("Exception: "+e);
		}
		resp.sendRedirect("index.jsp");
	}
	
}
