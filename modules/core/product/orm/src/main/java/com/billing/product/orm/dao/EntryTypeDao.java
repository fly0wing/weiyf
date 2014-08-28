package com.billing.product.orm.dao;

import com.billing.product.orm.model.EntryType;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-27 14:11:51.
 */
@MyBatisRepository
public interface EntryTypeDao {

    EntryType get(@Param("entry_type_id") String entryTypeId);

    List<EntryType> search(Map<String, Object> params);

    boolean save(EntryType obj);

    boolean update(EntryType obj);

    boolean delete(@Param("id") Long id);
}
