package com.admin.controller;
import java.util.Arrays;

import java.util.List;
import com.admin.repository.*;
import com.admin.models.*;
import com.admin.*;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@CrossOrigin(origins="http://localhost:4200")
@RestController()
public class AdminController {
	
		@Autowired
		private AdminRepository repository;
		@Autowired
		private RestTemplate restTemplate;
		
		@PostMapping("/addFlight")
		public String addingflight(@RequestBody Admin flight) {
			repository.save(flight);
			return "Added book with id : " + flight.getFlightid();
		}

	@GetMapping("/findAllFlights")
		public List<Admin> getBooks() {
			return repository.findAll();
		}
	@GetMapping("/search")
	public List<Object> getSearch(){
		Object[] objects=restTemplate.getForObject("http://FlightSearch/findAllFlights",Object[].class);
		return Arrays.asList(objects);
	}

		@GetMapping("/findAllFlights/{flightid}")
		public Optional<Admin> getbyflightid(@PathVariable String flightid) {
			return repository.findById(flightid);
		} 
		/*@GetMapping("/findAllflights/{flight_id}")
		public Optional<BookFlight> getbyflightid(@PathVariable String train_id) {
			return bookRepository.findById(train_id);
		}*/

		@DeleteMapping("/delete/{flightid}")
		public String deleteFlight (@PathVariable String flightid) {
			repository.deleteById(flightid);
			return "Deleted with id : "+flightid;
		
		}
		@PutMapping("/update/{flightid}")
		public Admin updateFlight(@PathVariable("flightid") String flightid,@RequestBody Admin f ) {
			f.setFlightid(flightid);
			repository.save(f);
			return f;
	}
	}

