package com.educacionIt.javase.KillaCoffee.web.dto;

import com.educacionIt.javase.KillaCoffee.model.entity.Product;
import com.educacionIt.javase.KillaCoffee.model.entity.ProductStatus;

public record ProductDto(long id, String name, String description, Double price, Integer quantity, Integer minQuantity) implements Comparable<ProductDto>{

	@Override
	public int compareTo(ProductDto o) {
		return this.quantity - o.quantity;
	}
	
	public boolean isValid() {
		return name != null && description != null && price!= null && quantity != null && minQuantity != null;
	}

	public Product toEntity() {
	return new Product(id, name, description, price, quantity, minQuantity);	
	}
}
