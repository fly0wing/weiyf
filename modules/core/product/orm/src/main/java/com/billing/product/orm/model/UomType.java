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
public class UomType implements Serializable {
    private static final long serialVersionUID = 5454155825314635342L;

    /**
     * db_column: uom_type_id
     * remarks from db:计量单位类型标识
     */
    private String uomTypeId;
    /**
     * db_column: parent_type_id
     */
    private String parentTypeId;
    /**
     * db_column: description
     */
    private String description;
    /**
     * db_column: last_updated_stamp
     */
    private Timestamp lastUpdatedStamp;
    /**
     * db_column: created_stamp
     */
    private Timestamp createdStamp;

	public UomType() {
	}

	public UomType(
		String uomTypeId
	) {
		this.uomTypeId = uomTypeId;
	}

	public void setUomTypeId(String value) {
		this.uomTypeId = value;
	}

	public String getUomTypeId() {
		return this.uomTypeId;
	}

	public void setParentTypeId(String value) {
		this.parentTypeId = value;
	}

	public String getParentTypeId() {
		return this.parentTypeId;
	}

	public void setDescription(String value) {
		this.description = value;
	}

	public String getDescription() {
		return this.description;
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


	private Set uomTypes = new HashSet(0);
	public void setUomTypes(Set<UomType> uomType){
		this.uomTypes = uomType;
	}

	public Set<UomType> getUomTypes() {
		return uomTypes;
	}

	private Set uoms = new HashSet(0);
	public void setUoms(Set<Uom> uom){
		this.uoms = uom;
	}

	public Set<Uom> getUoms() {
		return uoms;
	}

	private UomType uomType;

	public void setUomType(UomType uomType){
		this.uomType = uomType;
	}

	public UomType getUomType() {
		return uomType;
	}

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getUomTypeId())
            .toHashCode();
    }

    public boolean equals(Object obj) {
        if(obj instanceof UomType == false) return false;
        if(this == obj) return true;
        UomType other = (UomType)obj;
        return new EqualsBuilder()
            .append(getUomTypeId(),other.getUomTypeId())
            .isEquals();
    }

}