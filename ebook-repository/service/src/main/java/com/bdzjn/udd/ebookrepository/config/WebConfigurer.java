package com.bdzjn.udd.ebookrepository.config;

import com.bdzjn.udd.ebookrepository.config.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/api/users/login",
                        "/api/categories",
                        "/api/categories/**/books",
                        "/api/books/search");
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        return new RequestInterceptor();
    }
}
