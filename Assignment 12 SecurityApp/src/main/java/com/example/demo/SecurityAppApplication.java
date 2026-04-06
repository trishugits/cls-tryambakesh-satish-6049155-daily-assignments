package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.demo.service.MyuserDetailService;

@SpringBootApplication
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityAppApplication {

	@Autowired
	MyuserDetailService service;
	public static void main(String[] args) {
		SpringApplication.run(SecurityAppApplication.class, args);
	}
	
	@Bean
	public DaoAuthenticationProvider getAuthenticationProvider() {
		DaoAuthenticationProvider dao=new DaoAuthenticationProvider(service);
		dao.setPasswordEncoder(passwordEncoder());
		return dao;
	}
	
	@Bean
	public SecurityFilterChain webSecurityFilter(HttpSecurity http) {
		return http
				.csrf(csrf->csrf.disable())
				.authorizeHttpRequests(authReq->authReq.requestMatchers(HttpMethod.GET,"/publicEndPoint").permitAll()
				.anyRequest().authenticated())
				.authenticationProvider(getAuthenticationProvider())
				.httpBasic(Customizer.withDefaults())
				.build();
	}
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
}
