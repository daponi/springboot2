package com.atguigu.www.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@TableName("user")
public class User implements Serializable {
    @TableField(exist = false)
    private String userName;
    @TableField(exist = false)
    private String password;

    /*studyDB-2的数据库字段*/
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
