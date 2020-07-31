package xyz.willz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
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
	public List<AdminParking> fetchData() {
		ArrayList<AdminParking> parkingDetails = new ArrayList<>();
		if(this.isEverythingOk == false) {
			return parkingDetails;
		}
		
		for(int i = 0; i < 3; i++) {
			parkingDetails.add(new AdminParking(i, "harsh", "12121", "21212", 100, 20, 80));
		}
		return parkingDetails;
	}
	public boolean isEverythingOk() {
		return isEverythingOk;
	}
	public void setEverythingOk(boolean isEverythingOk) {
		this.isEverythingOk = isEverythingOk;
	}
}
