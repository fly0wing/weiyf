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
 * Created by gencode on 2014-8-27 14:11:55.
 */
public class ImageDataResource implements Serializable {
    private static final long serialVersionUID = 5454155825314635342L;

    /**
     * db_column: data_resource_id
     * remarks from db:数据资源标识
     */
    private Long dataResourceId;
    /**
     * db_column: image_data
     * remarks from db:图像数据
     */
    private byte[] imageData;
    /**
     * db_column: last_updated_stamp
     */
    private Timestamp lastUpdatedStamp;
    /**
     * db_column: created_stamp
     */
    private Timestamp createdStamp;

	public ImageDataResource() {
	}

	public ImageDataResource(
		Long dataResourceId
	) {
		this.dataResourceId = dataResourceId;
	}

	public void setDataResourceId(Long value) {
		this.dataResourceId = value;
	}

	public Long getDataResourceId() {
		return this.dataResourceId;
	}

	public void setImageData(byte[] value) {
		this.imageData = value;
	}

	public byte[] getImageData() {
		return this.imageData;
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
            .append(getDataResourceId())
            .toHashCode();
    }

    public boolean equals(Object obj) {
        if(obj instanceof ImageDataResource == false) return false;
        if(this == obj) return true;
        ImageDataResource other = (ImageDataResource)obj;
        return new EqualsBuilder()
            .append(getDataResourceId(),other.getDataResourceId())
            .isEquals();
    }

}