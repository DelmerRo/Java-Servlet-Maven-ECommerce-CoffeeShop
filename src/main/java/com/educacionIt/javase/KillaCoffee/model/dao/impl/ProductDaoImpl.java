package com.educacionIt.javase.KillaCoffee.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.educacionIt.javase.KillaCoffee.model.dao.ProductDao;
import com.educacionIt.javase.KillaCoffee.model.entity.Product;
import com.educacionIt.javase.KillaCoffee.model.entity.ProductStatus;
import com.educacionIt.javase.KillaCoffee.model.jdbc.DBConnection;

public class ProductDaoImpl implements ProductDao{

	private static final String CREATE_PS = "INSERT INTO products (name, description, price, quantity, min_quantity, status) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_PS = "UPDATE products SET name = ?, description = ?, price = ?, quantity = ?, min_quantity = ? WHERE id = ?";
	  private static final String DELETE_PS = "UPDATE products SET status = ? WHERE id = ?";
	  private static final String FIND_ALL_PS = "SELECT * FROM products WHERE status = ?";
	  private static final String FIND_ALL_SEARCH_PS = "SELECT * FROM products WHERE status = ? AND name LIKE ?";
	  private static final String FIND_ID_PS = "SELECT * FROM products WHERE id = ?";
	
	@Override
	public boolean create(Product product) {
		try(Connection connection = DBConnection.getInstance()){
			PreparedStatement ps = connection.prepareStatement(CREATE_PS);
			ps.setString(1, product.getName());
			ps.setString(2, product.getDescription());
			ps.setDouble(3, product.getPrice());
			ps.setInt(4, product.getQuantity());
			ps.setInt(5, product.getMinQuantity());
			ps.setString(6, ProductStatus.ACTIVE.name());
			
			return ps.executeUpdate() == 1;
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean update(Product product) {
		try(Connection connection = DBConnection.getInstance()){
			PreparedStatement ps = connection.prepareStatement(UPDATE_PS);
			ps.setString(1, product.getName());
			ps.setString(2, product.getDescription());
			ps.setDouble(3, product.getPrice());
			ps.setInt(4, product.getQuantity());
			ps.setInt(5, product.getMinQuantity());
			ps.setLong(6, product.getId());
			
			return ps.executeUpdate() == 1;
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean delete(Long id) {
		try(Connection connection = DBConnection.getInstance()){
			PreparedStatement ps = connection.prepareStatement(DELETE_PS);
			ps.setString(1, ProductStatus.INACTIVE.name());
			ps.setLong(2, id);
			
			return ps.executeUpdate() == 1;
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public Product findById(Long id) {
		try(Connection connection = DBConnection.getInstance()){
			PreparedStatement ps = connection.prepareStatement(FIND_ID_PS);
			ps.setLong(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return this.getProduct(rs);
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}


	@Override
	public List<Product> findAll() {
		try(Connection connection = DBConnection.getInstance()){
			List<Product>productList = new ArrayList<Product>();
			PreparedStatement ps = connection.prepareStatement(FIND_ALL_PS);
			
			ps.setString(1, ProductStatus.ACTIVE.name());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				productList.add(this.getProduct(rs));
				return productList;
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<Product> findAllBySearch(String search) {
		List<Product>productList = new ArrayList<Product>();
		try(Connection connection = DBConnection.getInstance()){
			PreparedStatement ps = connection.prepareStatement(FIND_ALL_SEARCH_PS);
			
			ps.setString(1, ProductStatus.ACTIVE.name());
			ps.setString(2, "%"+ search + "%");
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				productList.add(this.getProduct(rs));
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return productList;
	}

	private Product getProduct(ResultSet rs) throws SQLException{
		Product product = new Product();
		product.setId(rs.getLong("id"));
		product.setName(rs.getString("name"));
		product.setDescription(rs.getString("description"));
		product.setPrice(rs.getDouble("price"));
		product.setQuantity(rs.getInt("quantity"));
		product.setMinQuantity(rs.getInt("min_quantity"));
		product.setStatus(ProductStatus.valueOf(rs.getString("status")));
		return product;
	}

	
}

