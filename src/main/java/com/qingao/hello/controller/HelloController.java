package com.qingao.hello.controller;

import com.qingao.hello.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Map;

@RestController
public class HelloController {
    @Autowired
    @Qualifier("dataList")
//    @Resource(name="dataList")
    private ArrayList<String> dataList;


    @Autowired
    private Environment env;

    @Autowired
    private UserDao userDao;

    @RequestMapping("/")
    public String index() {

        return "Greetings from Spring Boot! ";

    }

    @RequestMapping("/{id}")
    @ResponseBody
    public Map user(@PathVariable Integer id) {
        return userDao.getUser(id);
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello" + dataList.toString();
    }

    @RequestMapping("/cfg")
    public String config() {
        System.out.println("-------->" + env);
        return env.getProperty("key_seven");
    }
}
