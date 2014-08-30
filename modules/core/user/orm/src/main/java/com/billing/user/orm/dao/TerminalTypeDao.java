package com.billing.user.orm.dao;

import com.billing.user.orm.model.TerminalType;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-30 18:18:53.
 */
@MyBatisRepository
public interface TerminalTypeDao {
    public static final String SEQ_NAME = "terminal_type";

    TerminalType get(@Param(TerminalType.FN_terminalTypeId) Long terminalTypeId);

    List<TerminalType> search(Map<String, Object> params);

    boolean save(TerminalType obj);

    boolean update(TerminalType obj);

    boolean delete(@Param(TerminalType.FN_terminalTypeId) Long terminalTypeId);
}
