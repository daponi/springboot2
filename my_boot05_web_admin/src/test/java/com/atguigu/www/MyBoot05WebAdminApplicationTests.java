package com.atguigu.www;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
class MyBoot05WebAdminApplicationTests {

    @Autowired
    JdbcTemplate template;
    @Autowired
    DataSource dataSource;


    @Test
    void contextLoads() {
    }

    @Test
    void testJDBC(){
        Long aLong = template.queryForObject("select count(1) from account", Long.class);
        log.info("总共条数{}"+aLong);
        log.info("使用的数据类型是:{}"+dataSource.getClass());
    }

}
