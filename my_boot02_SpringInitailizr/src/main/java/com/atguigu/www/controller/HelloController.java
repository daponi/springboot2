package com.atguigu.www.controller;

import com.atguigu.www.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    Person person;

    @RequestMapping("/person")
    public Person person(){
        String[] interests = this.person.getInterests();
        for (String str :interests) {
            System.out.println(str);
        }

        System.out.println(interests);
        System.out.println(person.getUserName());
        return this.person;
    }
}
