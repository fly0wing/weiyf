package com.billing.product.orm.dao;

import com.billing.product.orm.model.PartyContent;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-27 14:11:56.
 */
@MyBatisRepository
public interface PartyContentDao {

    PartyContent get(@Param("id") Integer id);

    List<PartyContent> search(Map<String, Object> params);

    boolean save(PartyContent obj);

    boolean update(PartyContent obj);

    boolean delete(@Param("id") Long id);
}
