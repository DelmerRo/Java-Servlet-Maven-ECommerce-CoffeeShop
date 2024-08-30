package com.educacionIt.javase.KillaCoffee.service.impl;

import java.util.List;
import java.util.PriorityQueue;

import com.educacionIt.javase.KillaCoffee.model.dao.ProductDao;
import com.educacionIt.javase.KillaCoffee.model.dao.impl.ProductDaoImpl;
import com.educacionIt.javase.KillaCoffee.model.entity.Product;
import com.educacionIt.javase.KillaCoffee.service.ProductService;
import com.educacionIt.javase.KillaCoffee.web.dto.MessageResponse;
import com.educacionIt.javase.KillaCoffee.web.dto.ProductDto;
import com.educacionIt.javase.KillaCoffee.web.dto.ProductStockDto;

public class ProductServiceImpl implements ProductService{

	private final ProductDao productDao;
	
	public ProductServiceImpl() {
		this.productDao = new ProductDaoImpl();
	}
	
	@Override
	public MessageResponse addNewProduct(ProductDto productDto) {
		if(!productDto.isValid()) {
			return new MessageResponse("Producto invalido", true);
		}
		boolean success = this.productDao.create(productDto.toEntity());
		return new MessageResponse(success?"Producto creado" : "Error al crear producto", !success);
	}

	@Override
	public MessageResponse updateProduct(ProductDto productDto) {
		if(!productDto.isValid()) {
			return new MessageResponse("Producto invalido", true);
		}
		boolean success = this.productDao.update(productDto.toEntity());
		return new MessageResponse(success?"Producto actualizado" : "Error al actualizar producto", !success);
	}

	@Override
	public MessageResponse delete(Long id) {
		Product product = productDao.findById(id);
		
		if(product == null) {
			return new MessageResponse("Producto no encontrado", true);
		}
		boolean success = productDao.delete(id);
		return null;
	}

	@Override
	public ProductDto findById(Long id) {
		Product product = productDao.findById(id);
		return product.toDto();
	}

	@Override
	public PriorityQueue<ProductDto> findAllBySearch(String search) {
		List<Product> productList;
		if(search.isBlank()) {
			productList = productDao.findAll();
		}else {
			productList = productDao.findAllBySearch(search);
		}
		
		PriorityQueue<ProductDto> productDtoList = new PriorityQueue<ProductDto>();
		for(Product product:  productList) {
			productDtoList.add(product.toDto());
		}
		return productDtoList;
	}

	@Override
	public PriorityQueue<ProductStockDto> findAllForStock() {
		List<Product> productList = productDao.findAll();
		
		PriorityQueue<ProductStockDto> productStockDtoList = new PriorityQueue<ProductStockDto>();
		for(Product product:  productList) {
			productStockDtoList.add(product.toStockDto());
		}
		return productStockDtoList;
	}

}
