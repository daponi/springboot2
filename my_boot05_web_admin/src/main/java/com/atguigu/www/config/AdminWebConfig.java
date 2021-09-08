package com.atguigu.www.config;

import com.atguigu.www.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AdminWebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")//拦截所有的请求，包括静态资源
                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**", "/js/**","/aa/**");//设置放行的请求
    }
}
