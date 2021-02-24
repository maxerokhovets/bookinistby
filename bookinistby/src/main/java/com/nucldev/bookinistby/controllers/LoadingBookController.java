package com.nucldev.bookinistby.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nucldev.bookinistby.entities.Book;
import com.nucldev.bookinistby.repositories.BookRepository;
import com.nucldev.bookinistby.service.AmazonClient;
import com.nucldev.bookinistby.service.FilesFromForm;

@Controller
public class LoadingBookController {
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	HttpServletRequest httpServletRequest;
	
	@Autowired
	AmazonClient amazonClient;
	
	@GetMapping("/loadingbook")
	public String loadingBooks(Model model) {
		FilesFromForm filesFromForm = new FilesFromForm();
		model.addAttribute("filesFromForm", filesFromForm);
		return "loadingbook";
	}
	
	@PostMapping("/addbook")
	public String addBook(String title, String author, String description,
			String adType, Integer price, String endTimeOfAuction,
			@ModelAttribute(value = "filesFromForm") FilesFromForm filesFromForm,
			Model model){
		if (title.equals("") | author.equals("")) {
			model.addAttribute("titleOrAuthorEmptyError", true);
		return "loadingbook";
		}else {
			if (adType.equals("auction") & endTimeOfAuction.equals("")) {
				model.addAttribute("endTimeOfAuctionError", true);
				return "loadingbook";
			}else {
				Book book = new Book();
				book.setTitle(title);
				book.setAuthor(author);
				book.setDescription(description);
				book.setCreationDate(new Date());
				book.setAdType(adType);
				switch (adType) {
				case "free":
					book.setAdTypeRus("бесплатно");
					break;
				case "fixprize":
					book.setAdTypeRus("фиксированная цена");
					break;
				case "auction":
					book.setAdTypeRus("аукцион");
					break;	
				}
				book.setStatus("открыто");
				UUID uuid = UUID.randomUUID();
				book.setUuid(uuid);
				if (!adType.equals("free")) {
					book.setPrice(price);	
				}
				if (adType.equals("auction")) {
					book.setEndTimeOfAuction(convertStringInDate(endTimeOfAuction));
				}
				book.setUsername(httpServletRequest.getRemoteUser());
				String string = "";
				try {
					string = Files.probeContentType(Paths.get(amazonClient.convertMultiPartToFile(filesFromForm.getFiles().get(0)).getAbsolutePath()));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (string!=null) {
					String[] strings = string.split("/");
					if (strings[0].equals("image")) {
						try {
							book.setCoverUrl(amazonClient.uploadFile(filesFromForm.getFiles().get(0)));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				bookRepository.save(book);
				
				List<Book> myBooks = bookRepository.findByUsername(httpServletRequest.getRemoteUser());
				if (myBooks.size()!=0) {
					model.addAttribute("mybooks", myBooks);
				}else {
					model.addAttribute("emtyMyBooksList", true);
				}
				return "redirect:/mybooks";
			}
		}
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
