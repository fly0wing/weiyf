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
public class EntryType implements Serializable {
    private static final long serialVersionUID = 5454155825314635342L;

    /**
     * db_column: entry_type_id
     * remarks from db:入口类型
     */
    private String entryTypeId;
    /**
     * db_column: description
     */
    private String description;

	public EntryType() {
	}

	public EntryType(
		String entryTypeId
	) {
		this.entryTypeId = entryTypeId;
	}

	public void setEntryTypeId(String value) {
		this.entryTypeId = value;
	}

	public String getEntryTypeId() {
		return this.entryTypeId;
	}

	public void setDescription(String value) {
		this.description = value;
	}

	public String getDescription() {
		return this.description;
	}


    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getEntryTypeId())
            .toHashCode();
    }

    public boolean equals(Object obj) {
        if(obj instanceof EntryType == false) return false;
        if(this == obj) return true;
        EntryType other = (EntryType)obj;
        return new EqualsBuilder()
            .append(getEntryTypeId(),other.getEntryTypeId())
            .isEquals();
    }

}