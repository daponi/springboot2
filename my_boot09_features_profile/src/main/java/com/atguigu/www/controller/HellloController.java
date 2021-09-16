package com.atguigu.www.controller;

import com.atguigu.www.bean.Boss;
import com.atguigu.www.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HellloController {

    @Value("${worker.name:李四}")
    private String name;

    @Value("${worker.work:写代码}")
    private String work;

    @Autowired
    private Person person;//自动装配person的组件，Bean写了它两个实现类只有一个生效时才正常启动

    @Value("${JAVA_HOME}")
    private String msg;

    @ResponseBody
    @RequestMapping("/hello")
    public String HelloTest(){
        return "Hello,"+name+", work="+work;
    }

    @ResponseBody
    @RequestMapping("/person")
    public String Person(){
        return person.getClass().toString();
    }

    @ResponseBody
    @RequestMapping("/hello/person")
    public String HelloPerson(){
        return person.toString();
    }

    @GetMapping("/msg")
    @ResponseBody
    public String getMsg(){
        return msg+"==>";
    }
}
