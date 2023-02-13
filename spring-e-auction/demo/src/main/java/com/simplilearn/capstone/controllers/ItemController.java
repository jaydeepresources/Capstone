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

import com.simplilearn.capstone.dao.ItemRepository;
import com.simplilearn.capstone.model.Item;
import com.simplilearn.capstone.responseType.Status;

@RestController
@CrossOrigin(origins = "*")
public class ItemController {
	
	@Autowired
	ItemRepository itemRepository;
	
	@PostMapping("/items/add")
	public Item addItem(@RequestBody Item item) {
		return itemRepository.save(item);
	}

	@GetMapping("/items/all")
	public List<Item> getCategories() {
		return (List<Item>) itemRepository.findAll();
	}

	@GetMapping("/items/all/{itemId}")
	public Item getItem(@PathVariable int itemId) {
		return itemRepository.findById(itemId).get();
	}

	@DeleteMapping("/items/delete/{itemId}")
	public Status deleteItem(@PathVariable int itemId) {
		Status status = new Status();
		try {
			itemRepository.deleteById(itemId);
			status.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			status.setSuccess(false);
		}
		return status;
	}
}
