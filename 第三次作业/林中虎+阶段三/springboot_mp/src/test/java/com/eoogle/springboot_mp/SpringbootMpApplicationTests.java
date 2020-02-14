package com.eoogle.springboot_mp;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.eoogle.entity.Employee;
import com.eoogle.service.EmployeeService;
import com.eoogle.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class SpringbootMpApplicationTests {

    @Autowired
    private EmployeeServiceImpl employeeService;

    /**
     * 查询所有员工信息
     */
    @Test
    void testList(){
        List<Employee> list = employeeService.list();
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }


    /**
     * 增加员工信息
     */
    @Test
    void testSave(){
        Employee employee = new Employee();
        employee.setAge(20);
        employee.setGender("1");
        employee.setEmail("321312@qq.com");
        employeeService.save(employee);
    }

    /**
     * 删除员工信息
     */
    @Test
    void testRemove(){
       employeeService.removeById(1);
    }

    /**
     * 修改员工信息
     */
    @Test
    void testUpdate(){
        Employee employee = new Employee();
        employee.setId(2);
        employee.setAge(20);
        employee.setGender("1");
        employee.setEmail("321312@qq.com");
        employeeService.updateById(employee);
    }

    /**
     * 条件构造修改员工信息
     */
    @Test
    void testUpdateWrapper1(){
        //修改值
        Employee employee = new Employee();
        employee.setAge(40);
        //修改条件s
        UpdateWrapper<Employee> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.eq("last_name", "Black");//把列last_name等于Black的行修改
        employeeService.update(employee, userUpdateWrapper);
    }

    /**
     * 条件构造删除员工信息
     */
    @Test
    void testUpdateWrapper2(){
        //删除条件s
        UpdateWrapper<Employee> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.lt("age", "30");//删除小于30 的记录
        employeeService.remove(userUpdateWrapper);
    }


    /**
     * 分页查询
     */
    @Test
    public void selectPage() {
        Page<Employee> page = new Page<>(1, 2);
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();

        IPage<Employee> userIPage = employeeService.page(page, queryWrapper);
        System.out.println(userIPage);
        System.out.println(userIPage.getRecords());
    }


}
