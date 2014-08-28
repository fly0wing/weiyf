package com.billing.product.orm.dao;

import com.billing.product.orm.model.PartyType;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-27 14:11:59.
 */
@MyBatisRepository
public interface PartyTypeDao {

    PartyType get(@Param("party_type_id") String partyTypeId);

    List<PartyType> search(Map<String, Object> params);

    boolean save(PartyType obj);

    boolean update(PartyType obj);

    boolean delete(@Param("id") Long id);
}
