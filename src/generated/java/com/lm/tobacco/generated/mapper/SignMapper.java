package com.lm.tobacco.generated.mapper;

import static com.lm.tobacco.generated.mapper.SignDynamicSqlSupport.address;
import static com.lm.tobacco.generated.mapper.SignDynamicSqlSupport.date;
import static com.lm.tobacco.generated.mapper.SignDynamicSqlSupport.emplId;
import static com.lm.tobacco.generated.mapper.SignDynamicSqlSupport.id;
import static com.lm.tobacco.generated.mapper.SignDynamicSqlSupport.photoName;
import static com.lm.tobacco.generated.mapper.SignDynamicSqlSupport.sign;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import com.lm.tobacco.generated.entity.Sign;
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
public interface SignMapper {
  @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", comments = "Source Table: sign")
  @SelectProvider(type = SqlProviderAdapter.class, method = "select")
  long count(SelectStatementProvider selectStatement);

  @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", comments = "Source Table: sign")
  @DeleteProvider(type = SqlProviderAdapter.class, method = "delete")
  int delete(DeleteStatementProvider deleteStatement);

  @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", comments = "Source Table: sign")
  @InsertProvider(type = SqlProviderAdapter.class, method = "insert")
  @Options(useGeneratedKeys = true, keyProperty = "record.id")
  int insert(InsertStatementProvider<Sign> insertStatement);

  @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", comments = "Source Table: sign")
  @SelectProvider(type = SqlProviderAdapter.class, method = "select")
  @ResultMap("SignResult")
  Sign selectOne(SelectStatementProvider selectStatement);

  @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", comments = "Source Table: sign")
  @SelectProvider(type = SqlProviderAdapter.class, method = "select")
  @Results(
      id = "SignResult",
      value = {
        @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
        @Result(column = "empl_id", property = "emplId", jdbcType = JdbcType.BIGINT),
        @Result(column = "address", property = "address", jdbcType = JdbcType.VARCHAR),
        @Result(column = "date", property = "date", jdbcType = JdbcType.DATE),
        @Result(column = "photo_name", property = "photoName", jdbcType = JdbcType.VARCHAR)
      })
  List<Sign> selectMany(SelectStatementProvider selectStatement);

  @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", comments = "Source Table: sign")
  @UpdateProvider(type = SqlProviderAdapter.class, method = "update")
  int update(UpdateStatementProvider updateStatement);

  @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", comments = "Source Table: sign")
  default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
    return SelectDSL.selectWithMapper(this::count, SqlBuilder.count()).from(sign);
  }

  @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", comments = "Source Table: sign")
  default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
    return DeleteDSL.deleteFromWithMapper(this::delete, sign);
  }

  @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", comments = "Source Table: sign")
  default int deleteByPrimaryKey(Long id_) {
    return DeleteDSL.deleteFromWithMapper(this::delete, sign)
        .where(id, isEqualTo(id_))
        .build()
        .execute();
  }

  @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", comments = "Source Table: sign")
  default int insert(Sign record) {
    return insert(
        SqlBuilder.insert(record)
            .into(sign)
            .map(emplId)
            .toProperty("emplId")
            .map(address)
            .toProperty("address")
            .map(date)
            .toProperty("date")
            .map(photoName)
            .toProperty("photoName")
            .build()
            .render(RenderingStrategy.MYBATIS3));
  }

  @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", comments = "Source Table: sign")
  default int insertSelective(Sign record) {
    return insert(
        SqlBuilder.insert(record)
            .into(sign)
            .map(emplId)
            .toPropertyWhenPresent("emplId", record::getEmplId)
            .map(address)
            .toPropertyWhenPresent("address", record::getAddress)
            .map(date)
            .toPropertyWhenPresent("date", record::getDate)
            .map(photoName)
            .toPropertyWhenPresent("photoName", record::getPhotoName)
            .build()
            .render(RenderingStrategy.MYBATIS3));
  }

  @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", comments = "Source Table: sign")
  default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<Sign>>> selectByExample() {
    return SelectDSL.selectWithMapper(this::selectMany, id, emplId, address, date, photoName)
        .from(sign);
  }

  @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", comments = "Source Table: sign")
  default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<Sign>>> selectDistinctByExample() {
    return SelectDSL.selectDistinctWithMapper(
            this::selectMany, id, emplId, address, date, photoName)
        .from(sign);
  }

  @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", comments = "Source Table: sign")
  default Sign selectByPrimaryKey(Long id_) {
    return SelectDSL.selectWithMapper(this::selectOne, id, emplId, address, date, photoName)
        .from(sign)
        .where(id, isEqualTo(id_))
        .build()
        .execute();
  }

  @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", comments = "Source Table: sign")
  default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(Sign record) {
    return UpdateDSL.updateWithMapper(this::update, sign)
        .set(emplId)
        .equalTo(record::getEmplId)
        .set(address)
        .equalTo(record::getAddress)
        .set(date)
        .equalTo(record::getDate)
        .set(photoName)
        .equalTo(record::getPhotoName);
  }

  @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", comments = "Source Table: sign")
  default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(Sign record) {
    return UpdateDSL.updateWithMapper(this::update, sign)
        .set(emplId)
        .equalToWhenPresent(record::getEmplId)
        .set(address)
        .equalToWhenPresent(record::getAddress)
        .set(date)
        .equalToWhenPresent(record::getDate)
        .set(photoName)
        .equalToWhenPresent(record::getPhotoName);
  }

  @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", comments = "Source Table: sign")
  default int updateByPrimaryKey(Sign record) {
    return UpdateDSL.updateWithMapper(this::update, sign)
        .set(emplId)
        .equalTo(record::getEmplId)
        .set(address)
        .equalTo(record::getAddress)
        .set(date)
        .equalTo(record::getDate)
        .set(photoName)
        .equalTo(record::getPhotoName)
        .where(id, isEqualTo(record::getId))
        .build()
        .execute();
  }

  @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", comments = "Source Table: sign")
  default int updateByPrimaryKeySelective(Sign record) {
    return UpdateDSL.updateWithMapper(this::update, sign)
        .set(emplId)
        .equalToWhenPresent(record::getEmplId)
        .set(address)
        .equalToWhenPresent(record::getAddress)
        .set(date)
        .equalToWhenPresent(record::getDate)
        .set(photoName)
        .equalToWhenPresent(record::getPhotoName)
        .where(id, isEqualTo(record::getId))
        .build()
        .execute();
  }
}
