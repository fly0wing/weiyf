package com.billing.product.orm.dao;

import com.billing.product.orm.model.Customer;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

/**
 * Created by zhangkai on 2014/8/22.
 */
@MyBatisRepository
public interface CustomerDao {
    Customer findById(@Param("id") Long id);
}
