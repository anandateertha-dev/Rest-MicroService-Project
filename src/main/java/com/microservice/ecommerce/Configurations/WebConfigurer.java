package com.microservice.ecommerce.Configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.microservice.ecommerce.Interceptors.CartInterceptor;
import com.microservice.ecommerce.Interceptors.UserInterceptor;

@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(final InterceptorRegistry registry) {
        registry.addInterceptor(new UserInterceptor()).addPathPatterns("/users/**");
        registry.addInterceptor(new CartInterceptor()).addPathPatterns("/cart/**");
    }
}
