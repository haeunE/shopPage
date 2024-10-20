package com.example.shop.domain;

import com.example.shop.domain.ResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO<T> {
	// 응답결과 상태 코드
	private int status;
	//응답데이터
	private T data;
}

