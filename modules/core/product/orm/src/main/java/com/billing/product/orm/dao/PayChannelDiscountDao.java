package com.billing.product.orm.dao;

import com.billing.product.orm.model.PayChannelDiscount;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-27 14:12:01.
 */
@MyBatisRepository
public interface PayChannelDiscountDao {

    PayChannelDiscount get(@Param("id") Long id);

    List<PayChannelDiscount> search(Map<String, Object> params);

    boolean save(PayChannelDiscount obj);

    boolean update(PayChannelDiscount obj);

    boolean delete(@Param("id") Long id);
}
