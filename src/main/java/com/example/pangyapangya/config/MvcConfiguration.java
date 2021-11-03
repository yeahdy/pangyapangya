package com.example.pangyapangya.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class MvcConfiguration implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 해당 폴더안에 안에 안에 있는 모든 파일을 찾기
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/").setCachePeriod(60*60*24*365);
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/").setCachePeriod(60*60*24*365);
        registry.addResourceHandler("/images/**").addResourceLocations("classpath:/static/images/").setCachePeriod(60*60*24*365);
        registry.addResourceHandler("/sass/**").addResourceLocations("classpath:/static/sass/").setCachePeriod(60 * 60 * 24 * 365);
        registry.addResourceHandler("/font/**").addResourceLocations("classpath:/static/font/").setCachePeriod(60*60*24*365);
        registry.addResourceHandler("/webfonts/**").addResourceLocations("classpath:/static/webfonts/").setCachePeriod(60 * 60 * 24 * 365);
    }
}