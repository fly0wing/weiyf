package com.billing.product.orm.dao;

import com.billing.product.orm.model.StatusType;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-27 14:12:07.
 */
@MyBatisRepository
public interface StatusTypeDao {

    StatusType get(@Param("status_type_id") String statusTypeId);

    List<StatusType> search(Map<String, Object> params);

    boolean save(StatusType obj);

    boolean update(StatusType obj);

    boolean delete(@Param("id") Long id);
}
