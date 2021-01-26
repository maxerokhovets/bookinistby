package com.nucldev.bookinistby.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nucldev.bookinistby.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	
}
