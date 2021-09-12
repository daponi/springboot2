package com.atguigu.www.service.impl;

import com.atguigu.www.bean.Account;
import com.atguigu.www.mapper.AccountMapper;
import com.atguigu.www.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl  implements AccountService {
    @Autowired
    AccountMapper accountMapper;

    @Override
    public Account getAccountById(Integer id){
        return accountMapper.getAccountById(id);
    }
}
