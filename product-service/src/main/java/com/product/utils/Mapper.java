package com.product.utils;

import com.product.dtos.ProductRequest;
import com.product.dtos.ProductResponse;
import com.product.models.Product;

public class Mapper {

	public static Product productRequestToProduct(ProductRequest req) {	
		Product product = new Product();
		product.setName(req.getName());
		product.setDescription(req.getDescription());
		product.setPrice(req.getPrice());
		return product;
	}
	
	public static ProductResponse prodToProdResponse(Product prod) {
		return new ProductResponse(prod.getId(), prod.getName(), prod.getDescription(), prod.getPrice());
	}
}
