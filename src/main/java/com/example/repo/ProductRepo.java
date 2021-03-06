package com.example.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Product;

//Repository
@Repository
public interface ProductRepo extends JpaRepository<Product, Long>{

	Optional<Product> findByName(String name);

}
