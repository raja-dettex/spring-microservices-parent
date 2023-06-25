package com.product;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.dtos.ProductRequest;
import com.product.dtos.ProductResponse;
import com.product.models.Product;
import com.product.repository.ProductRepository;
import com.product.utils.Mapper;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<ProductResponse> getAll() {
		return productRepository.findAll().stream().map(Mapper::prodToProdResponse).collect(Collectors.toList());
	}
	
	public ProductResponse add(ProductRequest req) {
		return Mapper.prodToProdResponse(productRepository.save(Mapper.productRequestToProduct(req)));
	}
	
	public ProductResponse get(String id) {
		Product prod = productRepository.findById(id).orElse(null);
		ProductResponse response = Mapper.prodToProdResponse(prod);
		return (prod != null)?response:null;
	}
}
