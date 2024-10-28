package com.example.shop.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.shop.domain.User;
import com.example.shop.repository.UserRepository;
import com.example.shop.roletype.Roletype;



@Controller
public class AdminController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/admin/product")
	public String product() {
		return "/admin/product";
	}
	
	@GetMapping("/admin/member")
//	@ResponseBody
	public String member(Model model) {
		System.out.println(userRepository.findByUser(Roletype.MEMBER));
		List<User> members = userRepository.findByUser(Roletype.MEMBER);
		model.addAttribute("members",members);
		return "/admin/member";
	}
	
	
}
