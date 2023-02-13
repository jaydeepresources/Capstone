package com.simplilearn.capstone.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "bid_seller")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class BidSeller {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bidSellerId;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date bidSellerDate;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "item_id")
	private Item item;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@OneToMany(mappedBy = "bidSeller", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	List<BidBuyer> bidBuyer;

	public BidSeller() {

	}

	public BidSeller(Integer bidSellerId, Date bidSellerDate, Item item, User user, List<BidBuyer> bidBuyer) {
		this.bidSellerId = bidSellerId;
		this.bidSellerDate = bidSellerDate;
		this.item = item;
		this.user = user;
		this.bidBuyer = bidBuyer;
	}

	public Integer getBidSellerId() {
		return bidSellerId;
	}

	public void setBidSellerId(Integer bidSellerId) {
		this.bidSellerId = bidSellerId;
	}

	public Date getBidSellerDate() {
		return bidSellerDate;
	}

	public void setBidSellerDate(Date bidSellerDate) {
		this.bidSellerDate = bidSellerDate;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<BidBuyer> getBidBuyer() {
		return bidBuyer;
	}

	public void setBidBuyer(List<BidBuyer> bidBuyer) {
		this.bidBuyer = bidBuyer;
	}

	@Override
	public String toString() {
		return "BidSeller [bidSellerId=" + bidSellerId + ", bidSellerDate=" + bidSellerDate + "]";
	}

}
