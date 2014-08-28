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
public class GeoAssocType implements Serializable {
    private static final long serialVersionUID = 5454155825314635342L;

    /**
     * db_column: geo_assoc_type_id
     * remarks from db:地理关联类型标识
     */
    private String geoAssocTypeId;
    /**
     * db_column: parent_type_id
     * remarks from db:父类型标识
     */
    private String parentTypeId;
    /**
     * db_column: description
     * remarks from db:描述
     */
    private String description;

	public GeoAssocType() {
	}

	public GeoAssocType(
		String geoAssocTypeId
	) {
		this.geoAssocTypeId = geoAssocTypeId;
	}

	public void setGeoAssocTypeId(String value) {
		this.geoAssocTypeId = value;
	}

	public String getGeoAssocTypeId() {
		return this.geoAssocTypeId;
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


    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getGeoAssocTypeId())
            .toHashCode();
    }

    public boolean equals(Object obj) {
        if(obj instanceof GeoAssocType == false) return false;
        if(this == obj) return true;
        GeoAssocType other = (GeoAssocType)obj;
        return new EqualsBuilder()
            .append(getGeoAssocTypeId(),other.getGeoAssocTypeId())
            .isEquals();
    }

}