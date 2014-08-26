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
 * Created by gencode on 2014-8-26 15:52:58.
 */
public class CustomerGoods implements Serializable {
    private static final long serialVersionUID = 5454155825314635342L;

    /**
     * db_column: id
     * remarks from db:用户商品标识
     */
    private Long id;
    /**
     * db_column: product_snap_id
     * remarks from db:产品快照标识
     */
    private Long productSnapId;
    /**
     * db_column: goods_snap_id
     * remarks from db:商品快照标识
     */
    private Long goodsSnapId;
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
     * db_column: order_id
     * remarks from db:订单标识
     */
    private Long orderId;
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
     * db_column: quantity_included
     * remarks from db:包含数量
     */
    private BigDecimal quantityIncluded;
    /**
     * db_column: time_uom_id
     */
    private Long timeUomId;
    /**
     * db_column: time_included
     * remarks from db:包含时间
     */
    private BigDecimal timeIncluded;
    /**
     * db_column: from_promotions
     * remarks from db:来自促销
     */
    private String fromPromotions;
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

	public CustomerGoods() {
	}

	public CustomerGoods(
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

	public void setProductSnapId(Long value) {
		this.productSnapId = value;
	}

	public Long getProductSnapId() {
		return this.productSnapId;
	}

	public void setGoodsSnapId(Long value) {
		this.goodsSnapId = value;
	}

	public Long getGoodsSnapId() {
		return this.goodsSnapId;
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

	public void setOrderId(Long value) {
		this.orderId = value;
	}

	public Long getOrderId() {
		return this.orderId;
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

	public void setQuantityIncluded(BigDecimal value) {
		this.quantityIncluded = value;
	}

	public BigDecimal getQuantityIncluded() {
		return this.quantityIncluded;
	}

	public void setTimeUomId(Long value) {
		this.timeUomId = value;
	}

	public Long getTimeUomId() {
		return this.timeUomId;
	}

	public void setTimeIncluded(BigDecimal value) {
		this.timeIncluded = value;
	}

	public BigDecimal getTimeIncluded() {
		return this.timeIncluded;
	}

	public void setFromPromotions(String value) {
		this.fromPromotions = value;
	}

	public String getFromPromotions() {
		return this.fromPromotions;
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
        if(obj instanceof CustomerGoods == false) return false;
        if(this == obj) return true;
        CustomerGoods other = (CustomerGoods)obj;
        return new EqualsBuilder()
            .append(getId(),other.getId())
            .isEquals();
    }

}