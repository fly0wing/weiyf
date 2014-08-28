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
 * Created by gencode on 2014-8-28 13:52:51.
 */
public class TerminalType implements Serializable {
    private static final long serialVersionUID = 5454155825314635342L;

    /**
     * db_column: terminal_type_id
     * remarks from db:终端类型标识
     */
    private Long terminalTypeId;
    /**
     * db_column: parent_type_id
     * remarks from db:父类型标识
     */
    private Long parentTypeId;
    /**
     * db_column: os_type
     * remarks from db:操作系统类型
     */
    private String osType;
    /**
     * db_column: screen_size_enum_id
     * remarks from db:屏幕尺寸枚举
     */
    private Long screenSizeEnumId;
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

	public TerminalType() {
	}

	public TerminalType(
		Long terminalTypeId
	) {
		this.terminalTypeId = terminalTypeId;
	}

	public void setTerminalTypeId(Long value) {
		this.terminalTypeId = value;
	}

	public Long getTerminalTypeId() {
		return this.terminalTypeId;
	}

	public void setParentTypeId(Long value) {
		this.parentTypeId = value;
	}

	public Long getParentTypeId() {
		return this.parentTypeId;
	}

	public void setOsType(String value) {
		this.osType = value;
	}

	public String getOsType() {
		return this.osType;
	}

	public void setScreenSizeEnumId(Long value) {
		this.screenSizeEnumId = value;
	}

	public Long getScreenSizeEnumId() {
		return this.screenSizeEnumId;
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


	private Set terminalTypes = new HashSet(0);
	public void setTerminalTypes(Set<TerminalType> terminalType){
		this.terminalTypes = terminalType;
	}

	public Set<TerminalType> getTerminalTypes() {
		return terminalTypes;
	}

	private TerminalType terminalType;

	public void setTerminalType(TerminalType terminalType){
		this.terminalType = terminalType;
	}

	public TerminalType getTerminalType() {
		return terminalType;
	}

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getTerminalTypeId())
            .toHashCode();
    }

    public boolean equals(Object obj) {
        if(obj instanceof TerminalType == false) return false;
        if(this == obj) return true;
        TerminalType other = (TerminalType)obj;
        return new EqualsBuilder()
            .append(getTerminalTypeId(),other.getTerminalTypeId())
            .isEquals();
    }

}