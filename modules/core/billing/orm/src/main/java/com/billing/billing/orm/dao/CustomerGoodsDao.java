package com.billing.billing.orm.dao;

import com.billing.billing.orm.model.CustomerGoods;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-26 15:52:58.
 */
@MyBatisRepository
public interface CustomerGoodsDao {

    CustomerGoods get(Long id);

    List<CustomerGoods> search(Map<String, Object> params);

    void save(CustomerGoods obj);

    void update(CustomerGoods obj);

    void delete(Long id);
}
