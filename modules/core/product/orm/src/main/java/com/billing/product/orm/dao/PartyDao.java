package com.billing.product.orm.dao;

import com.billing.product.orm.model.Party;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-27 14:11:55.
 */
@MyBatisRepository
public interface PartyDao {

    Party get(@Param("id") Long id);

    List<Party> search(Map<String, Object> params);

    boolean save(Party obj);

    boolean update(Party obj);

    boolean delete(@Param("id") Long id);
}
