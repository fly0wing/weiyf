package com.billing.product.orm.dao;

import com.billing.product.orm.model.Goods;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-27 14:11:54.
 */
@MyBatisRepository
public interface GoodsDao {

    Goods get(@Param("id") Long id);

    List<Goods> search(Map<String, Object> params);

    boolean save(Goods obj);

    boolean update(Goods obj);

    boolean delete(@Param("id") Long id);
}
