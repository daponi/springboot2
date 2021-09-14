package com.atguigu.www;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;

//@ServletComponentScan(basePackages = "com.atguigu.www")//扫描自定义的servlet
@MapperScan("com.atguigu.www.mapper")
@SpringBootApplication(exclude = RedisAutoConfiguration.class)
public class MyBoot05WebAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyBoot05WebAdminApplication.class, args);
    }

}
