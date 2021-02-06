package com.nucldev.bookinistby.controllers;

import java.util.Collection;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProfileController {
	
	@GetMapping("/profile")
	public String profille(Model model) {
		return "profile";
	}
}
