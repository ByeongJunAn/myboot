package com.keduit.bpro01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class sampleController {
	
	@GetMapping("/회원가입")
	public String[] hello() {
		return new String[] {"Hello", "World!"};
		아이디 : 홍길동 진실
		비번 1234 진실 
		리턴 로그인 완료화면 		
		}
	}
	

