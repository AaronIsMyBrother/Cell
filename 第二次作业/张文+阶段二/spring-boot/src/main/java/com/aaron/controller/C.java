package com.aaron.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class C {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @ResponseBody
    @GetMapping("/create")
    public List<Map<String, Object>>  create(){
        System.out.println(1);
        jdbcTemplate.update("insert into test values('long',100)");
        System.out.println(2);
        List<Map<String,Object>> list=query();
        System.out.println(3);
        return list;
    }

    @ResponseBody
    @GetMapping("/delete")
    public List<Map<String, Object>> delete(){
        System.out.println(4);
        jdbcTemplate.execute("delete from test where name='long' ");
        System.out.println(5);
        List<Map<String,Object>> list=query();
        System.out.println(6);
        return list;
    }

    @ResponseBody
    @GetMapping("/update")
    public List<Map<String,Object>> update(){
        System.out.println(7);
        jdbcTemplate.update("update test set age=200 where name='long'");
        System.out.println(8);
        List<Map<String,Object>> list=query();
        System.out.println(9);
        return list;
    }

    @ResponseBody
    @GetMapping("/query")
    public List<Map<String,Object>> query(){
        System.out.println(10);
        List<Map<String,Object>> list = jdbcTemplate.queryForList("select * from test");
        System.out.println(11);
        return list;
    }

}
