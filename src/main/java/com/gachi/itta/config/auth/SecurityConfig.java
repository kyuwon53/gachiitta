package com.gachi.itta.config.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * 보안에 관한 설정을 합니다.
 */
@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests()    // URL 권한 관리 설정 옵션 시작
                .anyRequest().authenticated()   // 설정된 값들 이외 나머지 URL은 인증된 사용자들에게만 허용
                .and()
                .logout()
                .logoutSuccessUrl("/")  // 로그아웃 성공 시 이동
                .and()
                .oauth2Login()
                .userInfoEndpoint()
                .userService(customOAuth2UserService);// 로그인 성공 이후 사용자 정보 설정
        return http.build();

    }
}
