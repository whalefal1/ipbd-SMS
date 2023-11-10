package com.ipbd.ipbdsms;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableKnife4j
@Slf4j
public class IpbdSmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(IpbdSmsApplication.class, args);
    }

}
