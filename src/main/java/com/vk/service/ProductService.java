package com.vk.service;

import java.util.List;

import com.vk.dto.Product;

public interface ProductService {
	public Product saveProduct(Product p);

	public Product findProductById(int id);

	public List<Product> findAllProducts();

	public boolean updateProductById(int id, Product p);
}
