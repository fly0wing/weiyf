package com.billing.user.orm.dao;

import com.billing.user.orm.business_model.TerminalInfo;
import com.billing.user.orm.model.CustomerTerminal;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-30 18:18:52.
 */
@MyBatisRepository
public interface CustomerTerminalDao {
    public static final String SEQ_NAME = "customer_terminal";

    CustomerTerminal get(@Param(CustomerTerminal.FN_id) Long id);

    List<CustomerTerminal> search(Map<String, Object> params);

    boolean save(CustomerTerminal obj);

    boolean update(CustomerTerminal obj);

    boolean delete(@Param(CustomerTerminal.FN_id) Long id);

    List<TerminalInfo> getBindTerms(Map<String, Object> params);

    List<TerminalInfo> getTermsByFingerPrint(Map<String, Object> params);
}
