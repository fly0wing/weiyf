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
 * Created by gencode on 2014-8-27 14:11:47.
 */
public class AppCategory implements Serializable {
    private static final long serialVersionUID = 5454155825314635342L;

    /**
     * db_column: app_category_id
     * remarks from db:应用分类标识
     */
    private Long appCategoryId;
    /**
     * db_column: app_category_type_id
     * remarks from db:应用分类类型标识
     */
    private Long appCategoryTypeId;
    /**
     * db_column: parent_category_id
     * remarks from db:父分类标识
     */
    private Long parentCategoryId;
    /**
     * db_column: party_id
     * remarks from db:商户标识
     */
    private Long partyId;
    /**
     * db_column: description
     */
    private String description;
    /**
     * db_column: show_in_select
     */
    private Boolean showInSelect;
    /**
     * db_column: statust_id
     * remarks from db:状态标识
     */
    private Long statustId;
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
     * db_column: last_updated_stamp
     */
    private Timestamp lastUpdatedStamp;
    /**
     * db_column: created_stamp
     */
    private Timestamp createdStamp;

	public AppCategory() {
	}

	public AppCategory(
		Long appCategoryId
	) {
		this.appCategoryId = appCategoryId;
	}

	public void setAppCategoryId(Long value) {
		this.appCategoryId = value;
	}

	public Long getAppCategoryId() {
		return this.appCategoryId;
	}

	public void setAppCategoryTypeId(Long value) {
		this.appCategoryTypeId = value;
	}

	public Long getAppCategoryTypeId() {
		return this.appCategoryTypeId;
	}

	public void setParentCategoryId(Long value) {
		this.parentCategoryId = value;
	}

	public Long getParentCategoryId() {
		return this.parentCategoryId;
	}

	public void setPartyId(Long value) {
		this.partyId = value;
	}

	public Long getPartyId() {
		return this.partyId;
	}

	public void setDescription(String value) {
		this.description = value;
	}

	public String getDescription() {
		return this.description;
	}

	public void setShowInSelect(Boolean value) {
		this.showInSelect = value;
	}

	public Boolean getShowInSelect() {
		return this.showInSelect;
	}

	public void setStatustId(Long value) {
		this.statustId = value;
	}

	public Long getStatustId() {
		return this.statustId;
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
            .append(getAppCategoryId())
            .toHashCode();
    }

    public boolean equals(Object obj) {
        if(obj instanceof AppCategory == false) return false;
        if(this == obj) return true;
        AppCategory other = (AppCategory)obj;
        return new EqualsBuilder()
            .append(getAppCategoryId(),other.getAppCategoryId())
            .isEquals();
    }

}