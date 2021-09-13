package com.atguigu.www.service.impl;

import com.atguigu.www.bean.User;
import com.atguigu.www.mapper.UserMapper;
import com.atguigu.www.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
