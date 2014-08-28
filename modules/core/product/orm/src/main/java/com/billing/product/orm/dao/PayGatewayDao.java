package com.billing.product.orm.dao;

import com.billing.product.orm.model.PayGateway;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-27 14:12:01.
 */
@MyBatisRepository
public interface PayGatewayDao {

    PayGateway get(@Param("pay_gateway_id") String payGatewayId);

    List<PayGateway> search(Map<String, Object> params);

    boolean save(PayGateway obj);

    boolean update(PayGateway obj);

    boolean delete(@Param("id") Long id);
}
