package com.atguigu.www.controller;

import com.atguigu.www.bean.User;
import com.atguigu.www.exception.UserTooManyException;
import com.atguigu.www.service.UserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {

    @Autowired
    UserService userService;

    @GetMapping("/basic_table")
    public String basic_table(){
        //验证GlobalExceptionHandler的ArithmeticException
        int a=10/0;
        return "table/basic_table";
    }

    /**
     * 验证自定义异常，
     * 验证Mybatis-plus的crud功能
     * @param pn
     * @param model
     * @return
     */
    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model){
        //测试@ResponseStatus自定义异常
/*        List<User> user = Arrays.asList(new User("zhangsan","123456"),
                                new User("lisi", "123444"),
                                new User("haha", "aaaaa"),
                                new User("hehe ", "aaddd"));
        model.addAttribute("user","user");
        //验证@ResponseStatus自定义异常
        if (user.size()>3) throw new UserTooManyException();*/

        //验证mybatis-plus的CRUD功能,从数据库中查出user表中的用户进行展示

        //构造分页参数
        Page<User> page = new Page<>(pn,2);
        //调用page进行分页
        Page<User> userPage = userService.page(page, null);
        //若删除后当前页没有数据则返回前一页
        if (!userPage.hasNext() && userPage.hasPrevious()) userPage.setCurrent(pn-1);
        model.addAttribute("users",userPage);
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

    /**
     * dynamic_table增加删除功能
     * @param RedirectAttributes ra 可以给重定向的请求中添加属性
     */
    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id,
                             @RequestParam(value = "pn",defaultValue = "1") Integer pn,
                             RedirectAttributes ra){
        userService.removeById(id);
        ra.addAttribute("pn",pn);
        return "redirect:/dynamic_table";
    }
}
