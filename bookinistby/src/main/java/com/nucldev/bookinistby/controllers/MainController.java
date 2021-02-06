package com.nucldev.bookinistby.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nucldev.bookinistby.entities.Book;
import com.nucldev.bookinistby.repositories.BookRepository;

@Controller
public class MainController {
	
	@Autowired
	BookRepository bookRepository;
	
	@RequestMapping
	public String main (Model model) {
		List<Book> books = bookRepository.findAll();
		if (books.size()!=0) {
			model.addAttribute("books", books);
		}else {
			model.addAttribute("emtyList", true);
		}
		return "homepage";		
	}
}
