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
 * Created by gencode on 2014-8-27 14:11:53.
 */
public class GeoAssoc implements Serializable {
    private static final long serialVersionUID = 5454155825314635342L;

    /**
     * db_column: id
     * remarks from db:关联标识
     */
    private Long id;
    /**
     * db_column: geo_id
     * remarks from db:源地理标识
     */
    private Long geoId;
    /**
     * db_column: geo_id_to
     * remarks from db:关联地理标识
     */
    private Long geoIdTo;
    /**
     * db_column: geo_assoc_type_id
     * remarks from db:地理关联类型标识
     */
    private String geoAssocTypeId;
    /**
     * db_column: description
     * remarks from db:描述
     */
    private String description;

	public GeoAssoc() {
	}

	public GeoAssoc(
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

	public void setGeoId(Long value) {
		this.geoId = value;
	}

	public Long getGeoId() {
		return this.geoId;
	}

	public void setGeoIdTo(Long value) {
		this.geoIdTo = value;
	}

	public Long getGeoIdTo() {
		return this.geoIdTo;
	}

	public void setGeoAssocTypeId(String value) {
		this.geoAssocTypeId = value;
	}

	public String getGeoAssocTypeId() {
		return this.geoAssocTypeId;
	}

	public void setDescription(String value) {
		this.description = value;
	}

	public String getDescription() {
		return this.description;
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
        if(obj instanceof GeoAssoc == false) return false;
        if(this == obj) return true;
        GeoAssoc other = (GeoAssoc)obj;
        return new EqualsBuilder()
            .append(getId(),other.getId())
            .isEquals();
    }

}