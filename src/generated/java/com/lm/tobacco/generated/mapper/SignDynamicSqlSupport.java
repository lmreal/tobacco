package com.lm.tobacco.generated.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class SignDynamicSqlSupport {
  @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", comments = "Source Table: sign")
  public static final Sign sign = new Sign();

  @Generated(
      value = "org.mybatis.generator.api.MyBatisGenerator",
      comments = "Source field: sign.id")
  public static final SqlColumn<Long> id = sign.id;

  @Generated(
      value = "org.mybatis.generator.api.MyBatisGenerator",
      comments = "Source field: sign.empl_id")
  public static final SqlColumn<Long> emplId = sign.emplId;

  @Generated(
      value = "org.mybatis.generator.api.MyBatisGenerator",
      comments = "Source field: sign.address")
  public static final SqlColumn<String> address = sign.address;

  @Generated(
      value = "org.mybatis.generator.api.MyBatisGenerator",
      comments = "Source field: sign.date")
  public static final SqlColumn<Date> date = sign.date;

  @Generated(
      value = "org.mybatis.generator.api.MyBatisGenerator",
      comments = "Source field: sign.photo_name")
  public static final SqlColumn<String> photoName = sign.photoName;

  @Generated(value = "org.mybatis.generator.api.MyBatisGenerator", comments = "Source Table: sign")
  public static final class Sign extends SqlTable {
    public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

    public final SqlColumn<Long> emplId = column("empl_id", JDBCType.BIGINT);

    public final SqlColumn<String> address = column("address", JDBCType.VARCHAR);

    public final SqlColumn<Date> date = column("`date`", JDBCType.DATE);

    public final SqlColumn<String> photoName = column("photo_name", JDBCType.VARCHAR);

    public Sign() {
      super("sign");
    }
  }
}
