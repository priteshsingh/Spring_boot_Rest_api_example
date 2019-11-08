package com.example.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Product;
import com.example.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Product> save(@RequestBody Product product) {
		return ResponseEntity.ok(productService.save(product));
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Optional<Product> stock = productService.findById(id);
		return ResponseEntity.ok(stock.get());
	}

	@GetMapping(value = "findByName/{name}")
	public ResponseEntity<Product> findByName(@PathVariable String name) {
		Optional<Product> stock = productService.findByName(name);
		return ResponseEntity.ok(stock.get());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteProductById(@PathVariable Long id) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " - Delete employee by id is invoked.");
		productService.deleteById(id);
	}

	@RequestMapping(value = "/product/all", method = RequestMethod.GET)
	public List<Product> getProduct() {
		System.out.println(this.getClass().getSimpleName() + " - Get all employees service is invoked.");
		return productService.findAll();
	}

	@PutMapping(value = "/update/{id}")
	public Product updateProduct(@RequestBody Product pro, @PathVariable Long id) throws Exception {
		System.out.println(this.getClass().getSimpleName() + " - Update employee details by id is invoked.");
		Optional<Product> product = productService.findById(id);
		if (!product.isPresent())
			throw new Exception("Could not found ID " + id);
		if (pro.getName() == null || pro.getName().isEmpty())
			pro.setName(product.get().getName());
		if (pro.getDescription() == null || pro.getDescription().isEmpty())
			pro.setDescription(product.get().getDescription());
		pro.setId(id);
		return productService.updateProduct(pro);
	}
}
