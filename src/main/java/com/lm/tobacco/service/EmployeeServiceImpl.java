package com.lm.tobacco.service;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.lm.tobacco.generated.entity.Employee;
import com.lm.tobacco.generated.mapper.EmployeeMapper;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

/**
 * @author liming356
 * @since 2018/9/21/021
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeMapper employeeMapper;

    public EmployeeServiceImpl(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    @Override
    public Employee getEmployeeInfoById(String id) {
        return employeeMapper.selectByPrimaryKey(Long.parseLong(id));
    }

    public void importEmployee(InputStream inputStream) {
        ImportParams params = new ImportParams();
        //params.setTitleRows(1);//表格标题行数,默认0
        //params.setHeadRows(1);//表头行数,默认1
        params.setStartRows(0);
        try {
            List<com.lm.tobacco.model.Employee> list = ExcelImportUtil.importExcel(inputStream, com.lm.tobacco.model.Employee.class, params);
            System.out.println(list.toString());
            System.out.println(ReflectionToStringBuilder.toString(list.get(0)));
        } catch (Exception e) {

        }
    }


}
