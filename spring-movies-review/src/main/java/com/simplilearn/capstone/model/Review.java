package com.simplilearn.capstone.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "reviews")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer reviewId;
	private Integer reviewRating;
	private String reviewDescription;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	
	private User user;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "movie_id", nullable = false)

	private Movie movie;

	public Review() {
		// TODO Auto-generated constructor stub
	}

	public Review(Integer reviewId, Integer reviewRating, String reviewDescription, User user, Movie movie) {
		super();
		this.reviewId = reviewId;
		this.reviewRating = reviewRating;
		this.reviewDescription = reviewDescription;
		this.user = user;
		this.movie = movie;
	}

	public Integer getReviewId() {
		return reviewId;
	}

	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
	}

	public Integer getReviewRating() {
		return reviewRating;
	}

	public void setReviewRating(Integer reviewRating) {
		this.reviewRating = reviewRating;
	}

	public String getReviewDescription() {
		return reviewDescription;
	}

	public void setReviewDescription(String reviewDescription) {
		this.reviewDescription = reviewDescription;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", reviewRating=" + reviewRating + ", reviewDescription="
				+ reviewDescription + "]";
	}

}
