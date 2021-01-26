package com.nucldev.bookinistby.controllers;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.nucldev.bookinistby.entities.Book;
import com.nucldev.bookinistby.repositories.BookRepository;

@Controller
public class LoadingBookController {
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	HttpServletRequest httpServletRequest;
	
	@PostMapping("/profile/loadingbook")
	public String loadingBooks() {
		return "loadingbook";
	}
	
	@PostMapping("/profile/addbook")
	public String addBook(String title, String author, String description,
			String adType, Integer price, String endTimeOfAuction){
		Book book = new Book();
		book.setTitle(title);
		book.setAuthor(author);
		book.setDescription(description);
		book.setAdType(adType);
		book.setPrice(price);
		book.setEndTimeOfAuction(convertStringInDate(endTimeOfAuction));
		book.setUsername(httpServletRequest.getRemoteUser());
		bookRepository.save(book);
		return "mybooks";
	}
	
	private static Date convertStringInDate (String dateString) {
		//2020-09-18T01:40
		String[] strings1 = dateString.split("-");
		Calendar calendar = new GregorianCalendar();
		calendar.set(Calendar.YEAR, Integer.parseInt(strings1[0]));
		calendar.set(Calendar.MONTH, Integer.parseInt(strings1[1])-1);
		String[] strings2 = strings1[2].split("T");
		calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(strings2[0]));
		String[] strings3 = strings2[1].split(":");
		calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(strings3[0]));
		calendar.set(Calendar.MINUTE, Integer.parseInt(strings3[1]));
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();		
	}
	
}
