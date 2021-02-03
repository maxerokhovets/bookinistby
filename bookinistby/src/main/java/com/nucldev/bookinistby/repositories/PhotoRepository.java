package com.nucldev.bookinistby.repositories;

import java.io.File;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nucldev.bookinistby.entities.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Long> {


}
