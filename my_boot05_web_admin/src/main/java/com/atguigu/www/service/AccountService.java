package com.atguigu.www.service;

import com.atguigu.www.bean.Account;
import com.atguigu.www.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public interface AccountService {
    public Account getAccountById(Integer id);
}
