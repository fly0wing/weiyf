package com.billing.user.orm.dao;

import com.billing.user.orm.model.UserSession;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-28 13:51:32.
 */
@MyBatisRepository
public interface UserSessionDao {

    UserSession get(@Param("id") Long id);

    List<UserSession> search(Map<String, Object> params);

    boolean save(UserSession obj);

    boolean update(UserSession obj);

    boolean delete(@Param("id") Long id);
}
