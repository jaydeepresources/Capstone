package com.simplilearn.capstone.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.simplilearn.capstone.model.Movie;
import com.simplilearn.capstone.model.Review;
import com.simplilearn.capstone.model.User;

public interface ReviewRepository extends CrudRepository<Review, Integer> {

	List<Review> findByMovie(Movie movie);

	List<Review> findByUser(User user);

}
