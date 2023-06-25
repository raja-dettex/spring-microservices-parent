package com.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.product.dtos.ProductRequest;
import com.product.dtos.ProductResponse;

@RestController
@RequestMapping("api/products")
public class ProductController {

	@Autowired
	private ProductService service;
	
	
	@GetMapping
	public List<ProductResponse> getAll() {
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	public ProductResponse getById(@PathVariable("id") String id) {
		return service.get(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProductResponse create(@RequestBody ProductRequest req) {
		return service.add(req);
	}
}
