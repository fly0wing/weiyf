package com.billing.product.orm.dao;

import com.billing.product.orm.model.ContactMechFinance;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-27 14:11:49.
 */
@MyBatisRepository
public interface ContactMechFinanceDao {

    ContactMechFinance get(@Param("id") Long id);

    List<ContactMechFinance> search(Map<String, Object> params);

    boolean save(ContactMechFinance obj);

    boolean update(ContactMechFinance obj);

    boolean delete(@Param("id") Long id);
}
