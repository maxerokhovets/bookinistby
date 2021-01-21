package com.nucldev.bookinistby.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.nucldev.bookinistby.entities.User;
import com.nucldev.bookinistby.repositories.UserRepository;

@Controller
public class RegistrationController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/registration")
	public String registration() {
		return "registration";
	}
	
	@PostMapping("/registration")
	public String addNewUser(String username, String email, 
			String password, String password2, Model model) {
		if (username.equals("") | email.equals("") |
				password.equals("") | password2.equals("")) {
			model.addAttribute("emptyFieldsError", true);
			return "registration";
		}else {
			User userFromDtb = userRepository.findByUsername(username);
			if (userFromDtb==null & email.matches(".+@.+") & 
					password.equals(password2)) {
				User user = new User();
				user.setUsername(username);
				user.setEmail(email);
				user.setPassword(new BCryptPasswordEncoder().encode(password));
				user.setRole("user");
				userRepository.save(user);
				return "redirect:/login";
			}else {
				if (userFromDtb!=null) {
					model.addAttribute("usernameError", true);
				}
				if (!password.equals(password2)) {
					model.addAttribute("notMatchingPasswordsError", true);
				}
				if (!email.matches(".+@.+")) {
					model.addAttribute("emailCheckingError", true);
				}
				return "registration";
			}
		}
		
		
		
		
	}
}
