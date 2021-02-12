package com.nucldev.bookinistby.controllers;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nucldev.bookinistby.entities.Book;
import com.nucldev.bookinistby.entities.Comment;
import com.nucldev.bookinistby.entities.Photo;
import com.nucldev.bookinistby.repositories.BookRepository;
import com.nucldev.bookinistby.repositories.CommentRepository;
import com.nucldev.bookinistby.repositories.PhotoRepository;

@Controller
public class BookController {
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	HttpServletRequest httpServletRequest;
	
	@Autowired
	PhotoRepository photoRepository;
	
	@Autowired
	CommentRepository commentRepository;
	
	@GetMapping("/book")
	public String book(@RequestParam(name = "bookId", required = false) Long bookId, Model model) {
		Book book = bookRepository.findBookById(bookId);
		model.addAttribute("book", book);
		List<Comment> comments = book.getComments();
		List<Comment> reversedComments = comments.stream()
				.sorted(new Comparator<Comment>() {
				public int compare(Comment comment1, Comment comment2) {
					return comment2.getDate().compareTo(comment1.getDate());
				}	
				})
				.collect(Collectors.toList());
		model.addAttribute("comments", reversedComments);
		List<Photo> photos = photoRepository.findByBookUuid(book.getUuid());
		model.addAttribute("photos", photos);
		if (httpServletRequest.getRemoteUser()!= null && httpServletRequest.getRemoteUser().equals(book.getUsername())) {
			model.addAttribute("thisUserBookFlag", true);
		}
		return "book";	
	}
	
	@PostMapping("/book/addcomment")
	public String addComment(@RequestParam(name = "bookId", required = false) Long bookId, Model model, String comment) {
		Book book = bookRepository.findBookById(bookId);
		Comment newComment = new Comment();
		newComment.setMessage(comment);
		newComment.setUsername(httpServletRequest.getRemoteUser());
		newComment.setDate(new Date());
		commentRepository.save(newComment);
		List<Comment> comments = book.getComments();
		comments.add(newComment);
		book.setComments(comments);
		bookRepository.save(book);
		List<Comment> reversedComments = comments.stream()
				.sorted(new Comparator<Comment>() {
				public int compare(Comment comment1, Comment comment2) {
					return comment2.getDate().compareTo(comment1.getDate());
				}	
				})
				.collect(Collectors.toList());
		model.addAttribute("comments", reversedComments);
		model.addAttribute("book", book);
		List<Photo> photos = photoRepository.findByBookUuid(book.getUuid());
		model.addAttribute("photos", photos);
		if (httpServletRequest.getRemoteUser()!= null && httpServletRequest.getRemoteUser().equals(book.getUsername())) {
			model.addAttribute("thisUserBookFlag", true);
		}
		
		return "book";
	}
	
}
