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
 * Created by gencode on 2014-8-28 15:17:32.
 */
public class UserSessionDurable implements Serializable {
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
     * db_column: terminal_id
     * remarks from db:终端标识
     */
    private Long terminalId;
    /**
     * db_column: app_area
     * remarks from db:应用分区
     */
    private String appArea;
    /**
     * db_column: login_oken
     * remarks from db:登录令牌
     */
    private String loginOken;
    /**
     * db_column: is_bound
     * remarks from db:已绑定否
     */
    private Boolean isBound;
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

	public UserSessionDurable() {
	}

	public UserSessionDurable(
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

	public void setTerminalId(Long value) {
		this.terminalId = value;
	}

	public Long getTerminalId() {
		return this.terminalId;
	}

	public void setAppArea(String value) {
		this.appArea = value;
	}

	public String getAppArea() {
		return this.appArea;
	}

	public void setLoginOken(String value) {
		this.loginOken = value;
	}

	public String getLoginOken() {
		return this.loginOken;
	}

	public void setIsBound(Boolean value) {
		this.isBound = value;
	}

	public Boolean getIsBound() {
		return this.isBound;
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
        if(obj instanceof UserSessionDurable == false) return false;
        if(this == obj) return true;
        UserSessionDurable other = (UserSessionDurable)obj;
        return new EqualsBuilder()
            .append(getId(),other.getId())
            .isEquals();
    }

    public static final String FN_id = "id";
    public static final String FN_customerId = "customerId";
    public static final String FN_partyId = "partyId";
    public static final String FN_productId = "productId";
    public static final String FN_domainId = "domainId";
    public static final String FN_appId = "appId";
    public static final String FN_entryId = "entryId";
    public static final String FN_geoId = "geoId";
    public static final String FN_terminalId = "terminalId";
    public static final String FN_appArea = "appArea";
    public static final String FN_loginOken = "loginOken";
    public static final String FN_isBound = "isBound";
    public static final String FN_isAnonymous = "isAnonymous";
    public static final String FN_createTime = "createTime";

}