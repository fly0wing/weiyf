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
public class GoodsSnap implements Serializable {
    private static final long serialVersionUID = 5454155825314635342L;

    /**
     * db_column: id
     * remarks from db:商品快照标识
     */
    private Long id;
    /**
     * db_column: product_snap_id
     * remarks from db:产品快照标识
     */
    private Long productSnapId;
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
     * db_column: goods_name
     * remarks from db:商品名称
     */
    private String goodsName;
    /**
     * db_column: billing_method_enum_id
     * remarks from db:计费方法
     */
    private Long billingMethodEnumId;
    /**
     * db_column: need_resource_uri
     * remarks from db:需要资源地址
     */
    private Boolean needResourceUri;
    /**
     * db_column: principal_limit_purchase_times
     * remarks from db:单个主体允许购买的次数
     */
    private Integer principalLimitPurchaseTimes;
    /**
     * db_column: inventory_quantity
     * remarks from db:库存数量
     */
    private Long inventoryQuantity;
    /**
     * db_column: show_priority
     * remarks from db:显示优先级
     */
    private Integer showPriority;
    /**
     * db_column: introduction_date
     * remarks from db:引入日期
     */
    private Timestamp introductionDate;
    /**
     * db_column: release_date
     * remarks from db:发布日期
     */
    private Timestamp releaseDate;
    /**
     * db_column: support_discontinuation_date
     * remarks from db:支持截止日期
     */
    private Timestamp supportDiscontinuationDate;
    /**
     * db_column: sales_discontinuation_date
     * remarks from db:销售截止日期
     */
    private Timestamp salesDiscontinuationDate;
    /**
     * db_column: sales_disc_when_not_avail
     * remarks from db:当缺货时销售终止
     */
    private Boolean salesDiscWhenNotAvail;
    /**
     * db_column: internal_name
     * remarks from db:内部名称
     */
    private String internalName;
    /**
     * db_column: comments
     * remarks from db:备注
     */
    private String comments;
    /**
     * db_column: description
     * remarks from db:描述
     */
    private String description;
    /**
     * db_column: price_detail_text
     * remarks from db:价格描述
     */
    private String priceDetailText;
    /**
     * db_column: inventory_message
     * remarks from db:库存信息
     */
    private String inventoryMessage;
    /**
     * db_column: require_inventory
     * remarks from db:要求库存
     */
    private String requireInventory;
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
     * db_column: price_indication
     * remarks from db:参考价格
     */
    private BigDecimal priceIndication;
    /**
     * db_column: price_sale
     * remarks from db:销售价格
     */
    private BigDecimal priceSale;
    /**
     * db_column: price_promotion
     * remarks from db:促销价格
     */
    private BigDecimal pricePromotion;
    /**
     * db_column: price_uom_id
     * remarks from db:金额单位
     */
    private Long priceUomId;
    /**
     * db_column: returnable
     * remarks from db:可否退货
     */
    private String returnable;
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

	public GoodsSnap() {
	}

