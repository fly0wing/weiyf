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
 * Created by gencode on 2014-8-27 14:12:09.
 */
public class UserLogin implements Serializable {
    private static final long serialVersionUID = 5454155825314635342L;

    /**
     * db_column: user_login_id
     * remarks from db:登录账号
     */
    private String userLoginId;
    /**
     * db_column: current_password
     * remarks from db:当前密码
     */
    private String currentPassword;
    /**
     * db_column: password_hint
     * remarks from db:密码提示
     */
    private String passwordHint;
    /**
     * db_column: is_system
     * remarks from db:系统账号
     */
    private Boolean isSystem;
    /**
     * db_column: enabled
     * remarks from db:可用
     */
    private Boolean enabled;
    /**
     * db_column: has_logged_out
     * remarks from db:已退出
     */
    private Boolean hasLoggedOut;
    /**
     * db_column: require_password_change
     * remarks from db:要求修改密码
     */
    private Boolean requirePasswordChange;
    /**
     * db_column: last_currency_uom
     * remarks from db:最后币种
     */
    private String lastCurrencyUom;
    /**
     * db_column: last_locale
     * remarks from db:最后地域
     */
    private String lastLocale;
    /**
     * db_column: last_time_zone
     * remarks from db:最后时区
     */
    private String lastTimeZone;
    /**
     * db_column: disabled_date_time
     * remarks from db:被禁用时间
     */
    private Timestamp disabledDateTime;
    /**
     * db_column: successive_failed_logins
     * remarks from db:连续失败次数
     */
    private BigDecimal successiveFailedLogins;
    /**
     * db_column: external_auth_id
     * remarks from db:外部鉴权标识
     */
    private String externalAuthId;
    /**
     * db_column: user_ldap_dn
     * remarks from db:用户LDAP域
     */
    private String userLdapDn;
    /**
     * db_column: party_id
     * remarks from db:归属者标识
     */
    private Long partyId;
    /**
     * db_column: last_updated_stamp
     */
    private Timestamp lastUpdatedStamp;
    /**
     * db_column: created_stamp
     */
    private Timestamp createdStamp;

	public UserLogin() {
	}

	public UserLogin(
		String userLoginId
	) {
		this.userLoginId = userLoginId;
	}

	public void setUserLoginId(String value) {
		this.userLoginId = value;
	}

	public String getUserLoginId() {
		return this.userLoginId;
	}

	public void setCurrentPassword(String value) {
		this.currentPassword = value;
	}

	public String getCurrentPassword() {
		return this.currentPassword;
	}

	public void setPasswordHint(String value) {
		this.passwordHint = value;
	}

	public String getPasswordHint() {
		return this.passwordHint;
	}

	public void setIsSystem(Boolean value) {
		this.isSystem = value;
	}

	public Boolean getIsSystem() {
		return this.isSystem;
	}

	public void setEnabled(Boolean value) {
		this.enabled = value;
	}

	public Boolean getEnabled() {
		return this.enabled;
	}

	public void setHasLoggedOut(Boolean value) {
		this.hasLoggedOut = value;
	}

	public Boolean getHasLoggedOut() {
		return this.hasLoggedOut;
	}

	public void setRequirePasswordChange(Boolean value) {
		this.requirePasswordChange = value;
	}

	public Boolean getRequirePasswordChange() {
		return this.requirePasswordChange;
	}

	public void setLastCurrencyUom(String value) {
		this.lastCurrencyUom = value;
	}

	public String getLastCurrencyUom() {
		return this.lastCurrencyUom;
	}

	public void setLastLocale(String value) {
		this.lastLocale = value;
	}

	public String getLastLocale() {
		return this.lastLocale;
	}

	public void setLastTimeZone(String value) {
		this.lastTimeZone = value;
	}

	public String getLastTimeZone() {
		return this.lastTimeZone;
	}

	public String getDisabledDateTimeString() {
		return DateConvertUtils.format(getDisabledDateTime(), DateConvertUtils.DATE_FORMAT);
	}

	public void setDisabledDateTimeString(String value) {
		setDisabledDateTime(DateConvertUtils.parse(value, DateConvertUtils.DATE_FORMAT,Timestamp.class));
	}

	public void setDisabledDateTime(Timestamp value) {
		this.disabledDateTime = value;
	}

	public Timestamp getDisabledDateTime() {
		return this.disabledDateTime;
	}

	public void setSuccessiveFailedLogins(BigDecimal value) {
		this.successiveFailedLogins = value;
	}

	public BigDecimal getSuccessiveFailedLogins() {
		return this.successiveFailedLogins;
	}

	public void setExternalAuthId(String value) {
		this.externalAuthId = value;
	}

	public String getExternalAuthId() {
		return this.externalAuthId;
	}

	public void setUserLdapDn(String value) {
		this.userLdapDn = value;
	}

	public String getUserLdapDn() {
		return this.userLdapDn;
	}

	public void setPartyId(Long value) {
		this.partyId = value;
	}

	public Long getPartyId() {
		return this.partyId;
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


    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getUserLoginId())
            .toHashCode();
    }

    public boolean equals(Object obj) {
        if(obj instanceof UserLogin == false) return false;
        if(this == obj) return true;
        UserLogin other = (UserLogin)obj;
        return new EqualsBuilder()
            .append(getUserLoginId(),other.getUserLoginId())
            .isEquals();
    }

}