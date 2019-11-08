package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.Product;

public interface ProductService {
	public List<Product> findAll();
	public Optional<Product> findById(Long id);
	public Product save(Product stock);
	public void deleteById(Long id);
	public Product updateProduct(Product emp);
	public Optional<Product> findByName(String name);
	
}
