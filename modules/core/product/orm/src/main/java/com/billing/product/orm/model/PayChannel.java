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
public class PayChannel implements Serializable {
    private static final long serialVersionUID = 5454155825314635342L;

    /**
     * db_column: pay_channel_id
     * remarks from db:支付渠道标识
     */
    private String payChannelId;
    /**
     * db_column: pay_gateway_id
     */
    private String payGatewayId;
    /**
     * db_column: party_id
     * remarks from db:商户标识
     */
    private Long partyId;
    /**
     * db_column: statust_id
     * remarks from db:状态标识
     */
    private Long statustId;
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

	public PayChannel() {
	}

	public PayChannel(
		String payChannelId
	) {
		this.payChannelId = payChannelId;
	}

	public void setPayChannelId(String value) {
		this.payChannelId = value;
	}

	public String getPayChannelId() {
		return this.payChannelId;
	}

	public void setPayGatewayId(String value) {
		this.payGatewayId = value;
	}

	public String getPayGatewayId() {
		return this.payGatewayId;
	}

	public void setPartyId(Long value) {
		this.partyId = value;
	}

	public Long getPartyId() {
		return this.partyId;
	}

	public void setStatustId(Long value) {
		this.statustId = value;
	}

	public Long getStatustId() {
		return this.statustId;
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


	private Set payChannelDiscounts = new HashSet(0);
	public void setPayChannelDiscounts(Set<PayChannelDiscount> payChannelDiscount){
		this.payChannelDiscounts = payChannelDiscount;
	}

	public Set<PayChannelDiscount> getPayChannelDiscounts() {
		return payChannelDiscounts;
	}

	private PayGateway payGateway;

	public void setPayGateway(PayGateway payGateway){
		this.payGateway = payGateway;
	}

	public PayGateway getPayGateway() {
		return payGateway;
	}

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getPayChannelId())
            .toHashCode();
    }

    public boolean equals(Object obj) {
        if(obj instanceof PayChannel == false) return false;
        if(this == obj) return true;
        PayChannel other = (PayChannel)obj;
        return new EqualsBuilder()
            .append(getPayChannelId(),other.getPayChannelId())
            .isEquals();
    }

}