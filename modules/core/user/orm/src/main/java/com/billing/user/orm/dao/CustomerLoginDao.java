package com.billing.user.orm.dao;

import com.billing.user.orm.model.CustomerLogin;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-30 18:18:52.
 */
@MyBatisRepository
public interface CustomerLoginDao {
    public static final String SEQ_NAME = "customer_login";

    CustomerLogin get(@Param(CustomerLogin.FN_id) Long id);

    List<CustomerLogin> search(Map<String, Object> params);

    boolean save(CustomerLogin obj);

    boolean update(CustomerLogin obj);

    boolean delete(@Param(CustomerLogin.FN_id) Long id);

    CustomerLogin getByLoginName(@Param(CustomerLogin.FN_loginName) String loginName);

    CustomerLogin getByLoginEmail(@Param(CustomerLogin.FN_loginEmail) String loginEmail);

    CustomerLogin getByLoginPhone(@Param(CustomerLogin.FN_loginPhone) String loginPhone);
}
