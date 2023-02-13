package com.simplilearn.capstone.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.capstone.dao.BidSellerRepository;
import com.simplilearn.capstone.model.BidSeller;
import com.simplilearn.capstone.model.Item;
import com.simplilearn.capstone.model.User;

@RestController
@CrossOrigin(origins = "*")
public class BidSellerController {

	@Autowired
	BidSellerRepository bidSellerRepository;

	@PostMapping("/bids/sell/add")
	public BidSeller addBidSell(@RequestBody BidSeller bidSeller) {
		return bidSellerRepository.save(bidSeller);
	}

	@GetMapping("/bids/sell/all")
	public List<BidSeller> getBidSell() {
		return (List<BidSeller>) bidSellerRepository.findAll();
	}
	
	@GetMapping("/bids/sell/items/{itemId}")
	public BidSeller getBidSellByItem(@PathVariable int itemId) {
		Item item = new Item();
		item.setItemId(itemId);
		return bidSellerRepository.findByItem(item);
	}
	
	@GetMapping("/bids/sell/users/{userId}")
	public List<BidSeller> getBidSellByUser(@PathVariable int userId) {
		User user = new User();
		user.setUserId(userId);
		return (List<BidSeller>)bidSellerRepository.findByUser(user);
	}
	
}
