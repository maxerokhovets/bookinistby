package com.nucldev.bookinistby.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nucldev.bookinistby.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
