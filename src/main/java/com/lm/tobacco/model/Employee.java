package com.lm.tobacco.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import java.io.Serializable;
import java.util.Date;

/**
 * @author liming356
 * @since 2018/9/25/025
 */
public class Employee implements Serializable {

  private Long id;

  @Excel(name = "姓名", isImportField = "true")
  private String name;

  @Excel(name = "身份证", isImportField = "true")
  private String idNo;

  @Excel(name = "年龄", isImportField = "true")
  private Integer age;

  @Excel(
      name = "出生日期",
      width = 20,
      databaseFormat = "yyyyMMddHHmmss",
      format = "yyyy-MM-dd",
      isImportField = "true")
  private Date birthday;

  @Excel(name = "手机号", isImportField = "true")
  private String mobile;

  @Excel(name = "职级", isImportField = "true")
  private String degree;

  @Excel(name = "部门", isImportField = "true")
  private String department;

  @Excel(name = "人员类别", isImportField = "true")
  private String category;

  @Excel(name = "岗位", isImportField = "true")
  private String position;

  @Excel(
      name = "参加工作时间",
      width = 20,
      databaseFormat = "yyyyMMddHHmmss",
      format = "yyyy-MM-dd",
      isImportField = "true")
  private Date entryDate;

  public Employee() {}

  public Employee(
      String name,
      String idNo,
      Integer age,
      Date birthday,
      String mobile,
      String degree,
      String department,
      String category,
      String position,
      Date entryDate) {
    this.name = name;
    this.idNo = idNo;
    this.age = age;
    this.birthday = birthday;
    this.mobile = mobile;
    this.degree = degree;
    this.department = department;
    this.category = category;
    this.position = position;
    this.entryDate = entryDate;
  }

  public Long getId() {
    return id;
  }

  public Employee withId(Long id) {
    this.setId(id);
    return this;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public Employee withName(String name) {
    this.setName(name);
    return this;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getIdNo() {
    return idNo;
  }

  public Employee withIdNo(String idNo) {
    this.setIdNo(idNo);
    return this;
  }

  public void setIdNo(String idNo) {
    this.idNo = idNo;
  }

  public Integer getAge() {
    return age;
  }

  public Employee withAge(Integer age) {
    this.setAge(age);
    return this;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Date getBirthday() {
    return birthday;
  }

  public Employee withBirthday(Date birthday) {
    this.setBirthday(birthday);
    return this;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public String getMobile() {
    return mobile;
  }

  public Employee withMobile(String mobile) {
    this.setMobile(mobile);
    return this;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getDegree() {
    return degree;
  }

  public Employee withDegree(String degree) {
    this.setDegree(degree);
    return this;
  }

  public void setDegree(String degree) {
    this.degree = degree;
  }

  public String getDepartment() {
    return department;
  }

  public Employee withDepartment(String department) {
    this.setDepartment(department);
    return this;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public String getCategory() {
    return category;
  }

  public Employee withCategory(String category) {
    this.setCategory(category);
    return this;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getPosition() {
    return position;
  }

  public Employee withPosition(String position) {
    this.setPosition(position);
    return this;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public Date getEntryDate() {
    return entryDate;
  }

  public Employee withEntryDate(Date entryDate) {
    this.setEntryDate(entryDate);
    return this;
  }

  public void setEntryDate(Date entryDate) {
    this.entryDate = entryDate;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(getClass().getSimpleName());
    sb.append(" [");
    sb.append("Hash = ").append(hashCode());
    sb.append(", id=").append(id);
    sb.append(", name=").append(name);
    sb.append(", idNo=").append(idNo);
    sb.append(", age=").append(age);
    sb.append(", birthday=").append(birthday);
    sb.append(", mobile=").append(mobile);
    sb.append(", degree=").append(degree);
    sb.append(", department=").append(department);
    sb.append(", category=").append(category);
    sb.append(", position=").append(position);
    sb.append(", entryDate=").append(entryDate);
    sb.append("]");
    return sb.toString();
  }
}
