package com.simplilearn.capstone.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.simplilearn.capstone.model.BidBuyer;
import com.simplilearn.capstone.model.BidSeller;
import com.simplilearn.capstone.model.User;

public interface BidBuyerRepository extends CrudRepository<BidBuyer, Integer> {

	List<BidBuyer> findByBuyer(User buyer);
	List<BidBuyer> findByBidSeller(BidSeller bidSeller);
	
	@Transactional
	@Modifying
	@Query("update bid_buyer b set b.bidStatus='approved' where b.bidBuyerId=:id")
	void updateBidStatus(@Param("id") int id);
	
	@Transactional
	@Modifying
	@Query("update bid_buyer b set b.paymentStatus='complete' where b.buyer.userId=:id")
	void updatePaymentStatus(@Param("id") int id);

}
