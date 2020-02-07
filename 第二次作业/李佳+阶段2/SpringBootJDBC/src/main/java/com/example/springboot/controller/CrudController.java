package com.example.springboot.controller;

import com.example.springboot.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author shkstart
 * @create 2020-01-26 18:39
 */
@RestController
public class CrudController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //查询所有账户信息
    @GetMapping("/queryAll")
    public List<Account> queryAll(){
        String sql="select * from account";
        List<Account> queryAll = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Account>(Account.class));
        for (Account account : queryAll) {
            System.out.println(account);
        }
        return queryAll;

    }

    //根据id查询账户信息
    @GetMapping("/query/{id}")
    public Map<String,Object> query(@PathVariable("id") int id){
        String sql="select * from account where id=?";
        Map<String,Object> map=jdbcTemplate.queryForMap(sql,id);
        return map;
    }


    //增加账户
    @GetMapping("/add")
    public String addStudent(){
        String sql="insert into account values(null,'李佳',5000)";
        jdbcTemplate.update(sql);
        return "添加成功";
    }

    //更新账户
    @GetMapping("/update/{id}")
    public String updateStudent(@PathVariable("id") int id){
        String sql="update account set balance=10000 where id=?";
        jdbcTemplate.update(sql,id);
        return "更新成功";
    }

    //删除
    @GetMapping("/del/{id}")
    public String delStudent(@PathVariable("id") int id){
        String sql="delete from account where id=?";
        jdbcTemplate.update(sql,id);
        return "删除成功";

    }








}
