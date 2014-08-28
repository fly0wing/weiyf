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
public class StatusType implements Serializable {
    private static final long serialVersionUID = 5454155825314635342L;

    /**
     * db_column: status_type_id
     * remarks from db:状态类型标识
     */
    private String statusTypeId;
    /**
     * db_column: parent_type_id
     */
    private String parentTypeId;
    /**
     * db_column: description
     */
    private String description;
    /**
     * db_column: forbidden_mode_enum_id
     * remarks from db:禁止模式
     */
    private Long forbiddenModeEnumId;
    /**
     * db_column: last_updated_stamp
     */
    private Timestamp lastUpdatedStamp;
    /**
     * db_column: created_stamp
     */
    private Timestamp createdStamp;

	public StatusType() {
	}

	public StatusType(
		String statusTypeId
	) {
		this.statusTypeId = statusTypeId;
	}

	public void setStatusTypeId(String value) {
		this.statusTypeId = value;
	}

	public String getStatusTypeId() {
		return this.statusTypeId;
	}

	public void setParentTypeId(String value) {
		this.parentTypeId = value;
	}

	public String getParentTypeId() {
		return this.parentTypeId;
	}

	public void setDescription(String value) {
		this.description = value;
	}

	public String getDescription() {
		return this.description;
	}

	public void setForbiddenModeEnumId(Long value) {
		this.forbiddenModeEnumId = value;
	}

	public Long getForbiddenModeEnumId() {
		return this.forbiddenModeEnumId;
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


	private Set statusItems = new HashSet(0);
	public void setStatusItems(Set<StatusItem> statusItem){
		this.statusItems = statusItem;
	}

	public Set<StatusItem> getStatusItems() {
		return statusItems;
	}

	private Set statusTypes = new HashSet(0);
	public void setStatusTypes(Set<StatusType> statusType){
		this.statusTypes = statusType;
	}

	public Set<StatusType> getStatusTypes() {
		return statusTypes;
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
            .append(getStatusTypeId())
            .toHashCode();
    }

    public boolean equals(Object obj) {
        if(obj instanceof StatusType == false) return false;
        if(this == obj) return true;
        StatusType other = (StatusType)obj;
        return new EqualsBuilder()
            .append(getStatusTypeId(),other.getStatusTypeId())
            .isEquals();
    }

}