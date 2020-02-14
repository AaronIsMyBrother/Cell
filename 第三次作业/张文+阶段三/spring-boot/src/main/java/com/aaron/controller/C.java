package com.aaron.controller;

import com.aaron.bean.User;

import com.aaron.mapper.UserMap;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class C {

    /************************ mybatis-plus ************************/
    @Autowired
    UserMap userMap;

    @RequestMapping("/run")
    public String run(Model model){
        selectPage();
        List<User> users = userMap.selectList(null);
        model.addAttribute("users",users);
        return "main";
    }
    @RequestMapping("/toAddUserRequest")
    public String toAddUser(){
        return "addUser";
    }
    @PostMapping("/addUser")
    public String addUser(User user){
        userMap.insert(user);
        return "redirect:/run";
    }

    @PostMapping("/deleteUser/{name}")
    public String deleteUser(@PathVariable("name")String name){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name",name);
        userMap.delete(wrapper);
        return "redirect:/run";
    }

    //分页查询
    public void selectPage(){
        Page<User> page = new Page<>(1,2);

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("name","小龙");

        IPage<User> iPage = userMap.selectPage(page,wrapper);

        List<User> records = iPage.getRecords();

        for(User user : records){
            System.out.println("{ name= "+user.getName()+", age="+user.getAge()+" }");
        }
    }

}
