package com.billing.product.orm.dao;

import com.billing.product.orm.model.StatusItem;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-27 14:12:06.
 */
@MyBatisRepository
public interface StatusItemDao {

    StatusItem get(@Param("status_id") Long statusId);

    List<StatusItem> search(Map<String, Object> params);

    boolean save(StatusItem obj);

    boolean update(StatusItem obj);

    boolean delete(@Param("id") Long id);
}
