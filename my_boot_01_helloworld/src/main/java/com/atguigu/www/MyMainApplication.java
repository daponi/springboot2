package com.atguigu.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurationExcludeFilter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan("com.atguigu.www")
//@SpringBootApplication
public class MyMainApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MyMainApplication.class, args);
        final int beanDefinitionCount = run.getBeanDefinitionCount();
        System.out.println("beanDefinitionCount:"+beanDefinitionCount);
    }
}
