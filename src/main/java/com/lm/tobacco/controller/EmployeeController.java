package com.lm.tobacco.controller;

import com.lm.tobacco.service.EmployeeService;
import java.util.HashMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liming356
 * @since 2018/9/21/021
 */
@Controller
public class EmployeeController {

  private EmployeeService employeeService;

  public EmployeeController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @GetMapping(value = "/")
  public String index(HashMap<String, Object> map) throws Exception {
    map.put("hello", "test");
    employeeService.async();
    System.out.println("主线程  " + Thread.currentThread().getName());
    return "index";
  }

  @GetMapping(value = "/find")
  @ResponseBody
  public Object getEmployeeInfo(String id) {
    return employeeService.getEmployeeInfoById(id);
  }
}
