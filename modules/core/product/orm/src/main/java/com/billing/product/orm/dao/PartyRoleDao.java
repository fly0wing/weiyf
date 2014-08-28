package com.billing.product.orm.dao;

import com.billing.product.orm.model.PartyRole;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-27 14:11:58.
 */
@MyBatisRepository
public interface PartyRoleDao {

    PartyRole get(@Param("id") Long id);

    List<PartyRole> search(Map<String, Object> params);

    boolean save(PartyRole obj);

    boolean update(PartyRole obj);

    boolean delete(@Param("id") Long id);
}
