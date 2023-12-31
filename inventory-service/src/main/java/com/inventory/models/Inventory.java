package com.inventory.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="table_inventory")
public class Inventory {

	@Id
	@GeneratedValue
	private Long id;
	private String skuCode;
	private int quantity;
	public Inventory() {
		super();
	}
	public Inventory(Long id, String skuCode, int quantity) {
		super();
		this.id = id;
		this.skuCode = skuCode;
		this.quantity = quantity;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSkuCode() {
		return skuCode;
	}
	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
