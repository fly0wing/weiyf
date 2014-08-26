package com.billing.user.orm.dao;

import com.billing.user.orm.model.CustomerSession;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-26 15:19:36.
 */
@MyBatisRepository
public interface CustomerSessionDao {

    CustomerSession get(Long id);

    List<CustomerSession> search(Map<String, Object> params);

    void save(CustomerSession obj);

    void update(CustomerSession obj);

    void delete(Long id);
}
