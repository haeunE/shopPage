package com.example.shop.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AdminController {
	
	@GetMapping("/admin/product")
	public String index() {
		return "/admin/addproduct";
	}
}
