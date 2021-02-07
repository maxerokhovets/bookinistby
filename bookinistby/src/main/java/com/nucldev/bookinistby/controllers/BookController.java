package com.nucldev.bookinistby.controllers;

import java.util.List;

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
	PhotoRepository photoRepository;
	
	@GetMapping("/book")
	public String book(@RequestParam(name = "bookId", required = false) Long bookId, Model model) {
		Book book = bookRepository.findBookById(bookId);
		model.addAttribute("book", book);
		List<Photo> photos = photoRepository.findByBookUuid(book.getUuid());
		if (photos.size()!=0) {
			String photoUrlString = photos.get(0).getPhotoUrl();
			model.addAttribute("url", photoUrlString);
		}
		return "book";
		
	}
	
}
