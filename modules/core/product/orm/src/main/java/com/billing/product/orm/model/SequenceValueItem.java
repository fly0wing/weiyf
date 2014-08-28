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
 * Created by gencode on 2014-8-27 14:12:06.
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

}