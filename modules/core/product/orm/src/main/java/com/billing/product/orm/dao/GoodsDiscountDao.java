package com.billing.product.orm.dao;

import com.billing.product.orm.model.GoodsDiscount;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-27 14:11:54.
 */
@MyBatisRepository
public interface GoodsDiscountDao {

    GoodsDiscount get(@Param("id") Long id);

    List<GoodsDiscount> search(Map<String, Object> params);

    boolean save(GoodsDiscount obj);

    boolean update(GoodsDiscount obj);

    boolean delete(@Param("id") Long id);
}
