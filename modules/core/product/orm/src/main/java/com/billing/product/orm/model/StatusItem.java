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
 * Created by gencode on 2014-8-27 14:12:07.
 */
public class StatusItem implements Serializable {
    private static final long serialVersionUID = 5454155825314635342L;

    /**
     * db_column: status_id
     * remarks from db:状态标识
     */
    private Long statusId;
    /**
     * db_column: status_type_id
     * remarks from db:状态类型标识
     */
    private String statusTypeId;
    /**
     * db_column: status_code
     * remarks from db:状态代码
     */
    private String statusCode;
    /**
     * db_column: sequence_id
     * remarks from db:状态序号
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

	public StatusItem() {
	}

	public StatusItem(
		Long statusId
	) {
		this.statusId = statusId;
	}

	public void setStatusId(Long value) {
		this.statusId = value;
	}

	public Long getStatusId() {
		return this.statusId;
	}

	public void setStatusTypeId(String value) {
		this.statusTypeId = value;
	}

	public String getStatusTypeId() {
		return this.statusTypeId;
	}

	public void setStatusCode(String value) {
		this.statusCode = value;
	}

	public String getStatusCode() {
		return this.statusCode;
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


	private StatusType statusType;

	public void setStatusType(StatusType statusType){
		this.statusType = statusType;
	}

	public StatusType getStatusType() {
		return statusType;
	}

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getStatusId())
            .toHashCode();
    }

    public boolean equals(Object obj) {
        if(obj instanceof StatusItem == false) return false;
        if(this == obj) return true;
        StatusItem other = (StatusItem)obj;
        return new EqualsBuilder()
            .append(getStatusId(),other.getStatusId())
            .isEquals();
    }

}