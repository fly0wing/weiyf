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
 * Created by gencode on 2014-8-27 14:11:50.
 */
public class DiscountActivity implements Serializable {
    private static final long serialVersionUID = 5454155825314635342L;

    /**
     * db_column: id
     * remarks from db:折扣活动标识
     */
    private Long id;
    /**
     * db_column: party_id
     * remarks from db:商户标识
     */
    private Long partyId;
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
     * db_column: product_id
     * remarks from db:产品标识
     */
    private Long productId;
    /**
     * db_column: goods_id
     * remarks from db:商品标识
     */
    private Long goodsId;
    /**
     * db_column: activity_name
     * remarks from db:活动名称
     */
    private String activityName;
    /**
     * db_column: statust_id
     * remarks from db:状态标识
     */
    private Long statustId;
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
     * db_column: description
     * remarks from db:描述
     */
    private String description;
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
     * db_column: created_date
     * remarks from db:创建时间
     */
    private Timestamp createdDate;
    /**
     * db_column: created_by_user_login
     * remarks from db:创建者
     */
    private String createdByUserLogin;

	public DiscountActivity() {
	}

	public DiscountActivity(
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

	public void setProductId(Long value) {
		this.productId = value;
	}

	public Long getProductId() {
		return this.productId;
	}

	public void setGoodsId(Long value) {
		this.goodsId = value;
	}

	public Long getGoodsId() {
		return this.goodsId;
	}

	public void setActivityName(String value) {
		this.activityName = value;
	}

	public String getActivityName() {
		return this.activityName;
	}

	public void setStatustId(Long value) {
		this.statustId = value;
	}

	public Long getStatustId() {
		return this.statustId;
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

	public void setDescription(String value) {
		this.description = value;
	}

	public String getDescription() {
		return this.description;
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


    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getId())
            .toHashCode();
    }

    public boolean equals(Object obj) {
        if(obj instanceof DiscountActivity == false) return false;
        if(this == obj) return true;
        DiscountActivity other = (DiscountActivity)obj;
        return new EqualsBuilder()
            .append(getId(),other.getId())
            .isEquals();
    }

}