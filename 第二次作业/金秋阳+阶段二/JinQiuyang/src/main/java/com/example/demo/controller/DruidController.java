package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Types;
import java.util.List;
import java.util.Map;

@RestController
public class DruidController {

    @Autowired
    JdbcTemplate jdbc;

    //修改数据
    @RequestMapping(value ="/update")
    public void update(){
        String sql = "UPDATE user SET password = '333' WHERE name = '张三'";
        jdbc.update(sql);

    }

    //添加数据
    @RequestMapping(value = "/add")
    public void add(){
        String sql = "insert into user(name,mobile,password,address) values('张一',1212131223,'12213','江苏省')";
        jdbc.update(sql);

    }

    //查询数据
    @RequestMapping(value = "/query")
    public List<Map<String,Object>> queryNameListMap(){
        String sql = "select * from user";
        return this.jdbc.queryForList(sql);
    }

    //删除数据
    @RequestMapping(value = "/delete")
    public int deleteUser(String name){
        String sql = "delete from user where name = ?";
        Object[] args = {name};
        int[] argType = {Types.VARCHAR};
        return this.jdbc.update(sql,args,argType);


    }
    

}
