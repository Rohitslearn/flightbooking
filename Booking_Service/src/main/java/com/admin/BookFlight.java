package com.admin;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
@Document(collection = "BookedTicket")
public class BookFlight {
	@Id
	private String flight_id;
	@Field
	private String source;
	@Field
	private String destination;
	@Field
	private String seats;
	public BookFlight() {
		
	}
	public String getFlight_id() {
		return flight_id;
	}
	public void setFlight_id(String flight_id) {
		this.flight_id = flight_id;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getSeats() {
		return seats;
	}
	public void setSeats(String seats) {
		this.seats = seats;
	}
	public BookFlight(String flight_id, String source, String destination, String seats) {
		super();
		this.flight_id = flight_id;
		this.source = source;
		this.destination = destination;
		this.seats = seats;
	}
	
}
