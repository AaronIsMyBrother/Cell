package com.eoogle.dao;

import com.eoogle.entity.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Eoogle
 * @since 2020-02-11
 */
@Component
public interface EmployeeMapper extends BaseMapper<Employee> {

}
