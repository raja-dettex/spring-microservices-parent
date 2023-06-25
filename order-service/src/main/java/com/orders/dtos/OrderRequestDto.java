package com.orders.dtos;

import java.util.List;

public class OrderRequestDto {

	private List<OrderItemRequst> orderItems;

	public OrderRequestDto() {
		super();
	}

	public OrderRequestDto(List<OrderItemRequst> orderItems) {
		super();
		this.orderItems = orderItems;
	}

	public List<OrderItemRequst> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItemRequst> orderItems) {
		this.orderItems = orderItems;
	}
	
}
