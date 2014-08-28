package com.billing.product.orm.dao;

import com.billing.product.orm.model.Geo;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-27 14:11:52.
 */
@MyBatisRepository
public interface GeoDao {

    Geo get(@Param("id") Long id);

    List<Geo> search(Map<String, Object> params);

    boolean save(Geo obj);

    boolean update(Geo obj);

    boolean delete(@Param("id") Long id);
}
