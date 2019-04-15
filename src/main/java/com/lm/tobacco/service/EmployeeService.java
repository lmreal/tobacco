package com.lm.tobacco.service;

import com.lm.tobacco.generated.entity.Employee;

/**
 * @author liming356
 * @since 2018/9/21/021
 */
public interface EmployeeService {

    /**
     * 获取员工信息
     * @param id
     * @return
     */
    Employee getEmployeeInfoById(String id);

}
