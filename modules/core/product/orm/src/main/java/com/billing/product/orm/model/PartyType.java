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
 * Created by gencode on 2014-8-27 14:11:59.
 */
public class PartyType implements Serializable {
    private static final long serialVersionUID = 5454155825314635342L;

    /**
     * db_column: party_type_id
     * remarks from db:当事人类型标识
     */
    private String partyTypeId;
    /**
     * db_column: parent_type_id
     * remarks from db:父类型标识
     */
    private String parentTypeId;
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

	public PartyType() {
	}

	public PartyType(
		String partyTypeId
	) {
		this.partyTypeId = partyTypeId;
	}

	public void setPartyTypeId(String value) {
		this.partyTypeId = value;
	}

	public String getPartyTypeId() {
		return this.partyTypeId;
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


	private Set partyTypes = new HashSet(0);
	public void setPartyTypes(Set<PartyType> partyType){
		this.partyTypes = partyType;
	}

	public Set<PartyType> getPartyTypes() {
		return partyTypes;
	}

	private PartyType partyType;

	public void setPartyType(PartyType partyType){
		this.partyType = partyType;
	}

	public PartyType getPartyType() {
		return partyType;
	}

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getPartyTypeId())
            .toHashCode();
    }

    public boolean equals(Object obj) {
        if(obj instanceof PartyType == false) return false;
        if(this == obj) return true;
        PartyType other = (PartyType)obj;
        return new EqualsBuilder()
            .append(getPartyTypeId(),other.getPartyTypeId())
            .isEquals();
    }

}