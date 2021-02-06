package com.nucldev.bookinistby.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nucldev.bookinistby.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	List<Book> findByUsername(String username);
}
