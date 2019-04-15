package com.lm.tobacco.generated.mapper;

import static com.lm.tobacco.generated.mapper.EmployeeDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.lm.tobacco.generated.entity.Employee;
import java.util.List;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.delete.DeleteDSL;
import org.mybatis.dynamic.sql.delete.MyBatis3DeleteModelAdapter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.render.RenderingStrategy;
import org.mybatis.dynamic.sql.select.MyBatis3SelectModelAdapter;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.mybatis.dynamic.sql.select.SelectDSL;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.MyBatis3UpdateModelAdapter;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;

@Mapper
public interface EmployeeMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: employee")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: employee")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: employee")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    @Options(useGeneratedKeys=true,keyProperty="record.id")
    int insert(InsertStatementProvider<Employee> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: employee")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("EmployeeResult")
    Employee selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: employee")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="EmployeeResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_no", property="idNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="age", property="age", jdbcType=JdbcType.INTEGER),
        @Result(column="birthday", property="birthday", jdbcType=JdbcType.DATE),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="degree", property="degree", jdbcType=JdbcType.VARCHAR),
        @Result(column="department", property="department", jdbcType=JdbcType.VARCHAR),
        @Result(column="category", property="category", jdbcType=JdbcType.VARCHAR),
        @Result(column="position", property="position", jdbcType=JdbcType.VARCHAR),
        @Result(column="entry_date", property="entryDate", jdbcType=JdbcType.DATE),
        @Result(column="leader", property="leader", jdbcType=JdbcType.VARCHAR),
        @Result(column="leader_id", property="leaderId", jdbcType=JdbcType.BIGINT)
    })
    List<Employee> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: employee")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: employee")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(employee);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: employee")
    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, employee);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: employee")
    default int deleteByPrimaryKey(Long id_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, employee)
                .where(id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: employee")
    default int insert(Employee record) {
        return insert(SqlBuilder.insert(record)
                .into(employee)
                .map(name).toProperty("name")
                .map(idNo).toProperty("idNo")
                .map(age).toProperty("age")
                .map(birthday).toProperty("birthday")
                .map(mobile).toProperty("mobile")
                .map(degree).toProperty("degree")
                .map(department).toProperty("department")
                .map(category).toProperty("category")
                .map(position).toProperty("position")
                .map(entryDate).toProperty("entryDate")
                .map(leader).toProperty("leader")
                .map(leaderId).toProperty("leaderId")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: employee")
    default int insertSelective(Employee record) {
        return insert(SqlBuilder.insert(record)
                .into(employee)
                .map(name).toPropertyWhenPresent("name", record::getName)
                .map(idNo).toPropertyWhenPresent("idNo", record::getIdNo)
                .map(age).toPropertyWhenPresent("age", record::getAge)
                .map(birthday).toPropertyWhenPresent("birthday", record::getBirthday)
                .map(mobile).toPropertyWhenPresent("mobile", record::getMobile)
                .map(degree).toPropertyWhenPresent("degree", record::getDegree)
                .map(department).toPropertyWhenPresent("department", record::getDepartment)
                .map(category).toPropertyWhenPresent("category", record::getCategory)
                .map(position).toPropertyWhenPresent("position", record::getPosition)
                .map(entryDate).toPropertyWhenPresent("entryDate", record::getEntryDate)
                .map(leader).toPropertyWhenPresent("leader", record::getLeader)
                .map(leaderId).toPropertyWhenPresent("leaderId", record::getLeaderId)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: employee")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<Employee>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, id, name, idNo, age, birthday, mobile, degree, department, category, position, entryDate, leader, leaderId)
                .from(employee);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: employee")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<Employee>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, id, name, idNo, age, birthday, mobile, degree, department, category, position, entryDate, leader, leaderId)
                .from(employee);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: employee")
    default Employee selectByPrimaryKey(Long id_) {
        return SelectDSL.selectWithMapper(this::selectOne, id, name, idNo, age, birthday, mobile, degree, department, category, position, entryDate, leader, leaderId)
                .from(employee)
                .where(id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: employee")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(Employee record) {
        return UpdateDSL.updateWithMapper(this::update, employee)
                .set(name).equalTo(record::getName)
                .set(idNo).equalTo(record::getIdNo)
                .set(age).equalTo(record::getAge)
                .set(birthday).equalTo(record::getBirthday)
                .set(mobile).equalTo(record::getMobile)
                .set(degree).equalTo(record::getDegree)
                .set(department).equalTo(record::getDepartment)
                .set(category).equalTo(record::getCategory)
                .set(position).equalTo(record::getPosition)
                .set(entryDate).equalTo(record::getEntryDate)
                .set(leader).equalTo(record::getLeader)
                .set(leaderId).equalTo(record::getLeaderId);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: employee")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(Employee record) {
        return UpdateDSL.updateWithMapper(this::update, employee)
                .set(name).equalToWhenPresent(record::getName)
                .set(idNo).equalToWhenPresent(record::getIdNo)
                .set(age).equalToWhenPresent(record::getAge)
                .set(birthday).equalToWhenPresent(record::getBirthday)
                .set(mobile).equalToWhenPresent(record::getMobile)
                .set(degree).equalToWhenPresent(record::getDegree)
                .set(department).equalToWhenPresent(record::getDepartment)
                .set(category).equalToWhenPresent(record::getCategory)
                .set(position).equalToWhenPresent(record::getPosition)
                .set(entryDate).equalToWhenPresent(record::getEntryDate)
                .set(leader).equalToWhenPresent(record::getLeader)
                .set(leaderId).equalToWhenPresent(record::getLeaderId);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: employee")
    default int updateByPrimaryKey(Employee record) {
        return UpdateDSL.updateWithMapper(this::update, employee)
                .set(name).equalTo(record::getName)
                .set(idNo).equalTo(record::getIdNo)
                .set(age).equalTo(record::getAge)
                .set(birthday).equalTo(record::getBirthday)
                .set(mobile).equalTo(record::getMobile)
                .set(degree).equalTo(record::getDegree)
                .set(department).equalTo(record::getDepartment)
                .set(category).equalTo(record::getCategory)
                .set(position).equalTo(record::getPosition)
                .set(entryDate).equalTo(record::getEntryDate)
                .set(leader).equalTo(record::getLeader)
                .set(leaderId).equalTo(record::getLeaderId)
                .where(id, isEqualTo(record::getId))
                .build()
                .execute();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: employee")
    default int updateByPrimaryKeySelective(Employee record) {
        return UpdateDSL.updateWithMapper(this::update, employee)
                .set(name).equalToWhenPresent(record::getName)
                .set(idNo).equalToWhenPresent(record::getIdNo)
                .set(age).equalToWhenPresent(record::getAge)
                .set(birthday).equalToWhenPresent(record::getBirthday)
                .set(mobile).equalToWhenPresent(record::getMobile)
                .set(degree).equalToWhenPresent(record::getDegree)
                .set(department).equalToWhenPresent(record::getDepartment)
                .set(category).equalToWhenPresent(record::getCategory)
                .set(position).equalToWhenPresent(record::getPosition)
                .set(entryDate).equalToWhenPresent(record::getEntryDate)
                .set(leader).equalToWhenPresent(record::getLeader)
                .set(leaderId).equalToWhenPresent(record::getLeaderId)
                .where(id, isEqualTo(record::getId))
                .build()
                .execute();
    }
}