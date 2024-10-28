package com.example.shop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.shop.domain.User;
import java.util.List;
import java.util.Map;
import com.example.shop.roletype.Roletype;



@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	Optional<User> findByUserid(String userid);
	List<User> findByUser(Roletype user);
}
