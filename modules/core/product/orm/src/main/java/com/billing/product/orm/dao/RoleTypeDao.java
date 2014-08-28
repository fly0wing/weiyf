package com.billing.product.orm.dao;

import com.billing.product.orm.model.RoleType;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-27 14:12:03.
 */
@MyBatisRepository
public interface RoleTypeDao {

    RoleType get(@Param("role_type_id") String roleTypeId);

    List<RoleType> search(Map<String, Object> params);

    boolean save(RoleType obj);

    boolean update(RoleType obj);

    boolean delete(@Param("id") Long id);
}
