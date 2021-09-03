package com.atguigu.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RequestController {
/*
* @RequestAttribute解析
* */
//    @RequestMapping(value = "goto",method = RequestMethod.GET)
    @GetMapping("goto")
    public String goToPage(HttpServletRequest request){
        request.setAttribute("myMsg","这是我的信息。。。");
        request.setAttribute("myCode","This is my Code。。。");
        return "forward:/success";
    }

    @ResponseBody
    @GetMapping("success")
    public Map<String,Object> success(@RequestAttribute("myMsg") String myMsg,
                                      HttpServletRequest request){
        Object msg = request.getAttribute("myMsg");
        Object code = request.getAttribute("myCode");
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("myMsg",myMsg);
        hashMap.put("msg",msg);
        hashMap.put("myCode",code);
//        hashMap.put("request",request); 不能把request放进Map里，会报错
        System.out.println(request);
        return hashMap;
    }
}
