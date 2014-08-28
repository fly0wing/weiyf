package com.billing.user.orm.dao;

import com.billing.user.orm.model.CustomerTerminal;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-26 16:12:41.
 */
@MyBatisRepository
public interface CustomerTerminalDao {

    CustomerTerminal get(@Param("id") Long id);

    List<CustomerTerminal> search(Map<String, Object> params);

    boolean save(CustomerTerminal obj);

    boolean update(CustomerTerminal obj);

    boolean delete(@Param("id") Long id);
}
