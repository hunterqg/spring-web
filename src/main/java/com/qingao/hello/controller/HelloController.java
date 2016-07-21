package com.qingao.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class HelloController {
    @Autowired
    @Qualifier("dataList")
//    @Resource(name="dataList")
    private ArrayList<String> dataList;


    @Autowired
    private Environment env;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello" + dataList.toString();
    }

    @RequestMapping("/cfg")
    public String config() {
        return env.getProperty("key_seven");
    }
}
