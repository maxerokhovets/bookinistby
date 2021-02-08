package com.nucldev.bookinistby.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.nucldev.bookinistby.entities.Book;
import com.nucldev.bookinistby.entities.Photo;
import com.nucldev.bookinistby.repositories.BookRepository;
import com.nucldev.bookinistby.repositories.PhotoRepository;

@Controller
public class BookController {
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	HttpServletRequest httpServletRequest;
	
	@Autowired
	PhotoRepository photoRepository;
	
	@GetMapping("/book")
	public String book(@RequestParam(name = "bookId", required = false) Long bookId, Model model) {
		Book book = bookRepository.findBookById(bookId);
		model.addAttribute("book", book);
		List<Photo> photos = photoRepository.findByBookUuid(book.getUuid());
		model.addAttribute("photos", photos);
		if (httpServletRequest.getRemoteUser()!= null && httpServletRequest.getRemoteUser().equals(book.getUsername())) {
			model.addAttribute("thisUserBookFlag", true);
		}
		return "book";
		
	}
	
}
