package com.atguigu.www.controller;

import com.atguigu.www.bean.Account;
import com.atguigu.www.bean.User;
import com.atguigu.www.service.AccountService;
import com.atguigu.www.service.impl.AccountServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
@Slf4j
@Controller
public class IndexController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AccountService accountServiceImpl;
    /**
     * 进入登录页面
     *
     * @return
     */
    @GetMapping(value = {"/", "login"})
    public String loginPage() {
        return "login";
    }

    /**
     * @param user
     * @param session
     * @param model
     * @return
     */
    @PostMapping("login")
    public String main(User user, HttpSession session, Model model) { //RedirectAttributes
        log.info("开始执行login页面{}："+session);

        if (StringUtils.hasLength(user.getUserName()) && "123".equals(user.getPassword())) {
            //将登录的用户保存起来
            session.setAttribute("loginUser", user);
            //登录成功就重定向到main.html，重定向是为了防止表单重复提交造成重复的Post请求
            return "redirect:/main.html";
        } else {
            model.addAttribute("msg", "账号密码错误");
            //登录失败继续回到登录页面
            return "login";
        }
    }

    /**
     * 当登录成功后若刷新页面会造成表单重复提交，即重复进行post请求
     * 所以将它设置成重定向就不是重复Post请求而是只刷新该页面
     *
     * @return
     */
    @GetMapping("main.html")
    public String mainPage(HttpSession session,Model model) {
        log.info("当前方法是：{}","mainPage");

        //防止在其他浏览器输入登录的页面，所以需要进行是否登录的判断，如用拦截器，过滤器
/*        Object loginUser = session.getAttribute("loginUser");
        if (loginUser != null) {
            return "main";
        }else{
            //回到登录页面
            model.addAttribute("msg","请重新登录！");
            return "login";
        }*/
            return "main";
    }


    /**
     * 测试Druid的监控功能
     * @return
     */
    @ResponseBody
    @GetMapping("/sql")
    public String testDruid(){
        String count = jdbcTemplate.queryForObject("select count(1) from account", String.class);
        return count;
    }

    @ResponseBody
    @GetMapping("/account")
    private Account getAccountById(@RequestParam("id")  String id){
        Integer  id2=Integer.valueOf(id);
    return accountServiceImpl.getAccountById(id2);
    }
}
