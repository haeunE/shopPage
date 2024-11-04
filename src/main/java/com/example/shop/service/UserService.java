package com.example.shop.service;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shop.domain.User;
import com.example.shop.repository.UserRepository;
import com.example.shop.roletype.Roletype;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	private static final int SALT_SIZE=16;
	
	// 동일 아이디 존재 확인
	public User getUserid(String userid) {
		User findUser = userRepository.findByUserid(userid).orElseGet(()->{
			return new User();
		});
		return findUser;
	}
	
	// 계정 만들기
	public void insertUser(User user, byte[] password) throws Exception{
		String SALT = getSALT();
		user.setPassword(Hashing(password, SALT));
		user.setSALT(SALT);
		user.setUser(Roletype.MEMBER);
		userRepository.save(user);
	}
	// 아이디 비번 체크
	public boolean cheaking(String userid, String hashing_pass) {
		User user = userRepository.findByUserid(userid).get();
		String getPass = user.getPassword();
		if (getPass.equals(hashing_pass)) {
			return true;
		}
		return false;
	}
	
	public boolean get_User(String userid,String salt, byte[] password) throws Exception{
		String pass = Hashing(password, salt);
		if (cheaking(userid, pass)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	// 계정 수정하기
	public User modifyUser(User oldInfo, User newInfo) throws Exception{
		String SALT = getSALT();
		oldInfo.setPassword(Hashing(newInfo.getPassword().getBytes(),SALT));
		oldInfo.setSALT(SALT);
		oldInfo.setEmail(newInfo.getEmail());
		System.out.println(oldInfo);
		return oldInfo;
	}
	
	// 필요한 유저 정보 세션에 저장하기
	public Map<String, String> userSession(User user){
		Map<String, String> userSession = new HashMap<>();
		userSession.put("id",Integer.toString(user.getId()));
		userSession.put("userid",user.getUserid());
		return userSession;
	}
	
	// 비밀번호 해싱
	private String Hashing(byte[] password, String Salt)throws Exception{
		
		MessageDigest md = MessageDigest.getInstance("SHA-256");// SHA-256 해시 함수 사용
		
		for(int i =0; i<10000 ; i++) {
			String temp = Byte_to_String(password) +Salt; // 비밀번호와 솥트 합쳐 새로운 문자열 생성
			md.update(temp.getBytes()); //문자열 해싱
			password = md.digest(); //문자열 객체의 다이제스트를 얻어 비밀번호 얻기
		}
		return Byte_to_String(password);
	}
	
	// SALT 값 생성
	private String getSALT() throws Exception {
		SecureRandom rnd = new SecureRandom();
		byte [] temp = new byte[SALT_SIZE];
		rnd.nextBytes(temp);
		return Byte_to_String(temp);
	}
	
	// byte 값 16진수로 변경하는 함수
	private String Byte_to_String(byte[] temp) {
		StringBuilder sb = new StringBuilder();
		for (byte a: temp) {
			sb.append(String.format("%02x", a));
		}
		return sb.toString();
	}
//	public String get_SALT(Integer id) {
//		int hash = userRepository.findById(id).hashCode();
//	}

}
