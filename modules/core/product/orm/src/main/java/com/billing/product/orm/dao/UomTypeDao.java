package com.billing.product.orm.dao;

import com.billing.product.orm.model.UomType;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-27 14:12:09.
 */
@MyBatisRepository
public interface UomTypeDao {

    UomType get(@Param("uom_type_id") String uomTypeId);

    List<UomType> search(Map<String, Object> params);

    boolean save(UomType obj);

    boolean update(UomType obj);

    boolean delete(@Param("id") Long id);
}
