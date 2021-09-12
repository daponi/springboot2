package com.atguigu.www.mapper;

import com.atguigu.www.bean.Account;
import org.apache.ibatis.annotations.Mapper;

//@Mapper
public interface AccountMapper {
     Account getAccountById(Integer id);
}
