package com.billing.user.orm.dao;

import com.billing.user.orm.model.UserSession;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-30 18:18:54.
 */
@MyBatisRepository
public interface UserSessionDao {
    public static final String SEQ_NAME = "user_session";

    UserSession get(@Param(UserSession.FN_id) Long id);

    List<UserSession> search(Map<String, Object> params);

    boolean save(UserSession obj);

    boolean update(UserSession obj);

    boolean delete(@Param(UserSession.FN_id) Long id);
}
