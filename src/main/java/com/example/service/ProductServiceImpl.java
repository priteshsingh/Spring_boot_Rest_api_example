package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Product;
import com.example.repo.ProductRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

	@Autowired
	private final ProductRepo productRespository;

	public List<Product> findAll() {
		return productRespository.findAll();
	}

	public Optional<Product> findById(Long id) {
		return productRespository.findById(id);
	}

	public Product save(Product stock) {

		return productRespository.save(stock);
	}

	public void deleteById(Long id) {
		productRespository.deleteById(id);
	}

	public Product updateProduct(Product emp) {
		return productRespository.save(emp);
	}

	@Override
	public Optional<Product> findByName(String name) {

		return productRespository.findByName(name);

	}

}
