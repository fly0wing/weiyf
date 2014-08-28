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
 * Created by gencode on 2014-8-28 13:52:50.
 */
public class Terminal implements Serializable {
    private static final long serialVersionUID = 5454155825314635342L;

    /**
     * db_column: id
     * remarks from db:终端标识
     */
    private Long id;
    /**
     * db_column: fingerprint
     * remarks from db:终端指纹
     */
    private String fingerprint;
    /**
     * db_column: default_name
     * remarks from db:默认名称
     */
    private String defaultName;
    /**
     * db_column: terminal_type_id
     * remarks from db:终端类型标识
     */
    private Long terminalTypeId;
    /**
     * db_column: first_session_id
     * remarks from db:首次会话标识
     */
    private Long firstSessionId;
    /**
     * db_column: first_activate_time
     * remarks from db:首次激活时间
     */
    private Timestamp firstActivateTime;

	public Terminal() {
	}

	public Terminal(
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

	public void setFingerprint(String value) {
		this.fingerprint = value;
	}

	public String getFingerprint() {
		return this.fingerprint;
	}

	public void setDefaultName(String value) {
		this.defaultName = value;
	}

	public String getDefaultName() {
		return this.defaultName;
	}

	public void setTerminalTypeId(Long value) {
		this.terminalTypeId = value;
	}

	public Long getTerminalTypeId() {
		return this.terminalTypeId;
	}

	public void setFirstSessionId(Long value) {
		this.firstSessionId = value;
	}

	public Long getFirstSessionId() {
		return this.firstSessionId;
	}

	public String getFirstActivateTimeString() {
		return DateConvertUtils.format(getFirstActivateTime(), DateConvertUtils.DATE_FORMAT);
	}

	public void setFirstActivateTimeString(String value) {
		setFirstActivateTime(DateConvertUtils.parse(value, DateConvertUtils.DATE_FORMAT,Timestamp.class));
	}

	public void setFirstActivateTime(Timestamp value) {
		this.firstActivateTime = value;
	}

	public Timestamp getFirstActivateTime() {
		return this.firstActivateTime;
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
        if(obj instanceof Terminal == false) return false;
        if(this == obj) return true;
        Terminal other = (Terminal)obj;
        return new EqualsBuilder()
            .append(getId(),other.getId())
            .isEquals();
    }

}