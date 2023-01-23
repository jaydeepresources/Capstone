package com.simplilearn.capstone.dao;

import org.springframework.data.repository.CrudRepository;

import com.simplilearn.capstone.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	public User findByUserEmailAndUserPassword(String userEmail, String userPassword);

}