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

    TerminalActivate get(@Param("id") Long id);

    List<TerminalActivate> search(Map<String, Object> params);

    void save(TerminalActivate obj);

    void update(TerminalActivate obj);

    void delete(@Param("id") Long id);
}