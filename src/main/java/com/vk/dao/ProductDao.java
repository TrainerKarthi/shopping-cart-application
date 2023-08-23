package com.vk.dao;

import java.util.List;

import com.vk.dto.Product;

public interface ProductDao {
	public Product saveProduct(Product p);
	
	public Product findProductById(int id);
	
	public List<Product> findAllProducts();
	
	public boolean updateProductById(int id, Product p);
	
}
