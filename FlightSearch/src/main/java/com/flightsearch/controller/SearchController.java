package com.flightsearch.controller;
import java.util.Arrays;
import java.util.List;
import com.flightsearch.models.*;
import com.flightsearch.*;
import java.util.Optional;
import com.flightsearch.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class SearchController {
	@Autowired
	private SearchRepository repository;
	
//	@PostMapping("/addTicket")
//	public String addingticket(@RequestBody Search book) {
//		repository.save(book);
//		return "Added Ticket with id:"+book.getFlightid();
//	}
	
	@GetMapping("/findAllFlights")
	public List<Search> gettickets() {
		return repository.findAll();
	}
	@GetMapping("/findAllFlights/{flightid}")
	public Optional<Search> getbyflightid(@PathVariable String flightid) {
		return repository.findById(flightid);
	}
}
