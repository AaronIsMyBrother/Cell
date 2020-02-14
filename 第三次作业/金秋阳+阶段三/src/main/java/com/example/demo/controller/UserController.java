package com.example.demo.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.User;
import com.example.demo.service.IUserService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author jqy
 * @since 2020-02-13
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/user")
public class UserController {

    //注入mapper类
    @Resource
    private IUserService userService;

    @RequestMapping(value="{id}", method= RequestMethod.GET, produces="application/json")
    public User getUser(@PathVariable long id) throws Exception {

        User user = this.userService.getUserById(id);

        return user;
    }

    @RequestMapping(value="", method = RequestMethod.GET, produces="application/json")
    public IPage<User> list(@RequestParam(value="page", required=false, defaultValue="1") int page,
                            @RequestParam(value="page-size", required=false, defaultValue="5") int pageSize){
        IPage<User> ipage = userService.selectPage(new Page<>(page,pageSize));

        return ipage;
    }


}
