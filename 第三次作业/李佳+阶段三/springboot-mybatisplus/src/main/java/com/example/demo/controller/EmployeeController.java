package com.example.demo.controller;



import com.baomidou.mybatisplus.plugins.Page;
import com.example.demo.beans.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lj
 * @since 2020-02-11
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @ResponseBody
    @RequestMapping("/findAll")
    public String findAll(){
        List<Employee> emps = employeeService.selectList(null);
        System.out.println(emps);
        return "操作成功";
    }

    @ResponseBody
    @RequestMapping("/page")
    public String page(){
        Page<Employee> page = employeeService.selectPage(new Page<Employee>(1, 3));
        List<Employee> emps = page.getRecords();
        System.out.println(emps);
        return "操作成功";
    }

    @ResponseBody
    @RequestMapping("/findById")
    public String findById(){
        Employee emp = employeeService.selectById(2);
        System.out.println(emp);
        return "操作成功";
    }

    @ResponseBody
    @RequestMapping("/delete")
    public String delete(){
        boolean result = employeeService.deleteById(11);
        System.out.println(result);
        return "操作成功";
    }

    @ResponseBody
    @RequestMapping("/insert")
    public String insert(){
        Employee employee=new Employee();
        employee.setAge(23);
        employee.setEmail("123456@qq.com");
        employee.setGender("0");
        employee.setLastName("jj");

        employeeService.insert(employee);
        return "操作成功";
    }


}

