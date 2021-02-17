package com.nucldev.bookinistby.entities;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	private String adTypeRus;
	private Date creationDate;
	private Integer price;
	private Date endTimeOfAuction;
	private UUID uuid;
	private String status;
	private String coverUrl;
	
	@OneToMany
	private List<Comment> comments;
	
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAdTypeRus() {
		return adTypeRus;
	}

	public void setAdTypeRus(String adTypeRus) {
		this.adTypeRus = adTypeRus;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getCoverUrl() {
		return coverUrl;
	}

	public void setCoverUrl(String coverUrl) {
		this.coverUrl = coverUrl;
	}
	

}
