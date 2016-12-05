package com.qingao.hello.dao.mapper;

import com.qingao.hello.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by qingao on 2016/12/1.
 */

@Mapper
public interface UserMapper {
     String SQL_SELECT_USER_BY_ID = "select id,phone,token,uid,height," +
            "passwd,device_type as deviceType,create_at as createAt,update_at as updateAt from `user` where id=#{id}";

    String SQL_GET_USER_BY_PHONE = "select id,phone,token,uid,height," +
            "passwd,device_type as deviceType,create_at as createAt,update_at as updateAt from `user` where phone=#{phone}";

    String SQL_INSER_USER = "insert into user (phone,token,uid,height,passwd,device_type) " +
            "values (#{phone},#{token},#{uid},#{height},#{passwd},#{deviceType})";
    @Select(SQL_SELECT_USER_BY_ID)
    User getUserById(@Param("id") Integer id);

    @Select(SQL_GET_USER_BY_PHONE)
    User getUserByPhone(String phone);

    @Insert(SQL_INSER_USER)
    int insertUser(User user);
}
