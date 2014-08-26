package com.billing.user.orm.model;

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
 * Created by gencode on 2014-8-26 15:19:37.
 */
public class TerminalActivate implements Serializable {
    private static final long serialVersionUID = 5454155825314635342L;

    /**
     * db_column: id
     * remarks from db:激活标识
     */
    private Long id;
    /**
     * db_column: terminal_id
     * remarks from db:终端标识
     */
    private Long terminalId;
    /**
     * db_column: session_id
     * remarks from db:会话标识
     */
    private Long sessionId;
    /**
     * db_column: activate_time
     * remarks from db:激活时间
     */
    private Timestamp activateTime;

	public TerminalActivate() {
	}

	public TerminalActivate(
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

	public void setTerminalId(Long value) {
		this.terminalId = value;
	}

	public Long getTerminalId() {
		return this.terminalId;
	}

	public void setSessionId(Long value) {
		this.sessionId = value;
	}

	public Long getSessionId() {
		return this.sessionId;
	}

	public String getActivateTimeString() {
		return DateConvertUtils.format(getActivateTime(), DateConvertUtils.DATE_FORMAT);
	}

	public void setActivateTimeString(String value) {
		setActivateTime(DateConvertUtils.parse(value, DateConvertUtils.DATE_FORMAT,Timestamp.class));
	}

	public void setActivateTime(Timestamp value) {
		this.activateTime = value;
	}

	public Timestamp getActivateTime() {
		return this.activateTime;
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
        if(obj instanceof TerminalActivate == false) return false;
        if(this == obj) return true;
        TerminalActivate other = (TerminalActivate)obj;
        return new EqualsBuilder()
            .append(getId(),other.getId())
            .isEquals();
    }

}