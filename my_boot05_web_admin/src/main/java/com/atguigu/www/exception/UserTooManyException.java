package com.atguigu.www.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN,reason = "你设置的用户数量太多了！！！")
public class UserTooManyException extends RuntimeException{
    public UserTooManyException() {//构造器
    }

    public UserTooManyException(String message) {
        super(message);
    }
}
