package com.example.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.shop.domain.Product;
import com.example.shop.repository.ProductRepository;

@Controller
public class MainController {
	
	@Autowired
	private ProductRepository pr;
	
	
	@GetMapping("/")
	public String index(Model model) {
		List<Product> products =  pr.findAll();
		model.addAttribute("products", products);
		return "index";
	}
	
	@GetMapping("/error-page")
	public String error() {
		return "errorpage";
	}
	
}
