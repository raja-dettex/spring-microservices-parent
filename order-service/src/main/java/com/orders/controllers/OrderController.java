package com.orders.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orders.dtos.OrderRequestDto;
import com.orders.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping
	public String createOrder(@RequestBody OrderRequestDto orderRequestDto) {
		UUID orderNumber = orderService.placeOrder(orderRequestDto);
		return "order placed with order number: " + orderNumber + " ";
	}
}
