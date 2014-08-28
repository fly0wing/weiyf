package com.billing.product.orm.dao;

import com.billing.product.orm.model.PartyContactMech;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-27 14:11:55.
 */
@MyBatisRepository
public interface PartyContactMechDao {

    PartyContactMech get(@Param("id") Long id);

    List<PartyContactMech> search(Map<String, Object> params);

    boolean save(PartyContactMech obj);

    boolean update(PartyContactMech obj);

    boolean delete(@Param("id") Long id);
}
