package com.keduit.bpro54.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.extern.log4j.Log4j2;

@Configuration
@Log4j2
public class securityConfig {

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http.authorizeHttpRequests((auth) ->{
			auth.antMatchers("/sample/all").permitAll();
			auth.antMatchers("/sample/member").hasRole("USER");
		});
		http.formLogin();	//인가, 인증에 문제가 발생할 때 로그인 화면을 띄움
		
		http.csrf().disable();
		http.logout();
		return http.build();
	}

	
	
}
