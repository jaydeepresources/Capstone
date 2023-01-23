package com.simplilearn.capstone.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.simplilearn.capstone.model.Movie;

public interface MovieRepository extends CrudRepository<Movie, Integer> {
	
//	@Query("update Movie m set m.cast.castId=:castId where movieId=:movieId")
//	public void setMovieById(Integer movieId,Integer castId);

	
	
}
