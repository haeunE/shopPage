package com.example.shop.controller;

import java.lang.foreign.Linker.Option;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.example.shop.domain.Product;
import com.example.shop.repository.ProductRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class ProductController {
	@Autowired
	private ProductRepository pr;
	
	@GetMapping("/auth/new-products")
	public String newProducts(Model model) {
		List<Product> products =  pr.findAll();
		model.addAttribute("products", products);
		return "product/product";
	}
	
	
	
}
