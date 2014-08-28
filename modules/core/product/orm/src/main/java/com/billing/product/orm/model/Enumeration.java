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
 * Created by gencode on 2014-8-27 14:11:51.
 */
public class Enumeration implements Serializable {
    private static final long serialVersionUID = 5454155825314635342L;

    /**
     * db_column: enum_id
     * remarks from db:枚举标识
     */
    private Integer enumId;
    /**
     * db_column: enum_type_id
     * remarks from db:枚举类型标识
     */
    private String enumTypeId;
    /**
     * db_column: enum_code
     * remarks from db:枚举编码
     */
    private String enumCode;
    /**
     * db_column: sequence_id
     * remarks from db:序号
     */
    private String sequenceId;
    /**
     * db_column: description
     */
    private String description;
    /**
     * db_column: last_updated_stamp
     */
    private Timestamp lastUpdatedStamp;
    /**
     * db_column: created_stamp
     */
    private Timestamp createdStamp;

	public Enumeration() {
	}

	public Enumeration(
		Integer enumId
	) {
		this.enumId = enumId;
	}

	public void setEnumId(Integer value) {
		this.enumId = value;
	}

	public Integer getEnumId() {
		return this.enumId;
	}

	public void setEnumTypeId(String value) {
		this.enumTypeId = value;
	}

	public String getEnumTypeId() {
		return this.enumTypeId;
	}

	public void setEnumCode(String value) {
		this.enumCode = value;
	}

	public String getEnumCode() {
		return this.enumCode;
	}

	public void setSequenceId(String value) {
		this.sequenceId = value;
	}

	public String getSequenceId() {
		return this.sequenceId;
	}

	public void setDescription(String value) {
		this.description = value;
	}

	public String getDescription() {
		return this.description;
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


	private EnumerationType enumerationType;

	public void setEnumerationType(EnumerationType enumerationType){
		this.enumerationType = enumerationType;
	}

	public EnumerationType getEnumerationType() {
		return enumerationType;
	}

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getEnumId())
            .toHashCode();
    }

    public boolean equals(Object obj) {
        if(obj instanceof Enumeration == false) return false;
        if(this == obj) return true;
        Enumeration other = (Enumeration)obj;
        return new EqualsBuilder()
            .append(getEnumId(),other.getEnumId())
            .isEquals();
    }

}