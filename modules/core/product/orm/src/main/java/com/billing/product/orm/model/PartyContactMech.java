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
 * Created by gencode on 2014-8-27 14:11:55.
 */
public class PartyContactMech implements Serializable {
    private static final long serialVersionUID = 5454155825314635342L;

    /**
     * db_column: id
     */
    private Long id;
    /**
     * db_column: party_id
     * remarks from db:当事人标识
     */
    private Long partyId;
    /**
     * db_column: contact_mech_id
     * remarks from db:联系机制标识
     */
    private Long contactMechId;
    /**
     * db_column: from_date
     * remarks from db:开始日期
     */
    private Timestamp fromDate;
    /**
     * db_column: thru_date
     * remarks from db:截止日期
     */
    private Timestamp thruDate;
    /**
     * db_column: role_type_id
     * remarks from db:角色类型标识
     */
    private String roleTypeId;
    /**
     * db_column: allow_solicitation
     * remarks from db:同意请求
     */
    private Boolean allowSolicitation;
    /**
     * db_column: extension
     * remarks from db:扩展
     */
    private String extension;
    /**
     * db_column: verified
     * remarks from db:已验证
     */
    private String verified;
    /**
     * db_column: comments
     * remarks from db:备注
     */
    private String comments;
    /**
     * db_column: years_with_contact_mech
     * remarks from db:联系方式的年数
     */
    private BigDecimal yearsWithContactMech;
    /**
     * db_column: months_with_contact_mech
     * remarks from db:联系方式的月数
     */
    private BigDecimal monthsWithContactMech;
    /**
     * db_column: last_updated_stamp
     */
    private Timestamp lastUpdatedStamp;
    /**
     * db_column: created_stamp
     */
    private Timestamp createdStamp;

	public PartyContactMech() {
	}

	public PartyContactMech(
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

	public void setPartyId(Long value) {
		this.partyId = value;
	}

	public Long getPartyId() {
		return this.partyId;
	}

	public void setContactMechId(Long value) {
		this.contactMechId = value;
	}

	public Long getContactMechId() {
		return this.contactMechId;
	}

	public String getFromDateString() {
		return DateConvertUtils.format(getFromDate(), DateConvertUtils.DATE_FORMAT);
	}

	public void setFromDateString(String value) {
		setFromDate(DateConvertUtils.parse(value, DateConvertUtils.DATE_FORMAT,Timestamp.class));
	}

	public void setFromDate(Timestamp value) {
		this.fromDate = value;
	}

	public Timestamp getFromDate() {
		return this.fromDate;
	}

	public String getThruDateString() {
		return DateConvertUtils.format(getThruDate(), DateConvertUtils.DATE_FORMAT);
	}

	public void setThruDateString(String value) {
		setThruDate(DateConvertUtils.parse(value, DateConvertUtils.DATE_FORMAT,Timestamp.class));
	}

	public void setThruDate(Timestamp value) {
		this.thruDate = value;
	}

	public Timestamp getThruDate() {
		return this.thruDate;
	}

	public void setRoleTypeId(String value) {
		this.roleTypeId = value;
	}

	public String getRoleTypeId() {
		return this.roleTypeId;
	}

	public void setAllowSolicitation(Boolean value) {
		this.allowSolicitation = value;
	}

	public Boolean getAllowSolicitation() {
		return this.allowSolicitation;
	}

	public void setExtension(String value) {
		this.extension = value;
	}

	public String getExtension() {
		return this.extension;
	}

	public void setVerified(String value) {
		this.verified = value;
	}

	public String getVerified() {
		return this.verified;
	}

	public void setComments(String value) {
		this.comments = value;
	}

	public String getComments() {
		return this.comments;
	}

	public void setYearsWithContactMech(BigDecimal value) {
		this.yearsWithContactMech = value;
	}

	public BigDecimal getYearsWithContactMech() {
		return this.yearsWithContactMech;
	}

	public void setMonthsWithContactMech(BigDecimal value) {
		this.monthsWithContactMech = value;
	}

	public BigDecimal getMonthsWithContactMech() {
		return this.monthsWithContactMech;
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
            .append(getId())
            .toHashCode();
    }

    public boolean equals(Object obj) {
        if(obj instanceof PartyContactMech == false) return false;
        if(this == obj) return true;
        PartyContactMech other = (PartyContactMech)obj;
        return new EqualsBuilder()
            .append(getId(),other.getId())
            .isEquals();
    }

}