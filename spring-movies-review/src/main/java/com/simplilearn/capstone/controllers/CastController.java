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

import com.simplilearn.capstone.dao.CastRepository;
import com.simplilearn.capstone.model.Cast;
import com.simplilearn.capstone.responseType.Status;

@RestController
@CrossOrigin(origins = "*")
public class CastController {

	@Autowired
	CastRepository castRepository;

	@PostMapping("/cast/add")
	public Cast addCast(@RequestBody Cast cast) {
		cast.getMovie().setCast(cast);
		return castRepository.save(cast);
	}

	@GetMapping("/cast/all")
	public List<Cast> getUsers() {
		return (List<Cast>) castRepository.findAll();
	}

	@GetMapping("/cast/find/{id}")
	public Cast getUser(@PathVariable int id) {
		return castRepository.findById(id).get();
	}

	@DeleteMapping("/cast/delete/{castId}")
	public Status deleteCast(@PathVariable int castId) {
		Status status = new Status();
		try {
			castRepository.deleteById(castId);
			status.setSuccess(true);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			status.setSuccess(false);
		}

		return status;
	}

}