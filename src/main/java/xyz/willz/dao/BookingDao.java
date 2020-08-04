package xyz.willz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

import xyz.willz.entities.BookingInfo;

public class BookingDao {
	private final String url;
	private final String uName;
	private final String pWord;
	private final String driverName;
	private boolean isEverythingOk = true;
	private Connection con;
	
	public BookingDao() {
		this.url = "jdbc:mysql://localhost:3306/parking";
		this.uName = "root";
		this.pWord = "root";
		this.driverName = "com.mysql.cj.jdbc.Driver"; 
		
		
		try {
			
			Class.forName(this.driverName);
			con = DriverManager.getConnection(url, uName, pWord);
			
		} catch(Exception e) {
			this.isEverythingOk = false;
		}
		
	}
	
	public boolean makeBooking(BookingInfo bookingInfo) {
		if(!this.isEverythingOk) return false;
		
		final String sql = "INSERT INTO bookings(parking_id, buyer_id, vehicle_type, arrival_time, departure_time, arrival_date, departure_date) values (?, ?, ?, ?, ?, ?, ?)";
		try {
			final PreparedStatement st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.setInt(1, bookingInfo.getParkingId());
			st.setInt(2, bookingInfo.getBuyerId());
			st.setString(3, bookingInfo.getVehicleType());
			st.setString(4, bookingInfo.getArrivalTime());
			st.setString(5, bookingInfo.getDepartureTime());
			st.setString(6, bookingInfo.getArrivalDate());
			st.setString(7, bookingInfo.getDepartureDate());
			
			st.execute();
			
			this.incrementParking(bookingInfo.getParkingId());
			bookingInfo.setVacant(bookingInfo.getVacant()-1);
			return true;
//			int rowAffected = st.executeUpdate();
//			if(rowAffected == 1) {
//				int candidateId = 0;
//				ResultSet rs = st.getGeneratedKeys();
//				if(rs.next())
//				   candidateId = rs.getInt(1);
//				
//				System.out.println(candidateId);
//				this.incrementParking(candidateId);
//				return true;
//			}
			
			//this.incrementParking(); 
		}catch(Exception e) {
			System.out.println("Exception while saving: " + e);
		}
		return false;
	}
	
	
	private void incrementParking(int id) {
		final String sql = "UPDATE parkings SET vacant = parkings.vacant - 1, occupied = parkings.occupied + 1 where id = ?";
		try {
			System.out.println("going to update vacancy's ");
			final PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			st.execute();
			System.out.println("Updated vacancy");
		} catch(Exception e) {
			System.out.println("Exception: " + e);
		}
	}
	
	public boolean validate(BookingInfo bookingInfo) {
		if(!this.isEverythingOk) return false;
		
		// Check in the database whether it is available or not
		final String sql = "SELECT vacant FROM parkings WHERE id = ?";
		try {
			final PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, bookingInfo.getParkingId());
			
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
				bookingInfo.setVacant(rs.getInt("vacant"));
				if(bookingInfo.getVacant() > 0) { 
					System.out.println("Valid Booking dao layer");
					return true;
				}
			}
			
		} catch(Exception e) {
			System.out.println("in exception " + e.getMessage());
		}
		System.out.println("Not Vacant for booking dao layer");
		return false;
	}
	
	
}
