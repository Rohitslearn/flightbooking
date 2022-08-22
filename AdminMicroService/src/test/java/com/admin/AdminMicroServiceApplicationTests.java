package com.admin;
import com.admin.models.*;
import com.admin.repository.*;
import com.admin.controller.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class AdminMicroServiceApplicationTests {
	 @Mock
		private AdminRepository repository; 
		 @Autowired
		 private AdminController control;
	@Test
	void contextLoads() {
	}
	 @Test 
	 public void addFlight(){
    	 Admin flight = new Admin ("2", "Note",
    		     "hyd","delhi");
    		     when((repository).insert(flight)).thenReturn(flight);
    		     assertEquals(flight, (repository).insert(flight)); }
	   @Test
		public void getFlight(){
		when(repository.findAll()).thenReturn(Stream.of(new Admin("2","Note","hyd","delhi")).collect(Collectors.toList()));
		assertEquals(1,control.getBooks().size());
		}
	   
	 
}
