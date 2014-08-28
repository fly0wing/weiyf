package com.billing.product.orm.dao;

import com.billing.product.orm.model.ContactMechType;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-27 14:11:49.
 */
@MyBatisRepository
public interface ContactMechTypeDao {

    ContactMechType get(@Param("contact_mech_type_id") String contactMechTypeId);

    List<ContactMechType> search(Map<String, Object> params);

    boolean save(ContactMechType obj);

    boolean update(ContactMechType obj);

    boolean delete(@Param("id") Long id);
}
