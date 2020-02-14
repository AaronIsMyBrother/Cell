package com.example.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.jws.soap.SOAPBinding;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author jqy
 * @since 2020-02-13
 */
public interface IUserService extends IService<User> {
     User getUserById(long userId);

     IPage<User> selectPage(Page<User> page);

}
