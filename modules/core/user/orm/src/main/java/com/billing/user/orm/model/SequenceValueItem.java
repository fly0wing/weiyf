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
 * Created by gencode on 2014-8-29 10:07:18.
 */
public class SequenceValueItem implements Serializable {
    private static final long serialVersionUID = 5454155825314635342L;

    /**
     * db_column: seq_name
     * remarks from db:序号名称
     */
    private String seqName;
    /**
     * db_column: seq_id
     * remarks from db:序号
     */
    private Long seqId;
    /**
     * db_column: crash_skip_number
     * remarks from db:异常跳过数
     */
    private Integer crashSkipNumber;
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

	public SequenceValueItem() {
	}

	public SequenceValueItem(
		String seqName
	) {
		this.seqName = seqName;
	}

	public void setSeqName(String value) {
		this.seqName = value;
	}

	public String getSeqName() {
		return this.seqName;
	}

	public void setSeqId(Long value) {
		this.seqId = value;
	}

	public Long getSeqId() {
		return this.seqId;
	}

	public void setCrashSkipNumber(Integer value) {
		this.crashSkipNumber = value;
	}

	public Integer getCrashSkipNumber() {
		return this.crashSkipNumber;
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


    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getSeqName())
            .toHashCode();
    }

    public boolean equals(Object obj) {
        if(obj instanceof SequenceValueItem == false) return false;
        if(this == obj) return true;
        SequenceValueItem other = (SequenceValueItem)obj;
        return new EqualsBuilder()
            .append(getSeqName(),other.getSeqName())
            .isEquals();
    }

    public static final String FN_seqName = "seqName";
    public static final String FN_seqId = "seqId";
    public static final String FN_crashSkipNumber = "crashSkipNumber";
    public static final String FN_description = "description";
    public static final String FN_lastModifiedDate = "lastModifiedDate";
    public static final String FN_lastModifiedByUserLogin = "lastModifiedByUserLogin";
    public static final String FN_createdDate = "createdDate";
    public static final String FN_createdByUserLogin = "createdByUserLogin";

}