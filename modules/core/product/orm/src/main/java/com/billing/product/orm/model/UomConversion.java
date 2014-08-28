package com.billing.product.orm.model;

import java.io.Serializable;
import java.util.Date;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.billing.utils.date.DateConvertUtils;

/**
 * Created by gencode on 2014-8-27 14:12:09.
 */
public class UomConversion implements Serializable {
    private static final long serialVersionUID = 5454155825314635342L;

    /**
     * db_column: uom_id
     * remarks from db:源单位标识
     */
    private String uomId;
    /**
     * db_column: uom_id_to
     * remarks from db:目标单位标识
     */
    private String uomIdTo;
    /**
     * db_column: conversion_factor
     * remarks from db:转换系数
     */
    private Double conversionFactor;
    /**
     * db_column: decimal_scale
     * remarks from db:精度
     */
    private BigDecimal decimalScale;
    /**
     * db_column: rounding_mode
     * remarks from db:舍入模式
     */
    private String roundingMode;
    /**
     * db_column: statust_id
     * remarks from db:状态标识
     */
    private Long statustId;
    /**
     * db_column: created_date
     * remarks from db:创建时间
     */
    private Timestamp createdDate;
    /**
     * db_column: created_by_user_login
     * remarks from db:创建者
     */
    private String createdByUserLogin;
    /**
     * db_column: last_modified_date
     * remarks from db:最后修改时间
     */
    private Timestamp lastModifiedDate;
    /**
     * db_column: last_modified_by_user_login
     * remarks from db:最后修改者
     */
    private String lastModifiedByUserLogin;
    /**
     * db_column: last_updated_stamp
     */
    private Timestamp lastUpdatedStamp;
    /**
     * db_column: created_stamp
     */
    private Timestamp createdStamp;

	public UomConversion() {
	}

	public UomConversion(
		String uomId,
		String uomIdTo
	) {
		this.uomId = uomId;
		this.uomIdTo = uomIdTo;
	}

	public void setUomId(String value) {
		this.uomId = value;
	}

	public String getUomId() {
		return this.uomId;
	}

	public void setUomIdTo(String value) {
		this.uomIdTo = value;
	}

	public String getUomIdTo() {
		return this.uomIdTo;
	}

	public void setConversionFactor(Double value) {
		this.conversionFactor = value;
	}

	public Double getConversionFactor() {
		return this.conversionFactor;
	}

	public void setDecimalScale(BigDecimal value) {
		this.decimalScale = value;
	}

	public BigDecimal getDecimalScale() {
		return this.decimalScale;
	}

	public void setRoundingMode(String value) {
		this.roundingMode = value;
	}

	public String getRoundingMode() {
		return this.roundingMode;
	}

	public void setStatustId(Long value) {
		this.statustId = value;
	}

	public Long getStatustId() {
		return this.statustId;
	}

	public String getCreatedDateString() {
		return DateConvertUtils.format(getCreatedDate(), DateConvertUtils.DATE_FORMAT);
	}

	public void setCreatedDateString(String value) {
		setCreatedDate(DateConvertUtils.parse(value, DateConvertUtils.DATE_FORMAT,Timestamp.class));
	}

	public void setCreatedDate(Timestamp value) {
		this.createdDate = value;
	}

	public Timestamp getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedByUserLogin(String value) {
		this.createdByUserLogin = value;
	}

	public String getCreatedByUserLogin() {
		return this.createdByUserLogin;
	}

	public String getLastModifiedDateString() {
		return DateConvertUtils.format(getLastModifiedDate(), DateConvertUtils.DATE_FORMAT);
	}

	public void setLastModifiedDateString(String value) {
		setLastModifiedDate(DateConvertUtils.parse(value, DateConvertUtils.DATE_FORMAT,Timestamp.class));
	}

	public void setLastModifiedDate(Timestamp value) {
		this.lastModifiedDate = value;
	}

	public Timestamp getLastModifiedDate() {
		return this.lastModifiedDate;
	}

	public void setLastModifiedByUserLogin(String value) {
		this.lastModifiedByUserLogin = value;
	}

	public String getLastModifiedByUserLogin() {
		return this.lastModifiedByUserLogin;
	}

	public String getLastUpdatedStampString() {
		return DateConvertUtils.format(getLastUpdatedStamp(), DateConvertUtils.DATE_FORMAT);
	}

	public void setLastUpdatedStampString(String value) {
		setLastUpdatedStamp(DateConvertUtils.parse(value, DateConvertUtils.DATE_FORMAT,Timestamp.class));
	}

	public void setLastUpdatedStamp(Timestamp value) {
		this.lastUpdatedStamp = value;
	}

	public Timestamp getLastUpdatedStamp() {
		return this.lastUpdatedStamp;
	}

	public String getCreatedStampString() {
		return DateConvertUtils.format(getCreatedStamp(), DateConvertUtils.DATE_FORMAT);
	}

	public void setCreatedStampString(String value) {
		setCreatedStamp(DateConvertUtils.parse(value, DateConvertUtils.DATE_FORMAT,Timestamp.class));
	}

	public void setCreatedStamp(Timestamp value) {
		this.createdStamp = value;
	}

	public Timestamp getCreatedStamp() {
		return this.createdStamp;
	}


	private Uom uom;

	public void setUom(Uom uom){
		this.uom = uom;
	}

	public Uom getUom() {
		return uom;
	}

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getUomId())
            .append(getUomIdTo())
            .toHashCode();
    }

    public boolean equals(Object obj) {
        if(obj instanceof UomConversion == false) return false;
        if(this == obj) return true;
        UomConversion other = (UomConversion)obj;
        return new EqualsBuilder()
            .append(getUomId(),other.getUomId())
            .append(getUomIdTo(),other.getUomIdTo())
            .isEquals();
    }

}