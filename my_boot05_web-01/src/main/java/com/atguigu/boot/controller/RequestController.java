package com.atguigu.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public Map<String,Object> success(@RequestAttribute(value = "myMsg",required = false) String myMsg,
                                      @RequestAttribute(value = "code",required = false)Integer code,

                                      HttpServletRequest request,
                                      HttpServletResponse response){
        Object msg = request.getAttribute("myMsg");
        Object myCode = request.getAttribute("myCode");
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("myMsg",myMsg);
        hashMap.put("msg",msg);
        hashMap.put("myCode",myCode);
//        hashMap.put("request",request); 不能把request放进Map里，会报错
        System.out.println(request);

        Object aaa = request.getAttribute("AAA");
        Object bbb = request.getAttribute("BBB");
        Object ccc = request.getAttribute("CCC");
        Object ddd = request.getAttribute("DDD");
        hashMap.put("aaa",aaa);
        hashMap.put("bbb",bbb);
        hashMap.put("ccc",ccc);
        hashMap.put("ddd",ddd);

        return hashMap;
    }

    @GetMapping("params")
    private String testParam(Map<String,Object> map,
                             Model model,
                             HttpServletRequest request,
                             HttpServletResponse response){
        map.put("AAA","aaa");
        map.put("BBB","bbb");
        model.addAttribute("CCC","ccc");
        request.setAttribute("DDD","ddd");

        Cookie cookie = new Cookie("EEE", "eee");
        response.addCookie(cookie);
        return "forward:/success";
    }
}
