package com.billing.product.orm.dao;

import com.billing.product.orm.model.Uom;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-27 14:12:08.
 */
@MyBatisRepository
public interface UomDao {

    Uom get(@Param("uom_id") String uomId);

    List<Uom> search(Map<String, Object> params);

    boolean save(Uom obj);

    boolean update(Uom obj);

    boolean delete(@Param("id") Long id);
}
