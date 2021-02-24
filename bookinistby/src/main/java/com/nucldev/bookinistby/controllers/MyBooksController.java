package com.nucldev.bookinistby.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.nucldev.bookinistby.entities.Book;
import com.nucldev.bookinistby.repositories.BookRepository;

@Controller
public class MyBooksController {
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	HttpServletRequest httpServletRequest;
	
	@GetMapping("/mybooks")
	public String book(Model model) {
		List<Book> myBooks = bookRepository.findByUsername(httpServletRequest.getRemoteUser());
		if (myBooks.size()!=0) {
			model.addAttribute("mybooks", myBooks);
		}else {
			model.addAttribute("emptyMyBooksList", true);
		}
		return "mybooks";
	}
}
