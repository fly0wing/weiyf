package com.billing.product.orm.dao;

import com.billing.product.orm.model.PartyGroup;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-27 14:11:57.
 */
@MyBatisRepository
public interface PartyGroupDao {

    PartyGroup get(@Param("id") Long id);

    List<PartyGroup> search(Map<String, Object> params);

    boolean save(PartyGroup obj);

    boolean update(PartyGroup obj);

    boolean delete(@Param("id") Long id);
}
