package com.orders.models;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="table_orders")
public class Order {

	@Id
	@GeneratedValue
	private int oderId;
	
	private UUID orderNumber;
	
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<OrderItem> orderItems;


	public Order() {
		super();
	}


	public Order(int oderId, UUID orderNumber, List<OrderItem> orderItems) {
		super();
		this.oderId = oderId;
		this.orderNumber = orderNumber;
		this.orderItems = orderItems;
	}


	public int getOderId() {
		return oderId;
	}


	public void setOderId(int oderId) {
		this.oderId = oderId;
	}


	public UUID getOrderNumber() {
		return orderNumber;
	}


	public void setOrderNumber(UUID orderNumber) {
		this.orderNumber = orderNumber;
	}


	public List<OrderItem> getOrderItems() {
		return orderItems;
	}


	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	
}
