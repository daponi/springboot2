package com.atguigu.www.controller;

import com.atguigu.www.bean.User;
import com.atguigu.www.exception.UserTooManyException;
import com.sun.org.apache.bcel.internal.generic.IFEQ;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {

    @GetMapping("/basic_table")
    public String basic_table(){
        //验证GlobalExceptionHandler的ArithmeticException
        int a=10/0;
        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model){
        List<User> user = Arrays.asList(new User("zhangsan","123456"),
                                new User("lisi", "123444"),
                                new User("haha", "aaaaa"),
                                new User("hehe ", "aaddd"));
        model.addAttribute("user","user");
        //验证@ResponseStatus自定义异常
        if (user.size()>3) throw new UserTooManyException();

        return "table/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table(){
        return "table/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(){
        return "table/editable_table";
    }
}
