package com.billing.user.orm.dao;

import com.billing.user.orm.model.Terminal;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-26 16:12:41.
 */
@MyBatisRepository
public interface TerminalDao {

    Terminal get(@Param("id") Long id);

    List<Terminal> search(Map<String, Object> params);

    void save(Terminal obj);

    void update(Terminal obj);

    void delete(@Param("id") Long id);

    Terminal getByFingerprint(@Param("fingerprint")String fingerprint);
}
