package com.orders.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orders.dtos.OrderItemRequst;
import com.orders.dtos.OrderRequestDto;
import com.orders.models.Order;
import com.orders.models.OrderItem;
import com.orders.repository.OrderRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepo;
	
	public UUID placeOrder(OrderRequestDto orderRequestDto) {
		Order order = new Order();
		order.setOrderNumber(UUID.randomUUID());
		List<OrderItem> orderItems = orderRequestDto.getOrderItems().stream().map(this::mapToOrder).toList();
		order.setOrderItems(orderItems);
		Order createdOrder = orderRepo.save(order);
		return createdOrder.getOrderNumber();
		
	}

	private OrderItem mapToOrder(OrderItemRequst orderreq) {
		// TODO Auto-generated method stub
		OrderItem orderItem = new OrderItem();
		orderItem.setName(orderreq.getName());
		orderItem.setPrice(orderreq.getPrice());
		orderItem.setQuantity(orderreq.getQty());
		return orderItem;
	}
}
