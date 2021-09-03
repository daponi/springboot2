package com.atguigu.boot.controller;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.web.bind.annotation.*;
import sun.management.Agent;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParameterTestController {
/*
* @PathVariable、@RequestHeader、@CookieValue、@RequestBody解释
* */
    @RequestMapping(value = "car/{id}/owner/{user}",method = RequestMethod.GET )
    public Map<String,Object> getCar(@PathVariable("id") String id,
                                     @PathVariable("user") String user,
                                     @PathVariable Map<String,String>  pathMap,
                                     @RequestHeader("Accept-Language") String language,
                                     @RequestHeader Map<String,String> headerMap,
                                     @CookieValue("SESSION") String session,
                                     @CookieValue("SESSION") Cookie cookie){
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id",id);
        hashMap.put("user",user);
        hashMap.put("pathMap",pathMap);

        hashMap.put("language",language);
        hashMap.put("headerMap",headerMap);

        hashMap.put("session",session);
        hashMap.put("cookieName",cookie.getName());
        hashMap.put("cookieValue",cookie.getValue());
        System.out.println(cookie.getName()+"--"+cookie.getValue());//SESSION--30af67ec-7e8f-48d0-b983-23f8bdbb7f56
        return hashMap;
    }
/*@requestBody 解析*/
    @PostMapping("/save")
    public Map<String ,Object> postMethod(@RequestBody String content){
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("content",content);
        return stringObjectHashMap;
    }

/*@MatrixVariable/矩阵变量解析*/
    //1、语法： 请求路径：/cars/sell;low=34;brand=byd,audi,yd
    //2、SpringBoot默认是禁用了矩阵变量的功能
    //      手动开启：原理。对于路径的处理。UrlPathHelper进行解析。
    //              removeSemicolonContent（移除分号内容）支持矩阵变量的
    //3、矩阵变量必须有url路径变量才能被解析
    @GetMapping("/cars/{path}")
    public Map<String,Object> carsSell(@MatrixVariable("low") Integer low,
                                       @MatrixVariable("brand") List<String> brand,
                                       @PathVariable("path")  String path){
        Map<String,Object> map = new HashMap<>();

        map.put("low",low);
        map.put("brand",brand);
        map.put("path",path);
        return map;
    }

    // /boss/1;age=20/2;age=10
    @GetMapping("/corporation/{bossId}/{empId}")
    private Map<String,Object> bossAndEmployee(@MatrixVariable(value = "age",pathVar = "bossId") Integer bossAge,
                                               @MatrixVariable(value = "age",pathVar = "empId") Integer empAge,
                                               @MatrixVariable(value = "name",pathVar = "empId") String name,
                                               @PathVariable(value = "bossId") String boss,
                                                @PathVariable(value = "empId") String emp){
        Map<String, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("bossAge",bossAge);
        objectObjectHashMap.put("empAge",empAge);
        objectObjectHashMap.put("name",name);
        objectObjectHashMap.put("a",boss);
        objectObjectHashMap.put("b",emp);
        return objectObjectHashMap;
    }



}
