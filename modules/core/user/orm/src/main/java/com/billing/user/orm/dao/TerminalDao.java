package com.billing.user.orm.dao;

import com.billing.user.orm.model.Terminal;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-26 15:19:37.
 */
@MyBatisRepository
public interface TerminalDao {

    Terminal get(Long id);

    List<Terminal> search(Map<String, Object> params);

    void save(Terminal obj);

    void update(Terminal obj);

    void delete(Long id);

    Terminal getByFingerprint(String v);
}
