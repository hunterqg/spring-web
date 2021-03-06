package com.qingao.hello.service;

import com.qingao.hello.dao.UserDao;
import com.qingao.hello.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qingao on 2016/11/28.
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Transactional
    public Map<String, Object> getCode(String phone, int type) {
        Map<String, Object> retMap = new HashMap<>();
        retMap.put("code", 0);
        switch (type) {
            case 1:
                getCodeForRegister(phone, retMap);
                break;
            case 2:

                break;
            default:
                retMap.put("code", 1);
                retMap.put("msg", "unknown get sms code type.");
        }
        return retMap;
    }

    private void getCodeForRegister(String phone, Map<String, Object> retMap) {
        User user = userDao.getUserByPhone(phone);
        if (user == null) {
            //insert phone into db
            user = new User();
            user.setPhone(phone);
            if (userDao.insert(user) < 0) {
                //insert failed
                retMap.put("code",2);
                retMap.put("msg","save phone failed.");
            }else {
                //get sms code by sdk
                String smsCode = getSmsCode();
                //write to redis

                retMap.put("code", 0);
                retMap.put("smsVerifyCode", smsCode);
            }

        } else {//already register
            if(user.getUid() == null) {
                String smsCode = getSmsCode();
                //write to redis

                retMap.put("code",0);
                retMap.put("smsVerifyCode",smsCode);
            }else {
                retMap.put("code", 1);
                retMap.put("msg", "Phone already registered!");
            }
        }
    }
    private String getSmsCode() {
        return "1234";
    }

    public User getUserByPhone(String phone) {
        return userDao.getUserByPhone(phone);
    }


}