	public GoodsSnap(
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

	public void setGoodsName(String value) {
		this.goodsName = value;
	}

	public String getGoodsName() {
		return this.goodsName;
	}

	public void setBillingMethodEnumId(Long value) {
		this.billingMethodEnumId = value;
	}

	public Long getBillingMethodEnumId() {
		return this.billingMethodEnumId;
	}

	public void setNeedResourceUri(Boolean value) {
		this.needResourceUri = value;
	}

	public Boolean getNeedResourceUri() {
		return this.needResourceUri;
	}

	public void setPrincipalLimitPurchaseTimes(Integer value) {
		this.principalLimitPurchaseTimes = value;
	}

	public Integer getPrincipalLimitPurchaseTimes() {
		return this.principalLimitPurchaseTimes;
	}

	public void setInventoryQuantity(Long value) {
		this.inventoryQuantity = value;
	}

	public Long getInventoryQuantity() {
		return this.inventoryQuantity;
	}

	public void setShowPriority(Integer value) {
		this.showPriority = value;
	}

	public Integer getShowPriority() {
		return this.showPriority;
	}

	public String getIntroductionDateString() {
		return DateConvertUtils.format(getIntroductionDate(), DateConvertUtils.DATE_FORMAT);
	}

	public void setIntroductionDateString(String value) {
		setIntroductionDate(DateConvertUtils.parse(value, DateConvertUtils.DATE_FORMAT,Timestamp.class));
	}

	public void setIntroductionDate(Timestamp value) {
		this.introductionDate = value;
	}

	public Timestamp getIntroductionDate() {
		return this.introductionDate;
	}

	public String getReleaseDateString() {
		return DateConvertUtils.format(getReleaseDate(), DateConvertUtils.DATE_FORMAT);
	}

	public void setReleaseDateString(String value) {
		setReleaseDate(DateConvertUtils.parse(value, DateConvertUtils.DATE_FORMAT,Timestamp.class));
	}

	public void setReleaseDate(Timestamp value) {
		this.releaseDate = value;
	}

	public Timestamp getReleaseDate() {
		return this.releaseDate;
	}

	public String getSupportDiscontinuationDateString() {
		return DateConvertUtils.format(getSupportDiscontinuationDate(), DateConvertUtils.DATE_FORMAT);
	}

	public void setSupportDiscontinuationDateString(String value) {
		setSupportDiscontinuationDate(DateConvertUtils.parse(value, DateConvertUtils.DATE_FORMAT,Timestamp.class));
	}

	public void setSupportDiscontinuationDate(Timestamp value) {
		this.supportDiscontinuationDate = value;
	}

	public Timestamp getSupportDiscontinuationDate() {
		return this.supportDiscontinuationDate;
	}

	public String getSalesDiscontinuationDateString() {
		return DateConvertUtils.format(getSalesDiscontinuationDate(), DateConvertUtils.DATE_FORMAT);
	}

	public void setSalesDiscontinuationDateString(String value) {
		setSalesDiscontinuationDate(DateConvertUtils.parse(value, DateConvertUtils.DATE_FORMAT,Timestamp.class));
	}

	public void setSalesDiscontinuationDate(Timestamp value) {
		this.salesDiscontinuationDate = value;
	}

	public Timestamp getSalesDiscontinuationDate() {
		return this.salesDiscontinuationDate;
	}

	public void setSalesDiscWhenNotAvail(Boolean value) {
		this.salesDiscWhenNotAvail = value;
	}

	public Boolean getSalesDiscWhenNotAvail() {
		return this.salesDiscWhenNotAvail;
	}

	public void setInternalName(String value) {
		this.internalName = value;
	}

	public String getInternalName() {
		return this.internalName;
	}

	public void setComments(String value) {
		this.comments = value;
	}

	public String getComments() {
		return this.comments;
	}

	public void setDescription(String value) {
		this.description = value;
	}

	public String getDescription() {
		return this.description;
	}

	public void setPriceDetailText(String value) {
		this.priceDetailText = value;
	}

	public String getPriceDetailText() {
		return this.priceDetailText;
	}

	public void setInventoryMessage(String value) {
		this.inventoryMessage = value;
	}

	public String getInventoryMessage() {
		return this.inventoryMessage;
	}

	public void setRequireInventory(String value) {
		this.requireInventory = value;
	}

	public String getRequireInventory() {
		return this.requireInventory;
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

	public void setPriceIndication(BigDecimal value) {
		this.priceIndication = value;
	}

	public BigDecimal getPriceIndication() {
		return this.priceIndication;
	}

	public void setPriceSale(BigDecimal value) {
		this.priceSale = value;
	}

	public BigDecimal getPriceSale() {
		return this.priceSale;
	}

	public void setPricePromotion(BigDecimal value) {
		this.pricePromotion = value;
	}

	public BigDecimal getPricePromotion() {
		return this.pricePromotion;
	}

	public void setPriceUomId(Long value) {
		this.priceUomId = value;
	}

	public Long getPriceUomId() {
		return this.priceUomId;
	}

	public void setReturnable(String value) {
		this.returnable = value;
	}

	public String getReturnable() {
		return this.returnable;
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
        if(obj instanceof GoodsSnap == false) return false;
        if(this == obj) return true;
        GoodsSnap other = (GoodsSnap)obj;
        return new EqualsBuilder()
            .append(getId(),other.getId())
            .isEquals();
    }

}