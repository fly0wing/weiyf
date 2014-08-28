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
 * Created by gencode on 2014-8-27 14:11:52.
 */
public class Geo implements Serializable {
    private static final long serialVersionUID = 5454155825314635342L;

    /**
     * db_column: id
     * remarks from db:地理标识
     */
    private Long id;
    /**
     * db_column: geo_type
     * remarks from db:地理类型
     */
    private String geoType;
    /**
     * db_column: geo_code
     * remarks from db:地理编码
     */
    private String geoCode;
    /**
     * db_column: geo_name
     * remarks from db:地理名称
     */
    private String geoName;
    /**
     * db_column: parent_code
     * remarks from db:上级编码
     */
    private Long parentCode;
    /**
     * db_column: level
     * remarks from db:地理层次
     */
    private Integer level;
    /**
     * db_column: geo_secdode
     * remarks from db:区域编码
     */
    private String geoSecdode;
    /**
     * db_column: abbreviation
     * remarks from db:缩写
     */
    private String abbreviation;
    /**
     * db_column: wellknownText
     * remarks from db:别名
     */
    private String wellknownText;

	public Geo() {
	}

	public Geo(
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

	public void setGeoType(String value) {
		this.geoType = value;
	}

	public String getGeoType() {
		return this.geoType;
	}

	public void setGeoCode(String value) {
		this.geoCode = value;
	}

	public String getGeoCode() {
		return this.geoCode;
	}

	public void setGeoName(String value) {
		this.geoName = value;
	}

	public String getGeoName() {
		return this.geoName;
	}

	public void setParentCode(Long value) {
		this.parentCode = value;
	}

	public Long getParentCode() {
		return this.parentCode;
	}

	public void setLevel(Integer value) {
		this.level = value;
	}

	public Integer getLevel() {
		return this.level;
	}

	public void setGeoSecdode(String value) {
		this.geoSecdode = value;
	}

	public String getGeoSecdode() {
		return this.geoSecdode;
	}

	public void setAbbreviation(String value) {
		this.abbreviation = value;
	}

	public String getAbbreviation() {
		return this.abbreviation;
	}

	public void setWellknownText(String value) {
		this.wellknownText = value;
	}

	public String getWellknownText() {
		return this.wellknownText;
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
        if(obj instanceof Geo == false) return false;
        if(this == obj) return true;
        Geo other = (Geo)obj;
        return new EqualsBuilder()
            .append(getId(),other.getId())
            .isEquals();
    }

}