package com.cn.webmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


@ServletComponentScan
@SpringBootApplication
public class MyStartApp {
    public static void main(String[] args) {
        SpringApplication.run(MyStartApp.class, args);
    }
}
