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
 * Created by gencode on 2014-8-28 13:52:49.
 */
public class CustomerLogin implements Serializable {
    private static final long serialVersionUID = 5454155825314635342L;

    /**
     * db_column: id
     * remarks from db:用户标识
     */
    private Long id;
    /**
     * db_column: login_name
     * remarks from db:登录名
     */
    private String loginName;
    /**
     * db_column: login_email
     * remarks from db:登录邮箱
     */
    private String loginEmail;
    /**
     * db_column: login_phone
     * remarks from db:登录手机号
     */
    private String loginPhone;
    /**
     * db_column: nickname
     * remarks from db:昵称
     */
    private String nickname;
    /**
     * db_column: is_anonymous
     * remarks from db:是否匿名
     */
    private Boolean isAnonymous;
    /**
     * db_column: current_password
     * remarks from db:当前密码
     */
    private String currentPassword;
    /**
     * db_column: enabled
     * remarks from db:可用
     */
    private Boolean enabled;
    /**
     * db_column: first_session_id
     * remarks from db:首次会话标识
     */
    private Long firstSessionId;
    /**
     * db_column: require_password_change
     * remarks from db:要求修改密码
     */
    private Boolean requirePasswordChange;
    /**
     * db_column: security_level
     * remarks from db:安全级别
     */
    private Integer securityLevel;
    /**
     * db_column: register_time
     * remarks from db:注册时间
     */
    private Timestamp registerTime;
    /**
     * db_column: last_login_time
     * remarks from db:最后登录时间
     */
    private Timestamp lastLoginTime;

	public CustomerLogin() {
	}

	public CustomerLogin(
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

	public void setLoginName(String value) {
		this.loginName = value;
	}

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginEmail(String value) {
		this.loginEmail = value;
	}

	public String getLoginEmail() {
		return this.loginEmail;
	}

	public void setLoginPhone(String value) {
		this.loginPhone = value;
	}

	public String getLoginPhone() {
		return this.loginPhone;
	}

	public void setNickname(String value) {
		this.nickname = value;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setIsAnonymous(Boolean value) {
		this.isAnonymous = value;
	}

	public Boolean getIsAnonymous() {
		return this.isAnonymous;
	}

	public void setCurrentPassword(String value) {
		this.currentPassword = value;
	}

	public String getCurrentPassword() {
		return this.currentPassword;
	}

	public void setEnabled(Boolean value) {
		this.enabled = value;
	}

	public Boolean getEnabled() {
		return this.enabled;
	}

	public void setFirstSessionId(Long value) {
		this.firstSessionId = value;
	}

	public Long getFirstSessionId() {
		return this.firstSessionId;
	}

	public void setRequirePasswordChange(Boolean value) {
		this.requirePasswordChange = value;
	}

	public Boolean getRequirePasswordChange() {
		return this.requirePasswordChange;
	}

	public void setSecurityLevel(Integer value) {
		this.securityLevel = value;
	}

	public Integer getSecurityLevel() {
		return this.securityLevel;
	}

	public String getRegisterTimeString() {
		return DateConvertUtils.format(getRegisterTime(), DateConvertUtils.DATE_FORMAT);
	}

	public void setRegisterTimeString(String value) {
		setRegisterTime(DateConvertUtils.parse(value, DateConvertUtils.DATE_FORMAT,Timestamp.class));
	}

	public void setRegisterTime(Timestamp value) {
		this.registerTime = value;
	}

	public Timestamp getRegisterTime() {
		return this.registerTime;
	}

	public String getLastLoginTimeString() {
		return DateConvertUtils.format(getLastLoginTime(), DateConvertUtils.DATE_FORMAT);
	}

	public void setLastLoginTimeString(String value) {
		setLastLoginTime(DateConvertUtils.parse(value, DateConvertUtils.DATE_FORMAT,Timestamp.class));
	}

	public void setLastLoginTime(Timestamp value) {
		this.lastLoginTime = value;
	}

	public Timestamp getLastLoginTime() {
		return this.lastLoginTime;
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
        if(obj instanceof CustomerLogin == false) return false;
        if(this == obj) return true;
        CustomerLogin other = (CustomerLogin)obj;
        return new EqualsBuilder()
            .append(getId(),other.getId())
            .isEquals();
    }

}