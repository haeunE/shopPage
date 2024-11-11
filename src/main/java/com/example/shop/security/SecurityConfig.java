package com.example.shop.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // 인가 (접근권한) 설정
        http.authorizeHttpRequests()
            .antMatchers("/").permitAll()
            .antMatchers("/admin/**").hasRole("ADMIN");

        // 예외 처리 및 접근 거부 페이지
        http.exceptionHandling().accessDeniedPage("/error-page");

        // 로그인 및 로그아웃 설정
        http.formLogin()
        .loginPage("/auth/login")
            .permitAll();

        http.logout()
            .logoutUrl("auth/logout")
            .logoutSuccessUrl("/")
            .permitAll();

        return http.build();
    }
}
