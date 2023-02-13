package com.simplilearn.capstone.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "bid_buyer")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class BidBuyer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bidBuyerId;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date bidBuyerDate;

	private Float bidPrice;

	private String bidStatus;

	private String paymentStatus;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	private User buyer;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "bid_seller_id", nullable = false)
	private BidSeller bidSeller;

	public BidBuyer() {

	}

	public BidBuyer(Integer bidBuyerId, Date bidBuyerDate, Float bidPrice, String bidStatus, String paymentStatus,
			User buyer, BidSeller bidSeller) {
		this.bidBuyerId = bidBuyerId;
		this.bidBuyerDate = bidBuyerDate;
		this.bidPrice = bidPrice;
		this.bidStatus = bidStatus;
		this.paymentStatus = paymentStatus;
		this.buyer = buyer;
		this.bidSeller = bidSeller;
	}

	public Integer getBidBuyerId() {
		return bidBuyerId;
	}

	public void setBidBuyerId(Integer bidBuyerId) {
		this.bidBuyerId = bidBuyerId;
	}

	public Date getBidBuyerDate() {
		return bidBuyerDate;
	}

	public void setBidBuyerDate(Date bidBuyerDate) {
		this.bidBuyerDate = bidBuyerDate;
	}

	public Float getBidPrice() {
		return bidPrice;
	}

	public void setBidPrice(Float bidPrice) {
		this.bidPrice = bidPrice;
	}

	public String getBidStatus() {
		return bidStatus;
	}

	public void setBidStatus(String bidStatus) {
		this.bidStatus = bidStatus;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public User getBuyer() {
		return buyer;
	}

	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}

	public BidSeller getBidSeller() {
		return bidSeller;
	}

	public void setBidSeller(BidSeller bidSeller) {
		this.bidSeller = bidSeller;
	}

	@Override
	public String toString() {
		return "BidBuyer [bidBuyerId=" + bidBuyerId + ", bidBuyerDate=" + bidBuyerDate + ", bidPrice=" + bidPrice
				+ ", bidStatus=" + bidStatus + ", paymentStatus=" + paymentStatus + ", buyer=" + buyer + ", bidSeller="
				+ bidSeller + "]";
	}

}
