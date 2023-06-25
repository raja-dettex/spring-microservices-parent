package com.product.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.product.ProductService;
import com.product.models.Product;
import com.product.repository.ProductRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

	@MockBean
	private ProductRepository repo;
	
	@InjectMocks
	private ProductService service;
	
	@Test
	public void TestGetAllMethod() {
		List<Product> products = Stream.of(new Product("7548357", "Test product", "Test desc", 8869)).toList();
		when(repo.findAll()).thenReturn(products);
		assertEquals(1, service.getAll().size());
	}
	
	@Test
	public void TestGetByIdMethod() {
		Product product = new Product("7548357", "Test product", "Test desc", 8869);
		Optional<Product> optionalProd = Optional.of(product);
		when(repo.findById(product.getId())).thenReturn(optionalProd);
		assertEquals(product.getName(), service.get(product.getId()).getName());
	}
}
