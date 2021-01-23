package com.nucldev.bookinistby.controllers;

import java.util.Collection;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProfileController {
	
	@PostMapping("/profile")
	public String profille(Model model) {
		SecurityContextHolder securityContextHolder = new SecurityContextHolder();
		Collection authorities = securityContextHolder.getContext()
				.getAuthentication()
				.getAuthorities();
		if (authorities.toString().equals("[ROLE_ADMIN]")) {
			model.addAttribute("adminFlag", true);
		}
		return "profile";
	}
}
