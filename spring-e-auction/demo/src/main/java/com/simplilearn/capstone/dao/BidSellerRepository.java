package com.simplilearn.capstone.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.simplilearn.capstone.model.BidSeller;
import com.simplilearn.capstone.model.Item;
import com.simplilearn.capstone.model.User;

public interface BidSellerRepository extends CrudRepository<BidSeller, Integer> {

	List<BidSeller> findByUser(User user);

	BidSeller findByItem(Item item);
}
