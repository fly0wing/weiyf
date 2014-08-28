package com.billing.product.orm.dao;

import com.billing.product.orm.model.GeoAssocType;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-27 14:11:53.
 */
@MyBatisRepository
public interface GeoAssocTypeDao {

    GeoAssocType get(@Param("geo_assoc_type_id") String geoAssocTypeId);

    List<GeoAssocType> search(Map<String, Object> params);

    boolean save(GeoAssocType obj);

    boolean update(GeoAssocType obj);

    boolean delete(@Param("id") Long id);
}
