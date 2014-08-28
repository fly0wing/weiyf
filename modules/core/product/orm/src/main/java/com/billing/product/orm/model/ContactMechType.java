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
 * Created by gencode on 2014-8-27 14:11:49.
 */
public class ContactMechType implements Serializable {
    private static final long serialVersionUID = 5454155825314635342L;

    /**
     * db_column: contact_mech_type_id
     * remarks from db:联系机制类型标识
     */
    private String contactMechTypeId;
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

	public ContactMechType() {
	}

	public ContactMechType(
		String contactMechTypeId
	) {
		this.contactMechTypeId = contactMechTypeId;
	}

	public void setContactMechTypeId(String value) {
		this.contactMechTypeId = value;
	}

	public String getContactMechTypeId() {
		return this.contactMechTypeId;
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


	private Set contactMechs = new HashSet(0);
	public void setContactMechs(Set<ContactMech> contactMech){
		this.contactMechs = contactMech;
	}

	public Set<ContactMech> getContactMechs() {
		return contactMechs;
	}

	private Set contactMechTypes = new HashSet(0);
	public void setContactMechTypes(Set<ContactMechType> contactMechType){
		this.contactMechTypes = contactMechType;
	}

	public Set<ContactMechType> getContactMechTypes() {
		return contactMechTypes;
	}

	private ContactMechType contactMechType;

	public void setContactMechType(ContactMechType contactMechType){
		this.contactMechType = contactMechType;
	}

	public ContactMechType getContactMechType() {
		return contactMechType;
	}

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getContactMechTypeId())
            .toHashCode();
    }

    public boolean equals(Object obj) {
        if(obj instanceof ContactMechType == false) return false;
        if(this == obj) return true;
        ContactMechType other = (ContactMechType)obj;
        return new EqualsBuilder()
            .append(getContactMechTypeId(),other.getContactMechTypeId())
            .isEquals();
    }

}