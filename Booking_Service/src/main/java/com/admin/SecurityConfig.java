package com.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	JwtRequestFilter jwtfilter;
	@Autowired
	private UserService userservice;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userservice);
	}
	
	private static final String[] AUTH_WHITELIST = {
			"/v2/api-docs",
			"/swagger-resources",
			"/swagger-resources/**",
			"/configuration/ui",
			"/configuration/security",
			"/swagger-ui.html",
			"/swagger-ui.html#",
			"/webjars/**",
			"/v3/api-docs/**",
			"/swagger-ui/**"
			};
	
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.cors().disable();
//		http.csrf().disable()
//		.authorizeRequests()
//		.antMatchers("/subs", "/auth","/test","/dashboard",
//				"/AllTickets","/AllTrains","/AllTickets/{id}",
//				"/addTicket","/update/{id}","/delete/{id}").permitAll()
//		.antMatchers(AUTH_WHITELIST).permitAll()
//		.anyRequest().authenticated().and()
//		.sessionManagement()
//        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//		http.addFilterBefore(jwtfilter, UsernamePasswordAuthenticationFilter.class);
//	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	http.cors().disable();
	http.csrf().disable()
	.authorizeRequests()
	.antMatchers("/subs", "/auth","/test","/dashboard",
			"/addTicket","/update/{id}","/findAllflights",
			"/findAllTickets","/findAllflights/{flight_id}",
				"/update/{id}","/delete/{id}").permitAll()
	.antMatchers(AUTH_WHITELIST).permitAll()
		.anyRequest().authenticated().and()
		.sessionManagement()
       .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	http.addFilterBefore(jwtfilter, UsernamePasswordAuthenticationFilter.class);
}

	 
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManagerBean();
	}

}
