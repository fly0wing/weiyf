package com.billing.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.billing.utils.date.DateConvertUtils;

/**
* Created by gencode on 2014-8-26 12:23:07.
*/
public class Product implements Serializable {
private static final long serialVersionUID = 5454155825314635342L;

/**
* db_column: id
    * remarks from db:产品标识
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
* db_column: product_name
    * remarks from db:产品名称
*/
private String productName;
/**
* db_column: billing_principal_enum_id
    * remarks from db:计费身份枚举标识
*/
private Long billingPrincipalEnumId;
/**
* db_column: quantity_uom_id
    * remarks from db:数量单位
*/
private Long quantityUomId;
/**
* db_column: quantity_included
    * remarks from db:包含数量
*/
private BigDecimal quantityIncluded;
/**
* db_column: price_uom_id
    * remarks from db:金额单位
*/
private Long priceUomId;
/**
* db_column: price_amount
    * remarks from db:金额
*/
private BigDecimal priceAmount;
/**
* db_column: include_in_promotions
    * remarks from db:促销中
*/
private String includeInPromotions;
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

	public Product() {
	}

	public Product(
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

	public void setProductName(String value) {
		this.productName = value;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setBillingPrincipalEnumId(Long value) {
		this.billingPrincipalEnumId = value;
	}

	public Long getBillingPrincipalEnumId() {
		return this.billingPrincipalEnumId;
	}

	public void setQuantityUomId(Long value) {
		this.quantityUomId = value;
	}

	public Long getQuantityUomId() {
		return this.quantityUomId;
	}

	public void setQuantityIncluded(BigDecimal value) {
		this.quantityIncluded = value;
	}

	public BigDecimal getQuantityIncluded() {
		return this.quantityIncluded;
	}

	public void setPriceUomId(Long value) {
		this.priceUomId = value;
	}

	public Long getPriceUomId() {
		return this.priceUomId;
	}

	public void setPriceAmount(BigDecimal value) {
		this.priceAmount = value;
	}

	public BigDecimal getPriceAmount() {
		return this.priceAmount;
	}

	public void setIncludeInPromotions(String value) {
		this.includeInPromotions = value;
	}

	public String getIncludeInPromotions() {
		return this.includeInPromotions;
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
if(obj instanceof Product == false) return false;
if(this == obj) return true;
Product other = (Product)obj;
return new EqualsBuilder()
.append(getId(),other.getId())
.isEquals();
}

}