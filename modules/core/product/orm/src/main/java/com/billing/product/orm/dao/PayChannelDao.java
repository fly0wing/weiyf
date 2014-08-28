package com.billing.product.orm.dao;

import com.billing.product.orm.model.PayChannel;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-27 14:12:01.
 */
@MyBatisRepository
public interface PayChannelDao {

    PayChannel get(@Param("pay_channel_id") String payChannelId);

    List<PayChannel> search(Map<String, Object> params);

    boolean save(PayChannel obj);

    boolean update(PayChannel obj);

    boolean delete(@Param("id") Long id);
}
