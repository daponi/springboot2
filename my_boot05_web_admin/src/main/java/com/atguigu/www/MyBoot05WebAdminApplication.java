package com.atguigu.www;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@ServletComponentScan(basePackages = "com.atguigu.www")//扫描自定义的servlet
@SpringBootApplication
public class MyBoot05WebAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyBoot05WebAdminApplication.class, args);
    }

}
