package com.billing.product.orm.dao;

import com.billing.product.orm.model.StatusValidChange;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-27 14:12:08.
 */
@MyBatisRepository
public interface StatusValidChangeDao {

    StatusValidChange get(@Param("status_id") Long statusId, @Param("status_id_to") Long statusIdTo);

    List<StatusValidChange> search(Map<String, Object> params);

    boolean save(StatusValidChange obj);

    boolean update(StatusValidChange obj);

    boolean delete(@Param("id") Long id);
}
