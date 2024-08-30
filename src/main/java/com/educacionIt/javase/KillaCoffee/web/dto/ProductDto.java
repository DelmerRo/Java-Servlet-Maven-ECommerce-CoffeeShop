package com.educacionIt.javase.KillaCoffee.web.dto;

import com.educacionIt.javase.KillaCoffee.model.entity.ProductStatus;

public record ProductDto(long id, String name, String description, Double price, Integer quantity, Integer minQuantity,
		ProductStatus status) implements Comparable<ProductDto>{

	@Override
	public int compareTo(ProductDto o) {
		return this.quantity - o.quantity;
	}

}
