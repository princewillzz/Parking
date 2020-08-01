package xyz.willz.entities;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

public class AdminParking {
	final private Integer id;
	private String parkingName;
	final private String latitude;
	final private String longitude;
	private Integer total, vacant, occupied;
	
	public AdminParking(HttpServletRequest request) {
		this.id = -1;
		this.parkingName = request.getParameter("parkingName");
		this.latitude = request.getParameter("latitude");
		this.longitude = request.getParameter("longitude");
		this.total = Integer.parseInt(request.getParameter("total"));
		this.vacant = Integer.parseInt(request.getParameter("vacant"));
		this.occupied = Integer.parseInt(request.getParameter("occupied"));
	}

//	public AdminParking(final Integer id, final String parkingName, final String latitude, final String longitude, final Integer totalParking, final Integer vacantParking, final Integer occupied) {
//		this.id = id;
//		this.parkingName = parkingName;
//		this.latitude = latitude;
//		this.longitude = longitude;
//		this.total = totalParking;
//		this.vacant = vacantParking;
//		this.occupied = occupied;
//	}
	public AdminParking(HashMap<String, Object> hmap) {
		this.id = (int)hmap.get("id");
		this.parkingName = (String)hmap.get("parkingName");
		this.latitude = (String)hmap.get("latitude");
		this.longitude = (String)hmap.get("longitude");
		this.total = (int)hmap.get("total");
		this.vacant = (int)hmap.get("vacant");
		this.occupied = (int)hmap.get("occupied");
	
	}
	
	public Integer getId() {
		return id;
	}
	public String getParkingName() {
		return parkingName;
	}
	public String getLatitude() {
		return latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setParkingName(final String parkingName) {
		this.parkingName = parkingName;
	}
	public void setTotal(Integer totalParking) {
		this.total = totalParking;
	}

	public Integer getVacant() {
		return vacant;
	}

	public void setVacant(Integer vacantParking) {
		this.vacant = vacantParking;
	}

	public Integer getOccupied() {
		return occupied;
	}

	public void setOccupied(Integer occupied) {
		this.occupied = occupied;
	}
	public Integer getTotal() {
		return total;
	}

	@Override
	public String toString() {
		return "AdminParking [id=" + id + ", parkingName=" + parkingName + ", latitude=" + latitude + ", longitude="
				+ longitude + ", totalParking=" + total + ", vacantParking=" + vacant + ", occupied="
				+ occupied + "]";
	}
	
}
