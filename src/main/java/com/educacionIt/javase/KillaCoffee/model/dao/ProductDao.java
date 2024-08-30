package com.educacionIt.javase.KillaCoffee.model.dao;

import java.util.List;

import com.educacionIt.javase.KillaCoffee.model.entity.Product;

public interface ProductDao {

	boolean create(Product product);

	boolean update(Product product);
	
	boolean delete(Long id);
	
	Product findById(Long id);
	
	List<Product> findAll();
	
	List<Product> findAllBySearch(String search);
	
}
