package com.billing.product.orm.dao;

import com.billing.product.orm.model.UserLogin;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-27 14:12:09.
 */
@MyBatisRepository
public interface UserLoginDao {

    UserLogin get(@Param("user_login_id") String userLoginId);

    List<UserLogin> search(Map<String, Object> params);

    boolean save(UserLogin obj);

    boolean update(UserLogin obj);

    boolean delete(@Param("id") Long id);
}
