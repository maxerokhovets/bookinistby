package com.nucldev.bookinistby.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nucldev.bookinistby.entities.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
	List<Photo> findByBookUuid(UUID uuid);

}
