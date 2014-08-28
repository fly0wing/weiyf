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
 * Created by gencode on 2014-8-27 14:12:08.
 */
public class StatusValidChange implements Serializable {
    private static final long serialVersionUID = 5454155825314635342L;

    /**
     * db_column: status_id
     * remarks from db:源状态标识
     */
    private Long statusId;
    /**
     * db_column: status_id_to
     * remarks from db:目标状态标识
     */
    private Long statusIdTo;
    /**
     * db_column: is_forbidden
     * remarks from db:是否禁止
     */
    private Boolean isForbidden;
    /**
     * db_column: transition_name
     * remarks from db:转变名称
     */
    private String transitionName;
    /**
     * db_column: description
     * remarks from db:描述
     */
    private String description;
    /**
     * db_column: condition_expression
     * remarks from db:条件表达式
     */
    private String conditionExpression;
    /**
     * db_column: last_updated_stamp
     */
    private Timestamp lastUpdatedStamp;
    /**
     * db_column: created_stamp
     */
    private Timestamp createdStamp;

	public StatusValidChange() {
	}

	public StatusValidChange(
		Long statusId,
		Long statusIdTo
	) {
		this.statusId = statusId;
		this.statusIdTo = statusIdTo;
	}

	public void setStatusId(Long value) {
		this.statusId = value;
	}

	public Long getStatusId() {
		return this.statusId;
	}

	public void setStatusIdTo(Long value) {
		this.statusIdTo = value;
	}

	public Long getStatusIdTo() {
		return this.statusIdTo;
	}

	public void setIsForbidden(Boolean value) {
		this.isForbidden = value;
	}

	public Boolean getIsForbidden() {
		return this.isForbidden;
	}

	public void setTransitionName(String value) {
		this.transitionName = value;
	}

	public String getTransitionName() {
		return this.transitionName;
	}

	public void setDescription(String value) {
		this.description = value;
	}

	public String getDescription() {
		return this.description;
	}

	public void setConditionExpression(String value) {
		this.conditionExpression = value;
	}

	public String getConditionExpression() {
		return this.conditionExpression;
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


    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getStatusId())
            .append(getStatusIdTo())
            .toHashCode();
    }

    public boolean equals(Object obj) {
        if(obj instanceof StatusValidChange == false) return false;
        if(this == obj) return true;
        StatusValidChange other = (StatusValidChange)obj;
        return new EqualsBuilder()
            .append(getStatusId(),other.getStatusId())
            .append(getStatusIdTo(),other.getStatusIdTo())
            .isEquals();
    }

}