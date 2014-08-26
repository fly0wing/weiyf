package com.billing.user.orm.dao;

import com.billing.user.orm.model.CustomerSessionDurable;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-26 15:19:36.
 */
@MyBatisRepository
public interface CustomerSessionDurableDao {

    CustomerSessionDurable get(Long id);

    List<CustomerSessionDurable> search(Map<String, Object> params);

    void save(CustomerSessionDurable obj);

    void update(CustomerSessionDurable obj);

    void delete(Long id);
}
