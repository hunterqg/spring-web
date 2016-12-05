package com.qingao.hello.dao;

import com.qingao.hello.dao.mapper.UserMapper;
import com.qingao.hello.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by qingao on 16-8-19.
 */
@Component
public class UserDao {
    private static final String SQL_SELECT_USER_BY_ID = "select id,phone,token,uid,height," +
            "passwd,device_type ,create_at ,update_at from `user` where id=:id";
    public static final String SQL_GET_USER_BY_PHONE = "select id,phone,token,uid,height," +
            "passwd,device_type,create_at,update_at from `user` where phone=:phone";
    @Autowired
    @Qualifier("jdbcTemplate")
    private NamedParameterJdbcTemplate jdbcTemplate;
    private static Logger logger = Logger.getLogger(User.class);

    @Autowired
    UserMapper userMapper;

    public User getUser(Integer id) {
/*        final User user = new User();

        Map<String, Integer> map = new HashMap<>();
        map.put("id", id);

        return jdbcTemplate.queryForObject(
                SQL_SELECT_USER_BY_ID,
                map, new RowMapper<User>() {
                    @Override
                    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                        resultSetToUser(rs, user);
                        return user;
                    }
                });*/
        return userMapper.getUserById(id);
    }

    public User getUserByPhone(String phone) {
       /* final User user = new User();

        Map<String, String> map = new HashMap<>();
        map.put("phone", phone);
        try {
            return jdbcTemplate.queryForObject(
                    SQL_GET_USER_BY_PHONE,
                    map, new RowMapper<User>() {
                        @Override
                        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                            resultSetToUser(rs, user);

                            return user;
                        }
                    });
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }*/
        return userMapper.getUserByPhone(phone);
    }

    public int insert(User user) {
        /*if (user == null) {
            return -1;
        }
        Map<String, Object> map = new HashMap<>();
        String insertSql = getInsertSql(user, map);

        return jdbcTemplate.update(insertSql, map);*/
        return userMapper.insertUser(user);
    }

    private String getInsertSql(User user, Map<String, Object> map) {
        if (user == null) {
            return "";
        }
        String retVal = "insert into `user` ";
        String cloumns = "(";
        String values = " values (";
        boolean flag = false;
        if (null != user.getPhone()) {
            cloumns += "phone,";
            values += ":phone,";
            map.put("phone", user.getPhone());
            flag = true;
        }
        if (null != user.getUid()) {
            cloumns += "uid,";
            values += ":uid,";
            map.put("uid", user.getUid());
            flag = true;
        }
        if (null != user.getPasswd()) {
            cloumns += "passwd,";
            values += ":passwd,";
            map.put("passwd", user.getPasswd());
            flag = true;
        }
        if (null != user.getHeight()) {
            cloumns += "height,";
            values += ":height,";
            map.put("height", user.getHeight());
            flag  =true;
        }
        if (null != user.getToken()) {
            cloumns += "token,";
            values += ":token,";
            map.put("token", user.getToken());
            flag = true;
        }
        if (null != user.getDeviceType()) {
            cloumns += "device_type,";
            values += ":device_type";
            map.put("device_type", user.getDeviceType());
            flag = true;
        }

        if (flag) {
            cloumns = cloumns.substring(0, cloumns.length() - 1);
            values = values.substring(0, values.length() - 1);
        }
        cloumns += ")";
        values += ")";
        String sql = retVal + cloumns + values;
        logger.debug("Generated Insert Sql:" + sql);
        return sql;
    }

    private void resultSetToUser(ResultSet rs, User user) throws SQLException {
        user.setId(rs.getInt("id"));
        user.setPhone(rs.getString("phone"));
        user.setPasswd(rs.getString("passwd"));
        user.setToken(rs.getString("token"));
        user.setUid(rs.getString("uid"));
        user.setDeviceType(rs.getInt("device_type"));
        user.setHeight(rs.getFloat("height"));
        user.setCreateAt(rs.getDate("create_at"));
        user.setUpdateAt(rs.getDate("update_at"));
    }
}
