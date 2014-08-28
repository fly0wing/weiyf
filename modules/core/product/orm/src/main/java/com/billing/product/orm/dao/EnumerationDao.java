package com.billing.product.orm.dao;

import com.billing.product.orm.model.Enumeration;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-27 14:11:51.
 */
@MyBatisRepository
public interface EnumerationDao {

    Enumeration get(@Param("enum_id") Integer enumId);

    List<Enumeration> search(Map<String, Object> params);

    boolean save(Enumeration obj);

    boolean update(Enumeration obj);

    boolean delete(@Param("id") Long id);
}
