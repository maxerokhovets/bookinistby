package com.nucldev.bookinistby.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.nucldev.bookinistby.entities.Book;
import com.nucldev.bookinistby.repositories.BookRepository;
import com.nucldev.bookinistby.service.Search;

@Controller
public class SearchingController {
	
	@Autowired
	BookRepository bookRepository;
	
	@PostMapping("/searching")
	public String search(String searchQuery, Model model) {
		List<Book> allBooks = bookRepository.findAll();
		Search search = new Search(searchQuery, allBooks);
		model.addAttribute("books", search.search());
		if (search.search().size()==0) {
			model.addAttribute("emptyBooksList", true);
		}
		return "homepage";
	}
}
