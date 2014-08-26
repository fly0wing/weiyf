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
 * Created by gencode on 2014-8-26 15:53:00.
 */
public class GoodsUsageLog implements Serializable {
    private static final long serialVersionUID = 5454155825314635342L;

    /**
     * db_column: id
     * remarks from db:使用日志标识
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
     * db_column: quantity_uom_id
     * remarks from db:数量单位
     */
    private Long quantityUomId;
    /**
     * db_column: quantity_used
     * remarks from db:使用数量
     */
    private BigDecimal quantityUsed;
    /**
     * db_column: time_uom_id
     * remarks from db:时间单位
     */
    private Long timeUomId;
    /**
     * db_column: time_used
     * remarks from db:使用时间
     */
    private BigDecimal timeUsed;
    /**
     * db_column: quantity_left
     * remarks from db:剩余数量
     */
    private BigDecimal quantityLeft;
    /**
     * db_column: time_left
     * remarks from db:剩余时间
     */
    private BigDecimal timeLeft;
    /**
     * db_column: expire_time
     * remarks from db:失效时间
     */
    private Timestamp expireTime;
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

	public GoodsUsageLog() {
	}

	public GoodsUsageLog(
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

	public void setQuantityUomId(Long value) {
		this.quantityUomId = value;
	}

	public Long getQuantityUomId() {
		return this.quantityUomId;
	}

	public void setQuantityUsed(BigDecimal value) {
		this.quantityUsed = value;
	}

	public BigDecimal getQuantityUsed() {
		return this.quantityUsed;
	}

	public void setTimeUomId(Long value) {
		this.timeUomId = value;
	}

	public Long getTimeUomId() {
		return this.timeUomId;
	}

	public void setTimeUsed(BigDecimal value) {
		this.timeUsed = value;
	}

	public BigDecimal getTimeUsed() {
		return this.timeUsed;
	}

	public void setQuantityLeft(BigDecimal value) {
		this.quantityLeft = value;
	}

	public BigDecimal getQuantityLeft() {
		return this.quantityLeft;
	}

	public void setTimeLeft(BigDecimal value) {
		this.timeLeft = value;
	}

	public BigDecimal getTimeLeft() {
		return this.timeLeft;
	}

	public String getExpireTimeString() {
		return DateConvertUtils.format(getExpireTime(), DateConvertUtils.DATE_FORMAT);
	}

	public void setExpireTimeString(String value) {
		setExpireTime(DateConvertUtils.parse(value, DateConvertUtils.DATE_FORMAT,Timestamp.class));
	}

	public void setExpireTime(Timestamp value) {
		this.expireTime = value;
	}

	public Timestamp getExpireTime() {
		return this.expireTime;
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
        if(obj instanceof GoodsUsageLog == false) return false;
        if(this == obj) return true;
        GoodsUsageLog other = (GoodsUsageLog)obj;
        return new EqualsBuilder()
            .append(getId(),other.getId())
            .isEquals();
    }

}