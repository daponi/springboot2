package com.atguigu.www;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class MyBoot05AdminServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyBoot05AdminServerApplication.class, args);
    }

}
