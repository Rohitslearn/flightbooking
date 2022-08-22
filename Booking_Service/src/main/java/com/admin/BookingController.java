package com.admin;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@CrossOrigin(origins="*")
@RestController
public class BookingController {
	
	

	@Autowired
	private BookFlightRepository bookRepository;
	
	@Autowired
	private RestTemplate restTemplate; 

	
	@ApiOperation(value = "get all the tickets.")
	
	@GetMapping("/findAllTickets")
	public List<BookFlight> getalltickets() {
		return bookRepository.findAll();
	}
	
	@GetMapping("/findAllflights")
	public List<Object> getsearchdetails() {
	Object[] objects = restTemplate.getForObject("http://FlightSearch/findAllFlights", Object[].class);
	return Arrays.asList(objects);
	}
	
	@GetMapping("/findAllflights/{flight_id}")
	public Optional<BookFlight> getbyflightid(@PathVariable String flight_id) {
		return bookRepository.findById(flight_id);
	}
	

	/*@GetMapping("/{id}")
	public Optional<BookTrain> getTicket(@PathVariable int id){
		return bookRepository.findById(id);
	}*/
	
	
	@PostMapping("/addTicket")
	public String saveTicket(@RequestBody BookFlight book) {
		bookRepository.save(book);
		return "Added Ticket with id:"+book.getFlight_id();
	}
	
	@PutMapping("/update/{id}")
	public BookFlight updateTicket(@PathVariable("id") String id,@RequestBody BookFlight Ticket ) {
		Ticket.setFlight_id(id);
	    bookRepository.save(Ticket);
		return Ticket;
	}
	@DeleteMapping("/delete/{id}")
	public String deleteTicket(@PathVariable String id) {
		bookRepository.deleteById(id);
		return "Ticket deleted by id:"+id;
	}
	
	
	

}
