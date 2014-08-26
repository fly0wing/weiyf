package com.billing.user.orm.model;

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
 * Created by gencode on 2014-8-26 16:12:40.
 */
public class CustomerSession implements Serializable {
    private static final long serialVersionUID = 5454155825314635342L;

    /**
     * db_column: id
     * remarks from db:会话标识
     */
    private Long id;
    /**
     * db_column: customer_id
     * remarks from db:用户标识
     */
    private Long customerId;
    /**
     * db_column: party_id
     * remarks from db:商户标识
     */
    private Long partyId;
    /**
     * db_column: product_id
     * remarks from db:产品标识
     */
    private Long productId;
    /**
     * db_column: domain_id
     * remarks from db:应用域标识
     */
    private String domainId;
    /**
     * db_column: app_id
     * remarks from db:应用标识
     */
    private Long appId;
    /**
     * db_column: entry_id
     * remarks from db:入口标识
     */
    private Long entryId;
    /**
     * db_column: geo_id
     * remarks from db:地理标识
     */
    private Long geoId;
    /**
     * db_column: app_area
     * remarks from db:应用分区
     */
    private String appArea;
    /**
     * db_column: is_anonymous
     * remarks from db:是否匿名
     */
    private Boolean isAnonymous;
    /**
     * db_column: create_time
     * remarks from db:最后登录时间
     */
    private Timestamp createTime;

	public CustomerSession() {
	}

	public CustomerSession(
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

	public void setCustomerId(Long value) {
		this.customerId = value;
	}

	public Long getCustomerId() {
		return this.customerId;
	}

	public void setPartyId(Long value) {
		this.partyId = value;
	}

	public Long getPartyId() {
		return this.partyId;
	}

	public void setProductId(Long value) {
		this.productId = value;
	}

	public Long getProductId() {
		return this.productId;
	}

	public void setDomainId(String value) {
		this.domainId = value;
	}

	public String getDomainId() {
		return this.domainId;
	}

	public void setAppId(Long value) {
		this.appId = value;
	}

	public Long getAppId() {
		return this.appId;
	}

	public void setEntryId(Long value) {
		this.entryId = value;
	}

	public Long getEntryId() {
		return this.entryId;
	}

	public void setGeoId(Long value) {
		this.geoId = value;
	}

	public Long getGeoId() {
		return this.geoId;
	}

	public void setAppArea(String value) {
		this.appArea = value;
	}

	public String getAppArea() {
		return this.appArea;
	}

	public void setIsAnonymous(Boolean value) {
		this.isAnonymous = value;
	}

	public Boolean getIsAnonymous() {
		return this.isAnonymous;
	}

	public String getCreateTimeString() {
		return DateConvertUtils.format(getCreateTime(), DateConvertUtils.DATE_FORMAT);
	}

	public void setCreateTimeString(String value) {
		setCreateTime(DateConvertUtils.parse(value, DateConvertUtils.DATE_FORMAT,Timestamp.class));
	}

	public void setCreateTime(Timestamp value) {
		this.createTime = value;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
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
        if(obj instanceof CustomerSession == false) return false;
        if(this == obj) return true;
        CustomerSession other = (CustomerSession)obj;
        return new EqualsBuilder()
            .append(getId(),other.getId())
            .isEquals();
    }

}