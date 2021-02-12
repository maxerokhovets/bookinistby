package com.nucldev.bookinistby.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nucldev.bookinistby.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{

}
