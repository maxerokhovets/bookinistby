package com.nucldev.bookinistby.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nucldev.bookinistby.entities.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Long> {


}
