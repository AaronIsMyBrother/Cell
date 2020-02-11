package com.aaron.controller;

import com.aaron.bean.User;
import com.aaron.dao.D;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class C {


    @Autowired
    D dao;

    @RequestMapping("/run")
    public String run(Model model){

        Collection<User> users = dao.getAll();

        model.addAttribute("users",users);

        return "main";
    }

    @RequestMapping("/toAddUserRequest")
    public String toAddUser(){
        return "addUser";
    }

    @PostMapping("/addUser")
    public String addUser(User user){
        dao.addUser(user);
        return "redirect:/run";
    }

    @PostMapping("/deleteUser/{name}")
    public String deleteUser(@PathVariable("name")String name){
        dao.deleteUser(name);
        return "redirect:/run";
    }

    @RequestMapping("/toUpdateUser")
    public String updateUser(String name){
        dao.updateUser(name);
        return "updateUser";
    }
}
