package com.example.pangyapangya.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

// Spring security를 사용하기 위해 필요한 내용들을 Configration 해 줘야 한다.
@Configuration
@EnableWebSecurity  // Spring security 사용을 정의하는 어노테이션
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
                                    // WebSecurityConfigurerAdapter를 상속받아 configure() 메소드를 재정의 해야한다.

    // PasswordEncoder? 비밀번호를 암호화하는 역할로 PasswordEncoder의 구현체를 대입해주어 스프링 빈으로 등록하는 과정이 필요
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
        // BCryptPasswordEncoder(): PasswordEncoder의 종류로 BCrypt 라는 해시 함수를 이용하여 패스워드를 암호화한다.
        // 입력값이 같아도 항상 다른 암호화된 값을 반환 해 준다.

    }

    // configure()? 의존성을 주입할 경우 브라우저에서 "로그인 프롬프트"가 출력되기 때문에,
    // 로그인이 상관없도록 이러한 설정들을 disable 해줘야한다.
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().disable()
                .csrf().disable()
                .formLogin().disable()
                .headers().frameOptions().disable()
                .and()
                .logout()   //로그 아웃
                    .logoutUrl("/user/logout")
                    .logoutSuccessUrl("/main/mainPage");    // 로그아웃 성공시
    }
}
