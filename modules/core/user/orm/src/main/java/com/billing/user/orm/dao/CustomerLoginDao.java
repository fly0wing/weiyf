package com.billing.user.orm.dao;

import com.billing.user.orm.model.CustomerLogin;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-26 16:12:40.
 */
@MyBatisRepository
public interface CustomerLoginDao {

    CustomerLogin get(@Param("id") Long id);

    List<CustomerLogin> search(Map<String, Object> params);

    boolean save(CustomerLogin obj);

    boolean update(CustomerLogin obj);

    boolean delete(@Param("id") Long id);

    CustomerLogin getByLoginName(@Param("loginName")String loginName);

    CustomerLogin getByLoginEmail(@Param("loginEmail")String loginEmail);

    CustomerLogin getByLoginPhone(@Param("loginPhone")String loginPhone);
}
