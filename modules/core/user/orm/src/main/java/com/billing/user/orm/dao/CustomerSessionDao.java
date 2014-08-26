package com.billing.user.orm.dao;

import com.billing.user.orm.model.CustomerSession;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-26 16:12:40.
 */
@MyBatisRepository
public interface CustomerSessionDao {

    CustomerSession get(@Param("id") Long id);

    List<CustomerSession> search(Map<String, Object> params);

    boolean save(CustomerSession obj);

    boolean update(CustomerSession obj);

    boolean delete(@Param("id") Long id);
}
