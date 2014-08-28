package com.billing.product.orm.dao;

import com.billing.product.orm.model.PartyContentType;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-27 14:11:57.
 */
@MyBatisRepository
public interface PartyContentTypeDao {

    PartyContentType get(@Param("party_content_type_id") String partyContentTypeId);

    List<PartyContentType> search(Map<String, Object> params);

    boolean save(PartyContentType obj);

    boolean update(PartyContentType obj);

    boolean delete(@Param("id") Long id);
}
