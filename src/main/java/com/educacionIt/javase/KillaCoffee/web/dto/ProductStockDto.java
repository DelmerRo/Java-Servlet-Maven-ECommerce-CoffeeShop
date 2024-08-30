package com.educacionIt.javase.KillaCoffee.web.dto;

public record ProductStockDto(Long id, String name, Integer quantity, Integer minQuantity) implements Comparable<ProductStockDto> {

	@Override
	public int compareTo(ProductStockDto o) {
		return this.quantity - o.quantity;
	}

	

}
