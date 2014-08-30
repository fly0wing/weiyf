package com.billing.user.orm.dao;

import com.billing.user.orm.model.TerminalActivate;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-26 16:12:41.
 */
@MyBatisRepository
public interface TerminalActivateDao {
    public static final String SEQ_NAME = "terminal_activate";

    TerminalActivate get(@Param(TerminalActivate.FN_id) Long id);

    List<TerminalActivate> search(Map<String, Object> params);

    boolean save(TerminalActivate obj);

    boolean update(TerminalActivate obj);

    boolean delete(@Param(TerminalActivate.FN_id) Long id);
    
    TerminalActivate getMaxActiveTime(@Param(TerminalActivate.FN_terminalId) Long id);
}
