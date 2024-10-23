package com.example.shop.domain;



import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.example.shop.roletype.Roletype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 50, nullable = false, unique = true)
	private String userid;
	
	@Column(length = 100, nullable = false)
	private String password;
	
	private String email;
	
	@CreationTimestamp
	private Timestamp createDate;
	
	@Enumerated(EnumType.STRING)
	private Roletype user;
	
//	private String username;
//	
//	private String usernum;
//	
//	private String address;
}
