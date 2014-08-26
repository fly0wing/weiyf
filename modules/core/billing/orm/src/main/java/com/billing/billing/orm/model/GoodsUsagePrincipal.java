package com.billing.billing.orm.model;

import java.io.Serializable;
import java.util.Date;
import java.sql.Timestamp;
import java.math.BigDecimal;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.billing.utils.date.DateConvertUtils;

/**
 * Created by gencode on 2014-8-26 15:52:59.
 */
public class GoodsUsagePrincipal implements Serializable {
    private static final long serialVersionUID = 5454155825314635342L;

    /**
     * db_column: id
     * remarks from db:商品使用主体标识
     */
    private Long id;
    /**
     * db_column: customer_goods_id
     * remarks from db:用户商品标识
     */
    private Long customerGoodsId;
    /**
     * db_column: customer_id
     * remarks from db:用户标识
     */
    private Long customerId;
    /**
     * db_column: session_id
     * remarks from db:会话标识
     */
    private Long sessionId;
    /**
     * db_column: party_id
     * remarks from db:商户标识
     */
    private Long partyId;
    /**
     * db_column: billing_principal_enum_id
     * remarks from db:计费身份枚举标识
     */
    private Long billingPrincipalEnumId;
    /**
     * db_column: billing_principal_id
     * remarks from db:计费主体
     */
    private String billingPrincipalId;
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
     * db_column: created_date
     * remarks from db:创建时间
     */
    private Timestamp createdDate;
    /**
     * db_column: created_by_user_login
     * remarks from db:创建者
     */
    private String createdByUserLogin;

	public GoodsUsagePrincipal() {
	}

	public GoodsUsagePrincipal(
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

	public void setCustomerGoodsId(Long value) {
		this.customerGoodsId = value;
	}

	public Long getCustomerGoodsId() {
		return this.customerGoodsId;
	}

	public void setCustomerId(Long value) {
		this.customerId = value;
	}

	public Long getCustomerId() {
		return this.customerId;
	}

	public void setSessionId(Long value) {
		this.sessionId = value;
	}

	public Long getSessionId() {
		return this.sessionId;
	}

	public void setPartyId(Long value) {
		this.partyId = value;
	}

	public Long getPartyId() {
		return this.partyId;
	}

	public void setBillingPrincipalEnumId(Long value) {
		this.billingPrincipalEnumId = value;
	}

	public Long getBillingPrincipalEnumId() {
		return this.billingPrincipalEnumId;
	}

	public void setBillingPrincipalId(String value) {
		this.billingPrincipalId = value;
	}

	public String getBillingPrincipalId() {
		return this.billingPrincipalId;
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
        if(obj instanceof GoodsUsagePrincipal == false) return false;
        if(this == obj) return true;
        GoodsUsagePrincipal other = (GoodsUsagePrincipal)obj;
        return new EqualsBuilder()
            .append(getId(),other.getId())
            .isEquals();
    }

}