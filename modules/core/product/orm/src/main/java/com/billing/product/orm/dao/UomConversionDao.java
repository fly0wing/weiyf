package com.billing.product.orm.dao;

import com.billing.product.orm.model.UomConversion;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-27 14:12:09.
 */
@MyBatisRepository
public interface UomConversionDao {

    UomConversion get(@Param("uom_id") String uomId, @Param("uom_id_to") String uomIdTo);

    List<UomConversion> search(Map<String, Object> params);

    boolean save(UomConversion obj);

    boolean update(UomConversion obj);

    boolean delete(@Param("id") Long id);
}
