package com.lm.tobacco.generated.entity;

import java.util.Date;
import javax.annotation.Generated;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table sign
 */
public class Sign {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: sign.id")
    private Long id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: sign.empl_id")
    private Long emplId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: sign.address")
    private String address;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: sign.date")
    private Date date;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: sign.photo_name")
    private String photoName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: sign.id")
    public Long getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: sign")
    public Sign withId(Long id) {
        this.setId(id);
        return this;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: sign.id")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: sign.empl_id")
    public Long getEmplId() {
        return emplId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: sign")
    public Sign withEmplId(Long emplId) {
        this.setEmplId(emplId);
        return this;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: sign.empl_id")
    public void setEmplId(Long emplId) {
        this.emplId = emplId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: sign.address")
    public String getAddress() {
        return address;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: sign")
    public Sign withAddress(String address) {
        this.setAddress(address);
        return this;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: sign.address")
    public void setAddress(String address) {
        this.address = address;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: sign.date")
    public Date getDate() {
        return date;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: sign")
    public Sign withDate(Date date) {
        this.setDate(date);
        return this;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: sign.date")
    public void setDate(Date date) {
        this.date = date;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: sign.photo_name")
    public String getPhotoName() {
        return photoName;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: sign")
    public Sign withPhotoName(String photoName) {
        this.setPhotoName(photoName);
        return this;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source field: sign.photo_name")
    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    @Override
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", comments="Source Table: sign")
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", emplId=").append(emplId);
        sb.append(", address=").append(address);
        sb.append(", date=").append(date);
        sb.append(", photoName=").append(photoName);
        sb.append("]");
        return sb.toString();
    }
}