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
 * Created by gencode on 2014-8-27 14:11:49.
 */
public class ContactMechFinance implements Serializable {
    private static final long serialVersionUID = 5454155825314635342L;

    /**
     * db_column: id
     * remarks from db:联系机制标识
     */
    private Long id;
    /**
     * db_column: bank_of_deposit
     * remarks from db:开户行
     */
    private String bankOfDeposit;
    /**
     * db_column: payee_account_name
     * remarks from db:收款户名
     */
    private String payeeAccountName;
    /**
     * db_column: payee_account
     * remarks from db:收款账户
     */
    private String payeeAccount;
    /**
     * db_column: last_updated_stamp
     */
    private Timestamp lastUpdatedStamp;
    /**
     * db_column: created_stamp
     */
    private Timestamp createdStamp;

	public ContactMechFinance() {
	}

	public ContactMechFinance(
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

	public void setBankOfDeposit(String value) {
		this.bankOfDeposit = value;
	}

	public String getBankOfDeposit() {
		return this.bankOfDeposit;
	}

	public void setPayeeAccountName(String value) {
		this.payeeAccountName = value;
	}

	public String getPayeeAccountName() {
		return this.payeeAccountName;
	}

	public void setPayeeAccount(String value) {
		this.payeeAccount = value;
	}

	public String getPayeeAccount() {
		return this.payeeAccount;
	}

	public String getLastUpdatedStampString() {
		return DateConvertUtils.format(getLastUpdatedStamp(), DateConvertUtils.DATE_FORMAT);
	}

	public void setLastUpdatedStampString(String value) {
		setLastUpdatedStamp(DateConvertUtils.parse(value, DateConvertUtils.DATE_FORMAT,Timestamp.class));
	}

	public void setLastUpdatedStamp(Timestamp value) {
		this.lastUpdatedStamp = value;
	}

	public Timestamp getLastUpdatedStamp() {
		return this.lastUpdatedStamp;
	}

	public String getCreatedStampString() {
		return DateConvertUtils.format(getCreatedStamp(), DateConvertUtils.DATE_FORMAT);
	}

	public void setCreatedStampString(String value) {
		setCreatedStamp(DateConvertUtils.parse(value, DateConvertUtils.DATE_FORMAT,Timestamp.class));
	}

	public void setCreatedStamp(Timestamp value) {
		this.createdStamp = value;
	}

	public Timestamp getCreatedStamp() {
		return this.createdStamp;
	}


	private ContactMech contactMech;

	public void setContactMech(ContactMech contactMech){
		this.contactMech = contactMech;
	}

	public ContactMech getContactMech() {
		return contactMech;
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
        if(obj instanceof ContactMechFinance == false) return false;
        if(this == obj) return true;
        ContactMechFinance other = (ContactMechFinance)obj;
        return new EqualsBuilder()
            .append(getId(),other.getId())
            .isEquals();
    }

}