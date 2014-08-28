package com.billing.product.orm.dao;

import com.billing.product.orm.model.GeoType;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-27 14:11:53.
 */
@MyBatisRepository
public interface GeoTypeDao {

    GeoType get(@Param("geo_type_id") String geoTypeId);

    List<GeoType> search(Map<String, Object> params);

    boolean save(GeoType obj);

    boolean update(GeoType obj);

    boolean delete(@Param("id") Long id);
}
