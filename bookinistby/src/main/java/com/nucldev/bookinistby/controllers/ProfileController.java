package com.nucldev.bookinistby.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {
	
	@GetMapping("/profile")
	public String profille(Model model) {
		return "profile";
	}
}
