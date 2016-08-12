package com.qingao.hello.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qingao on 16-8-10.
 */

@Controller
public class RegisterController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @RequestMapping(value="/register",method = RequestMethod.GET)
    public String register(Model model) {
        Map<String,String> userMap = new HashMap<>();
        userMap.put("firstName",null);
        model.addAttribute("user",new HashMap<String,String>());
        return "registerForm";
    }

    @RequestMapping(value="/home",method = RequestMethod.GET)
    public String home() {
        logger.debug("home accessed!");
        return "welcome";
    }
}
