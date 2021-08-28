package com.atguigu.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@ResponseBody
//@Controller
@RestController
@RequestMapping("/controller")
public class HelloWorld {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello World.";
    }
}
