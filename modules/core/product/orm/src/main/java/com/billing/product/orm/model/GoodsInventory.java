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
 * Created by gencode on 2014-8-27 14:11:54.
 */
public class GoodsInventory implements Serializable {
    private static final long serialVersionUID = 5454155825314635342L;

    /**
     * db_column: id
     */
    private Long id;
    /**
     * db_column: goods_id
     * remarks from db:商品标识
     */
    private Long goodsId;
    /**
     * db_column: time_uom_id
     * remarks from db:时间单位
     */
    private Long timeUomId;
    /**
     * db_column: time_included
     * remarks from db:时间数量
     */
    private Integer timeIncluded;
    /**
     * db_column: inventory_quantity
     * remarks from db:库存数量
     */
    private Long inventoryQuantity;
    /**
     * db_column: manual_reset
     * remarks from db:人工复位
     */
    private Boolean manualReset;
    /**
     * db_column: strict_mode
     * remarks from db:严格模式
     */
    private Boolean strictMode;
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

	public GoodsInventory() {
	}

	public GoodsInventory(
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

	public void setGoodsId(Long value) {
		this.goodsId = value;
	}

	public Long getGoodsId() {
		return this.goodsId;
	}

	public void setTimeUomId(Long value) {
		this.timeUomId = value;
	}

	public Long getTimeUomId() {
		return this.timeUomId;
	}

	public void setTimeIncluded(Integer value) {
		this.timeIncluded = value;
	}

	public Integer getTimeIncluded() {
		return this.timeIncluded;
	}

	public void setInventoryQuantity(Long value) {
		this.inventoryQuantity = value;
	}

	public Long getInventoryQuantity() {
		return this.inventoryQuantity;
	}

	public void setManualReset(Boolean value) {
		this.manualReset = value;
	}

	public Boolean getManualReset() {
		return this.manualReset;
	}

	public void setStrictMode(Boolean value) {
		this.strictMode = value;
	}

	public Boolean getStrictMode() {
		return this.strictMode;
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
        if(obj instanceof GoodsInventory == false) return false;
        if(this == obj) return true;
        GoodsInventory other = (GoodsInventory)obj;
        return new EqualsBuilder()
            .append(getId(),other.getId())
            .isEquals();
    }

}