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
public class Party implements Serializable {
    private static final long serialVersionUID = 5454155825314635342L;

    /**
     * db_column: id
     * remarks from db:当事人标识
     */
    private Long id;
    /**
     * db_column: party_type_id
     * remarks from db:当事人类型标识
     */
    private String partyTypeId;
    /**
     * db_column: external_id
     * remarks from db:外部标识
     */
    private String externalId;
    /**
     * db_column: preferred_currency_uom_id
     * remarks from db:当前货币标识
     */
    private Long preferredCurrencyUomId;
    /**
     * db_column: description
     */
    private String description;
    /**
     * db_column: status_id
     * remarks from db:状态标识
     */
    private Long statusId;
    /**
     * db_column: created_date
     * remarks from db:创建时间
     */
    private Timestamp createdDate;
    /**
     * db_column: created_by_user_login
     * remarks from db:创建者
     */
    private String createdByUserLogin;
    /**
     * db_column: last_modified_date
     * remarks from db:最后修改时间
     */
    private Timestamp lastModifiedDate;
    /**
     * db_column: last_modified_by_user_login
     * remarks from db:最后修改者
     */
    private String lastModifiedByUserLogin;
    /**
     * db_column: data_source_id
     * remarks from db:数据源标识
     */
    private String dataSourceId;
    /**
     * db_column: is_unread
     * remarks from db:是否未读
     */
    private Boolean isUnread;
    /**
     * db_column: last_updated_stamp
     */
    private Timestamp lastUpdatedStamp;
    /**
     * db_column: created_stamp
     */
    private Timestamp createdStamp;

	public Party() {
	}

	public Party(
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

	public void setPartyTypeId(String value) {
		this.partyTypeId = value;
	}

	public String getPartyTypeId() {
		return this.partyTypeId;
	}

	public void setExternalId(String value) {
		this.externalId = value;
	}

	public String getExternalId() {
		return this.externalId;
	}

	public void setPreferredCurrencyUomId(Long value) {
		this.preferredCurrencyUomId = value;
	}

	public Long getPreferredCurrencyUomId() {
		return this.preferredCurrencyUomId;
	}

	public void setDescription(String value) {
		this.description = value;
	}

	public String getDescription() {
		return this.description;
	}

	public void setStatusId(Long value) {
		this.statusId = value;
	}

	public Long getStatusId() {
		return this.statusId;
	}

	public String getCreatedDateString() {
		return DateConvertUtils.format(getCreatedDate(), DateConvertUtils.DATE_FORMAT);
	}

	public void setCreatedDateString(String value) {
		setCreatedDate(DateConvertUtils.parse(value, DateConvertUtils.DATE_FORMAT,Timestamp.class));
	}

	public void setCreatedDate(Timestamp value) {
		this.createdDate = value;
	}

	public Timestamp getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedByUserLogin(String value) {
		this.createdByUserLogin = value;
	}

	public String getCreatedByUserLogin() {
		return this.createdByUserLogin;
	}

	public String getLastModifiedDateString() {
		return DateConvertUtils.format(getLastModifiedDate(), DateConvertUtils.DATE_FORMAT);
	}

	public void setLastModifiedDateString(String value) {
		setLastModifiedDate(DateConvertUtils.parse(value, DateConvertUtils.DATE_FORMAT,Timestamp.class));
	}

	public void setLastModifiedDate(Timestamp value) {
		this.lastModifiedDate = value;
	}

	public Timestamp getLastModifiedDate() {
		return this.lastModifiedDate;
	}

	public void setLastModifiedByUserLogin(String value) {
		this.lastModifiedByUserLogin = value;
	}

	public String getLastModifiedByUserLogin() {
		return this.lastModifiedByUserLogin;
	}

	public void setDataSourceId(String value) {
		this.dataSourceId = value;
	}

	public String getDataSourceId() {
		return this.dataSourceId;
	}

	public void setIsUnread(Boolean value) {
		this.isUnread = value;
	}

	public Boolean getIsUnread() {
		return this.isUnread;
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


	private Set apps = new HashSet(0);
	public void setApps(Set<App> app){
		this.apps = app;
	}

	public Set<App> getApps() {
		return apps;
	}

	private Set partyRoles = new HashSet(0);
	public void setPartyRoles(Set<PartyRole> partyRole){
		this.partyRoles = partyRole;
	}

	public Set<PartyRole> getPartyRoles() {
		return partyRoles;
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
        if(obj instanceof Party == false) return false;
        if(this == obj) return true;
        Party other = (Party)obj;
        return new EqualsBuilder()
            .append(getId(),other.getId())
            .isEquals();
    }

}