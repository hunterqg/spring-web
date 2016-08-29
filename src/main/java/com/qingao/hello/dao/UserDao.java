package com.qingao.hello.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by qingao on 16-8-19.
 */
@Component
public class UserDao {
    @Autowired
    @Qualifier("jdbcTemplate")
    private NamedParameterJdbcTemplate jdbcTemplate;


    @Secured("ROLE_ADMIN")
    public Map getUser(Integer id) {
        Map<String,Integer> map = new HashMap<>();
        map.put("id",id);
        return jdbcTemplate.queryForObject("select * from user where id=:id", map, new RowMapper<Map>() {
            @Override
            public Map mapRow(ResultSet rs, int rowNum) throws SQLException {
                Map rMap = new HashMap();
                rMap.put("id",rs.getInt("id"));
                rMap.put("name",rs.getString("name"));
                rMap.put("age",rs.getInt("age"));
                return rMap;
            }
        });
    }
}
