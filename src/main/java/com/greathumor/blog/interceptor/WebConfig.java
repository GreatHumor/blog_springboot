package com.greathumor.blog.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin")
                .excludePathPatterns("/admin/login");
//        registry.addInterceptor(new LoginInterceptor())
//                .addPathPatterns("/static/**")
//                .excludePathPatterns("/css/*.css")
//                .excludePathPatterns("/images/*.jpg")
//                .excludePathPatterns("/js/*.js");
    }
}
