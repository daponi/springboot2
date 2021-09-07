package com.atguigu.boot.controller;

import com.atguigu.boot.bean.Person;
import com.atguigu.boot.bean.Pet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class ResponseTestController {
    @ResponseBody//利用返回值处理器里面的消息转换器进行处理
    @GetMapping("test/person")
    public Person getPerson(){
        Person person = new Person();
        person.setAge(28);
        person.setBirth(new Date());
        person.setUserName("zhangsan");
        person.setPet(new Pet("小猫",2));
        return person;
    }
}
