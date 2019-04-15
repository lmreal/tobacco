package com.lm.tobacco.generated.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class EmployeeDynamicSqlSupport {
  @Generated(
      value = "org.mybatis.generator.api.MyBatisGenerator",
      comments = "Source Table: employee")
  public static final Employee employee = new Employee();

  @Generated(
      value = "org.mybatis.generator.api.MyBatisGenerator",
      comments = "Source field: employee.id")
  public static final SqlColumn<Long> id = employee.id;

  /** Database Column Remarks: 姓名 */
  @Generated(
      value = "org.mybatis.generator.api.MyBatisGenerator",
      comments = "Source field: employee.name")
  public static final SqlColumn<String> name = employee.name;

  /** Database Column Remarks: 身份证 */
  @Generated(
      value = "org.mybatis.generator.api.MyBatisGenerator",
      comments = "Source field: employee.id_no")
  public static final SqlColumn<String> idNo = employee.idNo;

  /** Database Column Remarks: 年龄 */
  @Generated(
      value = "org.mybatis.generator.api.MyBatisGenerator",
      comments = "Source field: employee.age")
  public static final SqlColumn<Integer> age = employee.age;

  /** Database Column Remarks: 出生日期 */
  @Generated(
      value = "org.mybatis.generator.api.MyBatisGenerator",
      comments = "Source field: employee.birthday")
  public static final SqlColumn<Date> birthday = employee.birthday;

  /** Database Column Remarks: 手机号 */
  @Generated(
      value = "org.mybatis.generator.api.MyBatisGenerator",
      comments = "Source field: employee.mobile")
  public static final SqlColumn<String> mobile = employee.mobile;

  /** Database Column Remarks: 职级 */
  @Generated(
      value = "org.mybatis.generator.api.MyBatisGenerator",
      comments = "Source field: employee.degree")
  public static final SqlColumn<String> degree = employee.degree;

  /** Database Column Remarks: 部门 */
  @Generated(
      value = "org.mybatis.generator.api.MyBatisGenerator",
      comments = "Source field: employee.department")
  public static final SqlColumn<String> department = employee.department;

  /** Database Column Remarks: 人员类别 */
  @Generated(
      value = "org.mybatis.generator.api.MyBatisGenerator",
      comments = "Source field: employee.category")
  public static final SqlColumn<String> category = employee.category;

  /** Database Column Remarks: 岗位 */
  @Generated(
      value = "org.mybatis.generator.api.MyBatisGenerator",
      comments = "Source field: employee.position")
  public static final SqlColumn<String> position = employee.position;

  /** Database Column Remarks: 参加工作时间 */
  @Generated(
      value = "org.mybatis.generator.api.MyBatisGenerator",
      comments = "Source field: employee.entry_date")
  public static final SqlColumn<Date> entryDate = employee.entryDate;

  /** Database Column Remarks: 领导 */
  @Generated(
      value = "org.mybatis.generator.api.MyBatisGenerator",
      comments = "Source field: employee.leader")
  public static final SqlColumn<String> leader = employee.leader;

  /** Database Column Remarks: 领导ID */
  @Generated(
      value = "org.mybatis.generator.api.MyBatisGenerator",
      comments = "Source field: employee.leader_id")
  public static final SqlColumn<Long> leaderId = employee.leaderId;

  @Generated(
      value = "org.mybatis.generator.api.MyBatisGenerator",
      comments = "Source Table: employee")
  public static final class Employee extends SqlTable {
    public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

    public final SqlColumn<String> name = column("`name`", JDBCType.VARCHAR);

    public final SqlColumn<String> idNo = column("id_no", JDBCType.VARCHAR);

    public final SqlColumn<Integer> age = column("age", JDBCType.INTEGER);

    public final SqlColumn<Date> birthday = column("birthday", JDBCType.DATE);

    public final SqlColumn<String> mobile = column("mobile", JDBCType.VARCHAR);

    public final SqlColumn<String> degree = column("`degree`", JDBCType.VARCHAR);

    public final SqlColumn<String> department = column("department", JDBCType.VARCHAR);

    public final SqlColumn<String> category = column("category", JDBCType.VARCHAR);

    public final SqlColumn<String> position = column("`position`", JDBCType.VARCHAR);

    public final SqlColumn<Date> entryDate = column("entry_date", JDBCType.DATE);

    public final SqlColumn<String> leader = column("leader", JDBCType.VARCHAR);

    public final SqlColumn<Long> leaderId = column("leader_id", JDBCType.BIGINT);

    public Employee() {
      super("employee");
    }
  }
}
