package xyz.willz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import xyz.willz.entities.AdminParking;

public class AdminParkingDao {
	private final String url;
	private final String uName;
	private final String pWord;
	private final String driverName;
	private boolean isEverythingOk = true;

	private Connection con;
	
	public AdminParkingDao() {
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
	
	public boolean add(final AdminParking newParking, final Integer adminId) {
		if(!this.isEverythingOk) {
			return false;
		}
		System.out.println("Going To add Item");
		System.out.println(newParking + " " + adminId);
		final String sql = "INSERT INTO parkings (parkingName, latitude, longitude, total, occupied, vacant, adminId) VALUES(?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement st = this.con.prepareStatement(sql);
			st.setString(1, newParking.getParkingName());
			st.setString(2, newParking.getLatitude());
			st.setString(3, newParking.getLongitude());
			st.setInt(4, newParking.getTotal());
			st.setInt(5, newParking.getOccupied());
			st.setInt(6, newParking.getVacant());
			st.setInt(7, adminId);
			
			st.execute();
			
		}catch(Exception e) {
			System.out.println("In Exception add Parking Dao: " + e);
			return false;
		}
		return true;
	}
	
	public List<AdminParking> fetchData(final Integer adminId) {
		ArrayList<AdminParking> parkingDetails = new ArrayList<>();
		if(this.isEverythingOk == false) {
			return parkingDetails;
		}
		
		final String query = "SELECT * FROM parkings where adminId = ?";
		
		try {
			
			PreparedStatement st = this.con.prepareStatement(query);
			st.setInt(1, adminId);
			
			ResultSet resultSet = st.executeQuery();
			
			System.out.println("Inside dao layer");
			while(resultSet.next()) {
				System.out.print("item: ");
				HashMap<String, Object> hmap = new HashMap<>();
				
				hmap.put("id", resultSet.getObject("id"));
				hmap.put("parkingName", resultSet.getObject("parkingName"));
				hmap.put("latitude", resultSet.getObject("latitude"));
				hmap.put("longitude", resultSet.getObject("longitude"));
				hmap.put("total", resultSet.getObject("total"));
				hmap.put("vacant", resultSet.getObject("vacant"));
				hmap.put("occupied", resultSet.getObject("occupied"));
				
				
				AdminParking adminParkingObj = new AdminParking(hmap);
				parkingDetails.add(adminParkingObj);
				
				System.out.println(adminParkingObj);
			}
			
		} catch(Exception e) {
			System.out.println("Exception in Dao layer");
		}
		
		//parkingDetails.add(new AdminParking(1, "harsh", "12121", "21212", 100, 20, 80));
		
		return parkingDetails;
	}
	
	
	public boolean update(final Integer parkingId, final String parkingName, final Integer vacant, final Integer occupied, final Integer total) {
		if(!this.isEverythingOk()) {
			return false;
		}
		
		try {
			// update the data in the database
			System.out.println("Starting Updating");
			final String updateQuery = "UPDATE parkings SET parkingName = ?, total = ?, occupied = ?, vacant = ? where id = ?";
			final PreparedStatement statement = this.con.prepareStatement(updateQuery);
			statement.setString(1, parkingName);
			statement.setInt(2, total);
			statement.setInt(3, occupied);
			statement.setInt(4, vacant);
			statement.setInt(5, parkingId);
			
			statement.execute();			
			System.out.println("finished update");
			
		} catch(Exception e) {
			System.out.println("Exception in AdminParking dao: " + e);
			return false;
		}
		
		return true;
	}
	
	
	public boolean isEverythingOk() {
		return isEverythingOk;
	}
	public void setEverythingOk(boolean isEverythingOk) {
		this.isEverythingOk = isEverythingOk;
	}
}
