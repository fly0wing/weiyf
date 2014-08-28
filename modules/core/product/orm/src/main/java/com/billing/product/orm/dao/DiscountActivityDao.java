package com.billing.product.orm.dao;

import com.billing.product.orm.model.DiscountActivity;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-27 14:11:50.
 */
@MyBatisRepository
public interface DiscountActivityDao {

    DiscountActivity get(@Param("id") Long id);

    List<DiscountActivity> search(Map<String, Object> params);

    boolean save(DiscountActivity obj);

    boolean update(DiscountActivity obj);

    boolean delete(@Param("id") Long id);
}
