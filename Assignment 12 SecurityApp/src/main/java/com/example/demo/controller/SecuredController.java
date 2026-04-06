package com.example.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecuredController {
	
	@GetMapping("/publicEndPoint")
	public String forPublic() {
		return "This is a public endpoint, accessible to everyone.";
	}
	
	@GetMapping("/securedUserEndPoint")
	@PreAuthorize("hasAnyRole('USER','ADMIN')")
	public String forSecuredUser() {
		return "This is a secured endpoint, accessible only to authenticated users.";
	}
	
	@GetMapping("/securedAdminEndPoint")
	@PreAuthorize("hasRole('ADMIN')")
	public String forSecuredAdmin() {
		return "This is a secured endpoint, accessible only to authenticated users with ADMIN role.";
	}
	
}
