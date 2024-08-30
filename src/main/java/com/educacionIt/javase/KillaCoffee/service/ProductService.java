package com.educacionIt.javase.KillaCoffee.service;

import java.util.PriorityQueue;

import com.educacionIt.javase.KillaCoffee.web.dto.MessageResponse;
import com.educacionIt.javase.KillaCoffee.web.dto.ProductDto;
import com.educacionIt.javase.KillaCoffee.web.dto.ProductStockDto;

public interface ProductService {
MessageResponse addNewProduct(ProductDto productDto);

MessageResponse updateProduct(ProductDto productDto);

MessageResponse delete(Long id);

ProductDto findById(Long id);

PriorityQueue<ProductDto>findAllBySearch(String search);

PriorityQueue<ProductStockDto> findAllForStock();
}
