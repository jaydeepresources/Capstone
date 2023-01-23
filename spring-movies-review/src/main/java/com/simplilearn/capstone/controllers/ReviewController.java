package com.simplilearn.capstone.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.capstone.dao.ReviewRepository;
import com.simplilearn.capstone.model.Movie;
import com.simplilearn.capstone.model.Review;
import com.simplilearn.capstone.model.User;
import com.simplilearn.capstone.responseType.Status;

@RestController
@CrossOrigin(origins = "*")
public class ReviewController {

	@Autowired
	ReviewRepository reviewRepository;

	@PostMapping("/reviews/add")
	public Review addReview(@RequestBody Review review) {
		return reviewRepository.save(review);
	}

	@GetMapping("/reviews/all")
	public List<Review> getReviews() {
		return (List<Review>) reviewRepository.findAll();
	}
	
	@GetMapping("/reviews/movies/{movieId}")
	public List<Review> getReviewsForMovie(@PathVariable int movieId){
		Movie movie = new Movie();
		movie.setMovieId(movieId);
		return reviewRepository.findByMovie(movie);
	}
	
	@GetMapping("/reviews/users/{userId}")
	public List<Review> getReviewsForUser(@PathVariable int userId){
		User user = new User();
		user.setUserId(userId);
		return reviewRepository.findByUser(user);
	}
	
	@DeleteMapping("/reviews/delete/{reviewId}")
	public Status deleteReview(@PathVariable int reviewId) {
		Status status = new Status();
		try {
			reviewRepository.deleteById(reviewId);
			status.setSuccess(true);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			status.setSuccess(false);
		}
		
		return status;
	}
}
