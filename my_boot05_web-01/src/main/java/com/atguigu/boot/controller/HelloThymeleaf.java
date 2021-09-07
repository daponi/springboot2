package com.atguigu.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloThymeleaf {

    @GetMapping("/helloThymeleaf")
    private String Hello(Model model){
        //model中的数据会被放在请求域中,相当于request.setAttribute("a",aa)
        model.addAttribute("msg","你好啊");
        model.addAttribute("link","www.baidu.com");
        return "success";
    }
}
