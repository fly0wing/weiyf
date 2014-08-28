package com.billing.product.orm.dao;

import com.billing.product.orm.model.EntryGoods;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-27 14:11:51.
 */
@MyBatisRepository
public interface EntryGoodsDao {

    EntryGoods get(@Param("id") Long id);

    List<EntryGoods> search(Map<String, Object> params);

    boolean save(EntryGoods obj);

    boolean update(EntryGoods obj);

    boolean delete(@Param("id") Long id);
}
