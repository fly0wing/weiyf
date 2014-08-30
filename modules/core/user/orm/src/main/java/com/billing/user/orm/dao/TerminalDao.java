package com.billing.user.orm.dao;

import com.billing.user.orm.model.Terminal;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-30 18:18:53.
 */
@MyBatisRepository
public interface TerminalDao {
    public static final String SEQ_NAME = "terminal";

    Terminal get(@Param(Terminal.FN_id) Long id);

    List<Terminal> search(Map<String, Object> params);

    boolean save(Terminal obj);

    boolean update(Terminal obj);

    boolean delete(@Param(Terminal.FN_id) Long id);

    Terminal getByFingerprint(@Param(Terminal.FN_fingerprint) String fingerprint);
}
