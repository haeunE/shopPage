package com.example.shop.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.shop.domain.ResponseDTO;
import com.example.shop.domain.User;
import com.example.shop.repository.UserRepository;
import com.example.shop.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/auth/signup")
	public String signup() {
		return "user/signup";
	}
	
	@PostMapping("/auth/signup")
	@ResponseBody
	public ResponseDTO<?> signUp (@RequestBody User user){
		//중복검사
		User findUser = userService.getUser(user.getUserid());
		if (findUser.getUserid() == null) {
			userService.insertUser(user);
			return new ResponseDTO<>(HttpStatus.OK.value(),user.getUserid()+"님 가입 완료");
		}else {
			return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(),user.getUserid()+"은 중복된 아이디 입니다.");
		}
		//
	}
	
	@GetMapping("/auth/login")
	public String login() {
		return "user/login";
	}
	
	@PostMapping("/auth/login")
	@ResponseBody
	public ResponseDTO<?> login(@RequestBody User user, HttpSession session) {
		User findUser = userService.getUser(user.getUserid());
		if(findUser.getUserid() == null) {
			return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(),"해당 아이디가 없습니다.");
		}else {
			if(findUser.getPassword().equals(user.getPassword())) {
				Map<String,String> userSession = userService.userSession(findUser);
				session.setAttribute("principal", userSession);
				return new ResponseDTO<>(HttpStatus.OK.value(),user.getUserid()+"님 로그인 완료");
			}else {
				return new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(),"비밀번호를 다시 입력해 주십시오");
			}
		}
	}
	
	@GetMapping("auth/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/auth/userinfo")
	public String userInfo(HttpSession session, Model model) {
		Map<String, String> user = (Map<String, String>) session.getAttribute("principal");
		int id = Integer.parseInt(user.get("id"));
		User userInfo = userRepository.findById(id).get();
		model.addAttribute("userInfo",userInfo);
		
		return "user/userinfo";
	}
	
	@PostMapping("/auth/userinfo")
	@ResponseBody
	public ResponseDTO<?> modifyUser(@RequestBody User user, HttpSession session) {
		//회원정보변경
		User findUser = userService.getUser(user.getUserid());
		User newInfo = userService.modifyUser(findUser, user);
		userRepository.save(newInfo);
		//세션변경
		Map<String,String> userSession = userService.userSession(newInfo);
		session.setAttribute("principal", userSession);
		
		return new ResponseDTO<>(HttpStatus.OK.value(),"회원 정보 수정 완료");
	}
	
	@DeleteMapping("/auth/delete")
	@ResponseBody
	public ResponseDTO<?> delete(@RequestParam int id, HttpSession session){
		userRepository.deleteById(id);
		session.invalidate();
		return new ResponseDTO<>(HttpStatus.OK.value(), "탈퇴완료");
	}
	
	
}
