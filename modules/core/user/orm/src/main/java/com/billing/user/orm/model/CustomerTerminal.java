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
 * Created by gencode on 2014-8-26 16:12:41.
 */
public class CustomerTerminal implements Serializable {
    private static final long serialVersionUID = 5454155825314635342L;

    /**
     * db_column: id
     * remarks from db:用户终端标识
     */
    private Long id;
    /**
     * db_column: customer_id
     * remarks from db:用户标识
     */
    private Long customerId;
    /**
     * db_column: terminal_id
     * remarks from db:终端标识
     */
    private Long terminalId;
    /**
     * db_column: terminal_name
     * remarks from db:终端名称
     */
    private String terminalName;
    /**
     * db_column: bind_status_id
     * remarks from db:绑定状态标识
     */
    private Long bindStatusId;
    /**
     * db_column: current_op_time
     * remarks from db:当前操作时间
     */
    private Timestamp currentOpTime;
    /**
     * db_column: last_op_time
     * remarks from db:上次操作时间
     */
    private Timestamp lastOpTime;
    /**
     * db_column: first_bind_time
     * remarks from db:首次绑定时间
     */
    private Timestamp firstBindTime;
    /**
     * db_column: is_auto_login
     * remarks from db:是否自动登录
     */
    private Boolean isAutoLogin;
    /**
     * db_column: last_login_token
     * remarks from db:上次登录令牌
     */
    private String lastLoginToken;

	public CustomerTerminal() {
	}

	public CustomerTerminal(
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

	public void setTerminalId(Long value) {
		this.terminalId = value;
	}

	public Long getTerminalId() {
		return this.terminalId;
	}

	public void setTerminalName(String value) {
		this.terminalName = value;
	}

	public String getTerminalName() {
		return this.terminalName;
	}

	public void setBindStatusId(Long value) {
		this.bindStatusId = value;
	}

	public Long getBindStatusId() {
		return this.bindStatusId;
	}

	public String getCurrentOpTimeString() {
		return DateConvertUtils.format(getCurrentOpTime(), DateConvertUtils.DATE_FORMAT);
	}

	public void setCurrentOpTimeString(String value) {
		setCurrentOpTime(DateConvertUtils.parse(value, DateConvertUtils.DATE_FORMAT,Timestamp.class));
	}

	public void setCurrentOpTime(Timestamp value) {
		this.currentOpTime = value;
	}

	public Timestamp getCurrentOpTime() {
		return this.currentOpTime;
	}

	public String getLastOpTimeString() {
		return DateConvertUtils.format(getLastOpTime(), DateConvertUtils.DATE_FORMAT);
	}

	public void setLastOpTimeString(String value) {
		setLastOpTime(DateConvertUtils.parse(value, DateConvertUtils.DATE_FORMAT,Timestamp.class));
	}

	public void setLastOpTime(Timestamp value) {
		this.lastOpTime = value;
	}

	public Timestamp getLastOpTime() {
		return this.lastOpTime;
	}

	public String getFirstBindTimeString() {
		return DateConvertUtils.format(getFirstBindTime(), DateConvertUtils.DATE_FORMAT);
	}

	public void setFirstBindTimeString(String value) {
		setFirstBindTime(DateConvertUtils.parse(value, DateConvertUtils.DATE_FORMAT,Timestamp.class));
	}

	public void setFirstBindTime(Timestamp value) {
		this.firstBindTime = value;
	}

	public Timestamp getFirstBindTime() {
		return this.firstBindTime;
	}

	public void setIsAutoLogin(Boolean value) {
		this.isAutoLogin = value;
	}

	public Boolean getIsAutoLogin() {
		return this.isAutoLogin;
	}

	public void setLastLoginToken(String value) {
		this.lastLoginToken = value;
	}

	public String getLastLoginToken() {
		return this.lastLoginToken;
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
        if(obj instanceof CustomerTerminal == false) return false;
        if(this == obj) return true;
        CustomerTerminal other = (CustomerTerminal)obj;
        return new EqualsBuilder()
            .append(getId(),other.getId())
            .isEquals();
    }

}