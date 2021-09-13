package com.atguigu.www;

import com.atguigu.www.bean.User;
import com.atguigu.www.mapper.UserMapper;
import com.baomidou.mybatisplus.core.toolkit.Assert;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

@Slf4j
@SpringBootTest
class MyBoot05WebAdminApplicationTests {

    @Autowired
    JdbcTemplate template;
    @Autowired
    DataSource dataSource;
    @Autowired
    UserMapper userMapper;


    @Test
    void contextLoads() {
    }

    @Test
    void testJDBC(){
        Long aLong = template.queryForObject("select count(1) from account", Long.class);
        log.info("总共条数{}"+aLong);
        log.info("使用的数据类型是:{}"+dataSource.getClass());
    }

    @Test
    void testMatis_plus(){
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

}
