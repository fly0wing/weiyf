package com.billing.product.orm.dao;

import com.billing.product.orm.model.DiscountActivityLimit;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-27 14:11:50.
 */
@MyBatisRepository
public interface DiscountActivityLimitDao {

    DiscountActivityLimit get(@Param("id") Long id);

    List<DiscountActivityLimit> search(Map<String, Object> params);

    boolean save(DiscountActivityLimit obj);

    boolean update(DiscountActivityLimit obj);

    boolean delete(@Param("id") Long id);
}
