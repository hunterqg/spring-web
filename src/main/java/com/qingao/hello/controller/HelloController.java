package com.qingao.hello.controller;

import com.qingao.hello.dao.UserDao;
import com.qingao.hello.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
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
    public User user(@PathVariable Integer id) {
        return userDao.getUser(id);
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello" ;
    }
}
