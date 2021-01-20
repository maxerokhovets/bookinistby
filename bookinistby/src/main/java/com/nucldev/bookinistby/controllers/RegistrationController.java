package com.nucldev.bookinistby.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistrationController {
	
	@GetMapping("/registration")
	public String registration() {
		return "registration";
	}
	
	public String addNewUser(String username, String email, 
			String password, String password2) {
		if (1==1) {
			
		}else {
			
		}
		
		return "redirect:/login";
	}
	
	private static boolean emailChecking(String email) {
		return true;
	}
}
