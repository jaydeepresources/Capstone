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

import com.simplilearn.capstone.dao.CategoryRepository;
import com.simplilearn.capstone.model.Category;
import com.simplilearn.capstone.responseType.Status;

@RestController
@CrossOrigin(origins = "*")
public class CategoryController {

	@Autowired
	CategoryRepository categoryRepository;

	@PostMapping("/categories/add")
	public Category addCategory(@RequestBody Category category) {
		return categoryRepository.save(category);
	}

	@GetMapping("/categories/all")
	public List<Category> getCategories() {
		return (List<Category>) categoryRepository.findAll();
	}

	@GetMapping("/categories/all/{categoryId}")
	public Category getCategory(@PathVariable int categoryId) {
		return categoryRepository.findById(categoryId).get();
	}

	@DeleteMapping("/categories/delete/{categoryId}")
	public Status deleteCategory(@PathVariable int categoryId) {
		Status status = new Status();
		try {
			categoryRepository.deleteById(categoryId);
			status.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			status.setSuccess(false);
		}
		return status;
	}

}