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
 * Created by gencode on 2014-8-27 14:11:48.
 */
public class ContactMech implements Serializable {
    private static final long serialVersionUID = 5454155825314635342L;

    /**
     * db_column: id
     * remarks from db:联系机制标识
     */
    private Long id;
    /**
     * db_column: contact_mech_type_id
     * remarks from db:联系机制类型标识
     */
    private String contactMechTypeId;
    /**
     * db_column: string_info
     * remarks from db:联系信息
     */
    private String stringInfo;
    /**
     * db_column: contact_name
     * remarks from db:联系名称
     */
    private String contactName;
    /**
     * db_column: contact_phone_area
     * remarks from db:电话区号
     */
    private String contactPhoneArea;
    /**
     * db_column: contact_phone
     * remarks from db:电话
     */
    private Long contactPhone;
    /**
     * db_column: contact_phone1_area
     * remarks from db:电话1区号
     */
    private String contactPhone1Area;
    /**
     * db_column: contact_phone1
     * remarks from db:电话1
     */
    private Long contactPhone1;
    /**
     * db_column: contact_qq
     * remarks from db:QQ号
     */
    private Long contactQq;
    /**
     * db_column: last_updated_stamp
     */
    private Timestamp lastUpdatedStamp;
    /**
     * db_column: created_stamp
     */
    private Timestamp createdStamp;

	public ContactMech() {
	}

	public ContactMech(
		Long id
	) {
		this.id = id;
	}

	public void setId(Long value) {
		this.id = value;
	}

	public Long getId() {
		return this.id;
	}

	public void setContactMechTypeId(String value) {
		this.contactMechTypeId = value;
	}

	public String getContactMechTypeId() {
		return this.contactMechTypeId;
	}

	public void setStringInfo(String value) {
		this.stringInfo = value;
	}

	public String getStringInfo() {
		return this.stringInfo;
	}

	public void setContactName(String value) {
		this.contactName = value;
	}

	public String getContactName() {
		return this.contactName;
	}

	public void setContactPhoneArea(String value) {
		this.contactPhoneArea = value;
	}

	public String getContactPhoneArea() {
		return this.contactPhoneArea;
	}

	public void setContactPhone(Long value) {
		this.contactPhone = value;
	}

	public Long getContactPhone() {
		return this.contactPhone;
	}

	public void setContactPhone1Area(String value) {
		this.contactPhone1Area = value;
	}

	public String getContactPhone1Area() {
		return this.contactPhone1Area;
	}

	public void setContactPhone1(Long value) {
		this.contactPhone1 = value;
	}

	public Long getContactPhone1() {
		return this.contactPhone1;
	}

	public void setContactQq(Long value) {
		this.contactQq = value;
	}

	public Long getContactQq() {
		return this.contactQq;
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


	private Set contactMechFinances = new HashSet(0);
	public void setContactMechFinances(Set<ContactMechFinance> contactMechFinance){
		this.contactMechFinances = contactMechFinance;
	}

	public Set<ContactMechFinance> getContactMechFinances() {
		return contactMechFinances;
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
            .append(getId())
            .toHashCode();
    }

    public boolean equals(Object obj) {
        if(obj instanceof ContactMech == false) return false;
        if(this == obj) return true;
        ContactMech other = (ContactMech)obj;
        return new EqualsBuilder()
            .append(getId(),other.getId())
            .isEquals();
    }

}