package com.admin.models;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Search")
public class Admin {
	@Id
	private String flightid;
	private String flightName;
	private String from_location;
	private String to_location;
	public String getFlightid() {
		return flightid;
	}
	public Admin(String flightid, String flightName, String from_location, String to_location) {
		super();
		this.flightid = flightid;
		this.flightName = flightName;
		this.from_location = from_location;
		this.to_location = to_location;
	}
	public void setFlightid(String flightid) {
		this.flightid = flightid;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public String getFrom_location() {
		return from_location;
	}
	public void setFrom_location(String from_location) {
		this.from_location = from_location;
	}
	public String getTo_location() {
		return to_location;
	}
	public void setTo_location(String to_location) {
		this.to_location = to_location;
	}
}
