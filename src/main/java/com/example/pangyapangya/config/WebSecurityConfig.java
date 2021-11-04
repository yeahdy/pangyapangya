package com.example.pangyapangya.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    // PasswordEncoder? 비밀번호를 암호화하는 역할로 PasswordEncoder의 구현체를 대입해주어 스프링 빈으로 등록하는 과정이 필요
    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder(); // BCrypt 라는 해시 함수를 이용하여 패스워드를 암호화한다.
    }

    // configure()? 의존성을 주입할 경우 브라우저에서 "로그인 프롬프트"가 출력되기 때문에, 이러한 설정들을 disable 해줘야한다.
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().disable()
                .csrf().disable()
                .formLogin().disable()
                .headers().frameOptions().disable()
                .and()
//로그 아웃
                .logout()
                    .logoutUrl("/user/logout")
                    .logoutSuccessUrl("/main/mainPage");
    }
}
