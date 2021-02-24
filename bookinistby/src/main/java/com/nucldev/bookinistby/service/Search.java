package com.nucldev.bookinistby.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.nucldev.bookinistby.entities.Book;

public class Search {
	private String searchQuery;
	private List<Book> allBooks;
	
	

	public Search(String searchQuery, List<Book> allBooks) {
		this.searchQuery = searchQuery;
		this.allBooks = allBooks;
	}

	public String getSearchQuery() {
		return searchQuery;
	}

	public List<Book> getAllBooks() {
		return allBooks;
	}
	
	public Set<Book> search(){
		Set<Book> searchResult = new HashSet<>();
		for (Book book : this.allBooks) {
			if (book.getTitle().toLowerCase().equals(this.searchQuery.toLowerCase()) | book.getAuthor().toLowerCase().equals(this.searchQuery.toLowerCase())) {
				searchResult.add(book);
			}
		}
		for (Book book : this.allBooks) {
			if (book.getTitle().toLowerCase().matches(this.searchQuery+".+".toLowerCase()) | book.getAuthor().toLowerCase().matches(this.searchQuery+".+".toLowerCase())) {
				searchResult.add(book);
			}
		}
		for (Book book : this.allBooks) {
			if (book.getTitle().toLowerCase().matches(".+"+this.searchQuery.toLowerCase()) | book.getAuthor().toLowerCase().matches(".+"+this.searchQuery.toLowerCase())) {
				searchResult.add(book);
			}
		}
		for (Book book : this.allBooks) {
			if (book.getTitle().toLowerCase().matches(".+"+this.searchQuery+".+".toLowerCase()) | book.getAuthor().toLowerCase().matches(".+"+this.searchQuery+".+".toLowerCase())) {
				searchResult.add(book);
			}
		}
		return searchResult;
	}
	
}
