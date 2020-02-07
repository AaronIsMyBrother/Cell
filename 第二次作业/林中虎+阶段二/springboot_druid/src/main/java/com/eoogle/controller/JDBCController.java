package com.eoogle.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JDBCController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    //查询数据库的所有信息
    @GetMapping("/userList")
    public List<Map<String,Object>> userList(){
        String sql = "select * from users";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        logger.info("查询所有用户信息");
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
        return maps;
    }

    //增加用户
    @GetMapping("/addUser")
    public String addUser(){
        String sql = "insert into users values(3,'王五',21,'cccc')";
        int update = jdbcTemplate.update(sql);
        if(update>0)
            return "add-success";
        else
            return "add-fail";
    }
    //增加用户
    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id")int id){
        String sql = "update users set name=?,age=?,password=? where id = "+id;
        //封装
        Object[] objects = new Object[3];
        objects[0] = "李明";
        objects[1] = "32";
        objects[2] = "ddddd";
        int update = jdbcTemplate.update(sql,objects);
        if(update>0)
            return "update-success";
        else
            return "update-fail";
    }
    //增加用户
    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id")int id){
        String sql = "delete from users where id =?";
        int update = jdbcTemplate.update(sql,id);
        if(update>0)
            return "delete-success";
        else
            return "delete-fail";
    }



}
