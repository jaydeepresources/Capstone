package com.simplilearn.capstone.dao;

import org.springframework.data.repository.CrudRepository;

import com.simplilearn.capstone.model.Item;

public interface ItemRepository extends CrudRepository<Item, Integer> {

}
