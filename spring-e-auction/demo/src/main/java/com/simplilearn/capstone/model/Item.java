package com.simplilearn.capstone.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "items")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer itemId;

	private String itemName;
	private Float itemMinPrice;
	private String itemDescription;
	private String itemImg;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;

	@OneToOne(mappedBy = "item")
	@JsonIgnore
	private BidSeller bidSeller;

	public Item() {

	}

	public Item(Integer itemId, String itemName, Float itemMinPrice, String itemDescription, String itemImg,
			Category category, BidSeller bidSeller) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemMinPrice = itemMinPrice;
		this.itemDescription = itemDescription;
		this.itemImg = itemImg;
		this.category = category;
		this.bidSeller = bidSeller;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Float getItemMinPrice() {
		return itemMinPrice;
	}

	public void setItemMinPrice(Float itemMinPrice) {
		this.itemMinPrice = itemMinPrice;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public String getItemImg() {
		return itemImg;
	}

	public void setItemImg(String itemImg) {
		this.itemImg = itemImg;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public BidSeller getBidSeller() {
		return bidSeller;
	}

	public void setBidSeller(BidSeller bidSeller) {
		this.bidSeller = bidSeller;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", itemMinPrice=" + itemMinPrice
				+ ", itemDescription=" + itemDescription + ", itemImg=" + itemImg + "]";
	}

}
