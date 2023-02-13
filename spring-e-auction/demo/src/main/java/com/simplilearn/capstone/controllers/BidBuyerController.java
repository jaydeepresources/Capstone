package com.simplilearn.capstone.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.capstone.dao.BidBuyerRepository;
import com.simplilearn.capstone.model.BidBuyer;
import com.simplilearn.capstone.model.BidSeller;
import com.simplilearn.capstone.model.User;
import com.simplilearn.capstone.responseType.Status;

@RestController
@CrossOrigin(origins = "*")
public class BidBuyerController {

	@Autowired
	BidBuyerRepository bidBuyerRepository;

	@PostMapping("/bids/buy/add")
	public BidBuyer addBidBuy(@RequestBody BidBuyer bidBuyer) {
		return bidBuyerRepository.save(bidBuyer);
	}

	@GetMapping("/bids/buy/all")
	public List<BidBuyer> getBidBuy() {
		return (List<BidBuyer>) bidBuyerRepository.findAll();
	}

	@GetMapping("/bids/buy/all/{bidSellerId}")
	public List<BidBuyer> getBidBuyByBidSeller(@PathVariable int bidSellerId) {
		BidSeller bidSeller = new BidSeller();
		bidSeller.setBidSellerId(bidSellerId);
		return (List<BidBuyer>) bidBuyerRepository.findByBidSeller(bidSeller);
	}
	
	@GetMapping("/bids/buy/buyers/{buyerId}")
	public List<BidBuyer> getBidBuyByBuyer(@PathVariable int buyerId) {
		User buyer = new User();
		buyer.setUserId(buyerId);
		return (List<BidBuyer>) bidBuyerRepository.findByBuyer(buyer);
	}

	@PostMapping("/bids/buy/update/{bidBuyerId}")
	public Status updateBidStatus(@PathVariable int bidBuyerId) {
		Status status = null;
		try {
			bidBuyerRepository.updateBidStatus(bidBuyerId);
			status = new Status(true);
		} catch (Exception e) {
			e.printStackTrace();
			status = new Status(false);
		}
		return status;
	}
	
	@PostMapping("/bids/buy/update/payment/{bidBuyerId}")
	public Status updatePaymentStatus(@PathVariable int bidBuyerId) {
		Status status = null;
		try {
			bidBuyerRepository.updatePaymentStatus(bidBuyerId);
			status = new Status(true);
		} catch (Exception e) {
			e.printStackTrace();
			status = new Status(false);
		}
		return status;
	}

}
