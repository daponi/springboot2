package com.atguigu.www.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("atguigu.hello")
@Data
public class HelloProperties {
    private String  prefix;
    private String  suffix;
}
