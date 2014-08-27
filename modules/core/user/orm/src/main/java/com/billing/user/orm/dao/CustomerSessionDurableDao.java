package com.billing.user.orm.dao;

import com.billing.user.orm.model.CustomerSessionDurable;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-26 16:12:41.
 */
@MyBatisRepository
public interface CustomerSessionDurableDao {

    CustomerSessionDurable get(@Param("id") Long id);

    List<CustomerSessionDurable> search(Map<String, Object> params);

    boolean save(CustomerSessionDurable obj);

    boolean update(CustomerSessionDurable obj);

    boolean delete(@Param("id") Long id);
}
