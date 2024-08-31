package com.educacionIt.javase.KillaCoffee.model.entity;

import com.educacionIt.javase.KillaCoffee.web.dto.ProductDto;
import com.educacionIt.javase.KillaCoffee.web.dto.ProductStockDto;

public class Product {
	private long id;
	private String name;
	private String description;
	private Double price;
	private Integer quantity;
	private Integer minQuantity;
	private ProductStatus status;

	public Product() {
	
	}

	public Product(long id, String name, String description, Double price, Integer quantity, Integer minQuantity) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.minQuantity = minQuantity;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Double getPrice() {
		return price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public Integer getMinQuantity() {
		return minQuantity;
	}

	public ProductStatus getStatus() {
		return status;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public void setMinQuantity(Integer minQuantity) {
		this.minQuantity = minQuantity;
	}

	public void setStatus(ProductStatus status) {
		this.status = status;
	}
	
	public ProductDto toDto() {
		return new ProductDto(id, name, description, price, quantity, minQuantity);
	}
	
	public ProductStockDto toStockDto() {
		return new ProductStockDto(id, name, quantity, minQuantity);
	}
}
