package com.billing.product.orm.dao;

import com.billing.product.orm.model.EnumerationType;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-27 14:11:52.
 */
@MyBatisRepository
public interface EnumerationTypeDao {

    EnumerationType get(@Param("enum_type_id") String enumTypeId);

    List<EnumerationType> search(Map<String, Object> params);

    boolean save(EnumerationType obj);

    boolean update(EnumerationType obj);

    boolean delete(@Param("id") Long id);
}
