package com.eoogle.service.impl;

import com.eoogle.entity.Employee;
import com.eoogle.dao.EmployeeMapper;
import com.eoogle.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Eoogle
 * @since 2020-02-11
 */
@Service("employeeService")
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
