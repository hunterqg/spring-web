package com.qingao.hello.controller;

import com.qingao.hello.model.User;
import com.qingao.hello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.Controller;

import java.util.Map;

/**
 * Created by qingao on 2016/11/28.
 */
@RestController
@RequestMapping("rest/v1")
public class IEyeControlloer {

    @Autowired
    private UserService userService;


    @RequestMapping(path="/getCode",method = RequestMethod.GET)
    public Map<String, Object> sendPhoneValidCode(@RequestParam(value="userPhone")String phone,
                                  @RequestParam(value = "type") int type) {

        return userService.getCode(phone,type);
    }
}
