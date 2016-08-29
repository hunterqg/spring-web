package com.qingao.hello.controller;

import com.qingao.hello.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;

import javax.servlet.http.Part;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by qingao on 16-8-10.
 */

@Controller
public class RegisterController {
    @Autowired
    private UserDao userDao;
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

        logger.debug("home accessed!" + userDao.getUser(3));
        return "welcome";
    }
    @RequestMapping(value = "upload",method = RequestMethod.GET)
    public String uploadPage() {
        return "uploadForm";
    }
    @RequestMapping(value = "upload",method = RequestMethod.POST)
    public String upload(Model model, @RequestPart("uploadFile")Part uploadedFile) throws IOException{
        model.addAttribute("msg","OK!");
        uploadedFile.write("/tmp/" + uploadedFile.getName());
        return "forward:uploadPage";
    }

}
