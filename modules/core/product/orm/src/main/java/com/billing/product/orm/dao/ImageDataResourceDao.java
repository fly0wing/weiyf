package com.billing.product.orm.dao;

import com.billing.product.orm.model.ImageDataResource;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-27 14:11:55.
 */
@MyBatisRepository
public interface ImageDataResourceDao {

    ImageDataResource get(@Param("data_resource_id") Long dataResourceId);

    List<ImageDataResource> search(Map<String, Object> params);

    boolean save(ImageDataResource obj);

    boolean update(ImageDataResource obj);

    boolean delete(@Param("id") Long id);
}
