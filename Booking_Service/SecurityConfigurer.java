package com.booking;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import com.booking.jwt.*;
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



import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
@Autowired
private MyUserDetailsService myUserDetailsService;
@Autowired
private JwtRequestFilter jwtRequestFilter;
@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
auth.userDetailsService(myUserDetailsService);
}

@Override
protected void configure(HttpSecurity http) throws Exception {
// TODO Auto-generated method stub
http.csrf().disable()
.authorizeRequests().antMatchers("/authenticate","/v2/api-docs",
        "/configuration/ui",
        "/swagger-resources/**",
        "/configuration/security",
        "/swagger-ui.html",
        "/webjars/**").permitAll().
anyRequest().authenticated()
.and().sessionManagement()
.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
}


private ApiKey apiKey() {
return new ApiKey("JWT", "Authorization", "header");
}
private ApiInfo apiInfo() {
return new ApiInfo(
"My REST API",
"Some custom description of API.",
"1.0",
"Terms of service",
new Contact("Sallo Szrajbman", "www.baeldung.com", "salloszraj@gmail.com"),
"License of API",
"API license URL",
Collections.emptyList());
}
private SecurityContext securityContext() {
return SecurityContext.builder().securityReferences(defaultAuth()).build();
}


 private List<SecurityReference> defaultAuth() {
AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
authorizationScopes[0] = authorizationScope;
return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
}
 

@Override
@Bean
public AuthenticationManager authenticationManagerBean() throws Exception{
return super.authenticationManagerBean();
}


@Bean
public Docket api() {
return new Docket(DocumentationType.SWAGGER_2)
.apiInfo(apiInfo())
.securityContexts(Arrays.asList(securityContext()))
.securitySchemes(Arrays.asList(apiKey()))
.select()
.apis(RequestHandlerSelectors.any())
.paths(PathSelectors.any())
.build();
}


@Bean
public PasswordEncoder passwordEncoder() {
return NoOpPasswordEncoder.getInstance();
}
}