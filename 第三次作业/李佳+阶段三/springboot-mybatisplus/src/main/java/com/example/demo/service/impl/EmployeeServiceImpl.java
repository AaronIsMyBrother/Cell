package com.example.demo.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.demo.beans.Employee;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.service.EmployeeService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lj
 * @since 2020-02-11
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
    //不用再进行mapper的注入了，因为父类已经注入了
    /**
     * EmployeeServiceImpl 继承了 ServiceImpl
     * 1、在ServiceImpl中，已经完成了mapper对象的注入，可以直接在EmployeeServiceImpl中使用
     * 2、在ServiceImpl中，也帮我们提供了常用的CRUD方法，基本的一些Crud的方法在service中不需要自己定义。
     */
}
