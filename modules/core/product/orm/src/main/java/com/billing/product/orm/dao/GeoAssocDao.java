package com.billing.product.orm.dao;

import com.billing.product.orm.model.GeoAssoc;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-27 14:11:53.
 */
@MyBatisRepository
public interface GeoAssocDao {

    GeoAssoc get(@Param("id") Long id);

    List<GeoAssoc> search(Map<String, Object> params);

    boolean save(GeoAssoc obj);

    boolean update(GeoAssoc obj);

    boolean delete(@Param("id") Long id);
}
