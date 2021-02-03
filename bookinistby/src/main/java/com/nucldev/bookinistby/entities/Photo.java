package com.nucldev.bookinistby.entities;

import java.io.File;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "photos")
public class Photo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Lob
	private File photo;
	private UUID bookUuid;
	
	public Photo() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public UUID getBookUuid() {
		return bookUuid;
	}

	public void setBookUuid(UUID bookUuid) {
		this.bookUuid = bookUuid;
	}
	
}
