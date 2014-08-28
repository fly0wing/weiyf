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
 * Created by gencode on 2014-8-27 14:11:57.
 */
public class PartyContentType implements Serializable {
    private static final long serialVersionUID = 5454155825314635342L;

    /**
     * db_column: party_content_type_id
     * remarks from db:当事人内容类型标识
     */
    private String partyContentTypeId;
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

	public PartyContentType() {
	}

	public PartyContentType(
		String partyContentTypeId
	) {
		this.partyContentTypeId = partyContentTypeId;
	}

	public void setPartyContentTypeId(String value) {
		this.partyContentTypeId = value;
	}

	public String getPartyContentTypeId() {
		return this.partyContentTypeId;
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


	private Set partyContentTypes = new HashSet(0);
	public void setPartyContentTypes(Set<PartyContentType> partyContentType){
		this.partyContentTypes = partyContentType;
	}

	public Set<PartyContentType> getPartyContentTypes() {
		return partyContentTypes;
	}

	private Set partyContents = new HashSet(0);
	public void setPartyContents(Set<PartyContent> partyContent){
		this.partyContents = partyContent;
	}

	public Set<PartyContent> getPartyContents() {
		return partyContents;
	}

	private PartyContentType partyContentType;

	public void setPartyContentType(PartyContentType partyContentType){
		this.partyContentType = partyContentType;
	}

	public PartyContentType getPartyContentType() {
		return partyContentType;
	}

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getPartyContentTypeId())
            .toHashCode();
    }

    public boolean equals(Object obj) {
        if(obj instanceof PartyContentType == false) return false;
        if(this == obj) return true;
        PartyContentType other = (PartyContentType)obj;
        return new EqualsBuilder()
            .append(getPartyContentTypeId(),other.getPartyContentTypeId())
            .isEquals();
    }

}