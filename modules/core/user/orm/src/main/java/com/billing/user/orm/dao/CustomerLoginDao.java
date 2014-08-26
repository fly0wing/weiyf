package com.billing.user.orm.dao;

import com.billing.user.orm.model.CustomerLogin;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-26 15:19:36.
 */
@MyBatisRepository
public interface CustomerLoginDao {

    CustomerLogin get(Long id);

    List<CustomerLogin> search(Map<String, Object> params);

    void save(CustomerLogin obj);

    void update(CustomerLogin obj);

    void delete(Long id);

    CustomerLogin getByLoginName(String v);

    CustomerLogin getByLoginEmail(String v);

    CustomerLogin getByLoginPhone(String v);
}
