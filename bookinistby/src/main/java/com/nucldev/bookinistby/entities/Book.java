package com.nucldev.bookinistby.entities;

import java.awt.Image;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;

@Entity
@Table(name = "books")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "text")
	private String title;
	
	@Column(columnDefinition = "text")
	private String author;
	
	@Column(columnDefinition = "text")
	private String description;
	
	@Column(columnDefinition = "text")
	private String username;
	
	@Column(columnDefinition = "text")
	private String maxBetUsername;
	
	private String adType;
	private Integer price;
	private Date endTimeOfAuction;
	private UUID uuid;
	
	public Book() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAdType() {
		return adType;
	}

	public void setAdType(String adType) {
		this.adType = adType;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Date getEndTimeOfAuction() {
		return endTimeOfAuction;
	}

	public void setEndTimeOfAuction(Date endTimeOfAuction) {
		this.endTimeOfAuction = endTimeOfAuction;
	}

	public String getMaxBetUsername() {
		return maxBetUsername;
	}

	public void setMaxBetUsername(String maxBetUsername) {
		this.maxBetUsername = maxBetUsername;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	
}
