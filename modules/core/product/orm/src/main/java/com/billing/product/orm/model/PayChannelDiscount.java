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
 * Created by gencode on 2014-8-27 14:12:01.
 */
public class PayChannelDiscount implements Serializable {
    private static final long serialVersionUID = 5454155825314635342L;

    /**
     * db_column: id
     * remarks from db:支付渠道折扣标识
     */
    private Long id;
    /**
     * db_column: discount_activity_id
     * remarks from db:折扣活动标识
     */
    private Long discountActivityId;
    /**
     * db_column: pay_channel_id
     * remarks from db:支付渠道标识
     */
    private String payChannelId;
    /**
     * db_column: party_id
     * remarks from db:商户标识
     */
    private Long partyId;
    /**
     * db_column: app_id
     * remarks from db:应用标识
     */
    private Long appId;
    /**
     * db_column: entry_id
     * remarks from db:应用入口标识
     */
    private Long entryId;
    /**
     * db_column: statust_id
     * remarks from db:状态标识
     */
    private Long statustId;
    /**
     * db_column: discount_percent
     * remarks from db:折扣率
     */
    private BigDecimal discountPercent;
    /**
     * db_column: discount_amount
     * remarks from db:折扣金额
     */
    private BigDecimal discountAmount;
    /**
     * db_column: geo_id
     * remarks from db:地理标识
     */
    private Long geoId;
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

	public PayChannelDiscount() {
	}

	public PayChannelDiscount(
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

	public void setDiscountActivityId(Long value) {
		this.discountActivityId = value;
	}

	public Long getDiscountActivityId() {
		return this.discountActivityId;
	}

	public void setPayChannelId(String value) {
		this.payChannelId = value;
	}

	public String getPayChannelId() {
		return this.payChannelId;
	}

	public void setPartyId(Long value) {
		this.partyId = value;
	}

	public Long getPartyId() {
		return this.partyId;
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

	public void setStatustId(Long value) {
		this.statustId = value;
	}

	public Long getStatustId() {
		return this.statustId;
	}

	public void setDiscountPercent(BigDecimal value) {
		this.discountPercent = value;
	}

	public BigDecimal getDiscountPercent() {
		return this.discountPercent;
	}

	public void setDiscountAmount(BigDecimal value) {
		this.discountAmount = value;
	}

	public BigDecimal getDiscountAmount() {
		return this.discountAmount;
	}

	public void setGeoId(Long value) {
		this.geoId = value;
	}

	public Long getGeoId() {
		return this.geoId;
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


	private PayChannel payChannel;

	public void setPayChannel(PayChannel payChannel){
		this.payChannel = payChannel;
	}

	public PayChannel getPayChannel() {
		return payChannel;
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
        if(obj instanceof PayChannelDiscount == false) return false;
        if(this == obj) return true;
        PayChannelDiscount other = (PayChannelDiscount)obj;
        return new EqualsBuilder()
            .append(getId(),other.getId())
            .isEquals();
    }

}