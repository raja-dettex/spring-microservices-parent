package com.inventory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.models.Inventory;
import com.inventory.repository.InventoryRepository;

import jakarta.annotation.PostConstruct;

@Service
public class InventoryService {
	
	
	@Autowired
	private InventoryRepository inventoryRepository;
	
//	@PostConstruct
//	private void loadIntoDb() {
//		Inventory inventory = new Inventory();
//		inventory.setSkuCode("iphone_13");
//		inventory.setQuantity(4);
//		inventoryRepository.save(inventory);
//		Inventory inventory2 = new Inventory();
//		inventory.setSkuCode("iphone_13_red");
//		inventory.setQuantity(2);
//		inventoryRepository.save(inventory2);
//		
//	}

	@Transactional
	public boolean isInStock(String skuCode) {
		// TODO Auto-generated method stub
		boolean isInInventory = inventoryRepository.findBySkuCode(skuCode).isPresent();
		return isInInventory;
	}

}
