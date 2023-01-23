package com.simplilearn.capstone.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.capstone.dao.MovieRepository;
import com.simplilearn.capstone.model.Movie;
import com.simplilearn.capstone.responseType.Status;

@RestController
@CrossOrigin(origins = "*")
public class MovieController {

	@Autowired
	MovieRepository movieRepository;

	@PostMapping("/movies/add")
	public Movie addMovie(@RequestBody Movie movie) {
		return movieRepository.save(movie);
	}

	@GetMapping("/movies/all")
	public List<Movie> getMovies() {
		return (List<Movie>) movieRepository.findAll();
	}

	@GetMapping("/movies/find/{movieId}")
	public Movie getMovie(@PathVariable int movieId) {
		Optional<Movie> o = movieRepository.findById(movieId);
		return (o.isPresent()) ? o.get() : null;
	}

	@DeleteMapping("/movies/delete/{movieId}")
	public Status deleteMovie(@PathVariable int movieId) {
		Status status = new Status();
		try {
			movieRepository.deleteById(movieId);
			status.setSuccess(true);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			status.setSuccess(false);
		}

		return status;
	}

}
