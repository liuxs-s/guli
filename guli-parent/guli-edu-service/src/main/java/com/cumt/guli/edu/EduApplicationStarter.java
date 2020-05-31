package com.cumt.guli.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @description: 启动类
 * @author: liuxiaosong
 * @Date: 2020/5/4
 * @version: 1.0
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.cumt"})
public class EduApplicationStarter {
    public static void main(String[] args) {
        SpringApplication.run(EduApplicationStarter.class,args);
    }
}
