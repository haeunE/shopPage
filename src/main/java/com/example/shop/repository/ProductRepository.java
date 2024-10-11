package com.example.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shop.domain.Product;


public interface ProductRepository extends JpaRepository<Product, Integer>{
	
}
