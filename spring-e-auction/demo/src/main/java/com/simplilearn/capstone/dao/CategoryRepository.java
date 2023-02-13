package com.simplilearn.capstone.dao;

import org.springframework.data.repository.CrudRepository;

import com.simplilearn.capstone.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

}