package com.flightsearch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import com.flightsearch.Repository.*;
import com.flightsearch.controller.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@SpringBootTest
class FlightSearchApplicationTests {
	
  @Mock
	private SearchRepository repository; 
	 @Autowired
	 private SearchController control;
	 @Test
	 void contextLoads() {

	 }
	 /*
	   @Test
		public void getFlight(){
		when(repository.findAll()).thenReturn(Stream.of(new Search("2","Note","hyd","delhi")).collect(Collectors.toList()));
		assertEquals(1,control.getBooks().size());
		}*/
  }

	
	
	
