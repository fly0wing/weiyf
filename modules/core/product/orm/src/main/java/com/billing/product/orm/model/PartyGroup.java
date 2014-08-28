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
public class PartyGroup implements Serializable {
    private static final long serialVersionUID = 5454155825314635342L;

    /**
     * db_column: id
     */
    private Long id;
    /**
     * db_column: group_name
     * remarks from db:团体名称
     */
    private String groupName;
    /**
     * db_column: group_name_local
     * remarks from db:团体本地名称
     */
    private String groupNameLocal;
    /**
     * db_column: office_site_name
     * remarks from db:办公地点
     */
    private String officeSiteName;
    /**
     * db_column: annual_revenue
     * remarks from db:年收入
     */
    private Double annualRevenue;
    /**
     * db_column: num_employees
     * remarks from db:员工数
     */
    private Integer numEmployees;
    /**
     * db_column: comments
     */
    private String comments;
    /**
     * db_column: logo_image_url
     * remarks from db:图标URL
     */
    private String logoImageUrl;
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

	public PartyGroup() {
	}

	public PartyGroup(
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

	public void setGroupName(String value) {
		this.groupName = value;
	}

	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupNameLocal(String value) {
		this.groupNameLocal = value;
	}

	public String getGroupNameLocal() {
		return this.groupNameLocal;
	}

	public void setOfficeSiteName(String value) {
		this.officeSiteName = value;
	}

	public String getOfficeSiteName() {
		return this.officeSiteName;
	}

	public void setAnnualRevenue(Double value) {
		this.annualRevenue = value;
	}

	public Double getAnnualRevenue() {
		return this.annualRevenue;
	}

	public void setNumEmployees(Integer value) {
		this.numEmployees = value;
	}

	public Integer getNumEmployees() {
		return this.numEmployees;
	}

	public void setComments(String value) {
		this.comments = value;
	}

	public String getComments() {
		return this.comments;
	}

	public void setLogoImageUrl(String value) {
		this.logoImageUrl = value;
	}

	public String getLogoImageUrl() {
		return this.logoImageUrl;
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


    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getId())
            .toHashCode();
    }

    public boolean equals(Object obj) {
        if(obj instanceof PartyGroup == false) return false;
        if(this == obj) return true;
        PartyGroup other = (PartyGroup)obj;
        return new EqualsBuilder()
            .append(getId(),other.getId())
            .isEquals();
    }

}