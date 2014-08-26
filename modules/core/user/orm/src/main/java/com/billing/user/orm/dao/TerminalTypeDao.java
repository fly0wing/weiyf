package com.billing.user.orm.dao;

import com.billing.user.orm.model.TerminalType;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-26 16:12:41.
 */
@MyBatisRepository
public interface TerminalTypeDao {

    TerminalType get(@Param("id") Long id);

    List<TerminalType> search(Map<String, Object> params);

    void save(TerminalType obj);

    void update(TerminalType obj);

    void delete(@Param("id") Long id);
}