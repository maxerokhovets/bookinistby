package com.nucldev.bookinistby.controllers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
		List<Book> reversedBooks = new ArrayList<>();
		if (books.size()!=0) {
			reversedBooks = books.stream()
					.sorted(new Comparator<Book>() {
						public int compare(Book b1, Book b2) {
							return b2.getCreationDate().compareTo(b1.getCreationDate());
						}
					}).collect(Collectors.toList());
		}
		
		if (books.size()!=0) {
			model.addAttribute("books", reversedBooks);
		}else {
			model.addAttribute("emtyList", true);
		}		
		return "homepage";		
	}
}
