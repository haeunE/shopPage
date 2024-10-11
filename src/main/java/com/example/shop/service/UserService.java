package com.example.shop.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shop.domain.User;
import com.example.shop.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User getUser(String userid) {
		User findUser = userRepository.findByUserid(userid).orElseGet(()->{
			return new User();
		});
		return findUser;
	}
	
	public void insertUser(User user) {
		userRepository.save(user);
	}
	
	public User modifyUser(User oldInfo, User newInfo) {
		oldInfo.setPassword(newInfo.getPassword());
		oldInfo.setEmail(newInfo.getEmail());
		System.out.println(oldInfo);
		return oldInfo;
	}
	
	public Map<String, String> userSession(User user){
		Map<String, String> userSession = new HashMap<>();
		userSession.put("id",Integer.toString(user.getId()));
		userSession.put("userid",user.getUserid());
		return userSession;
	}

}
