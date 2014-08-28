package com.billing.product.orm.dao;

import com.billing.product.orm.model.Product;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-27 14:12:03.
 */
@MyBatisRepository
public interface ProductDao {

    Product get(@Param("id") Long id);

    List<Product> search(Map<String, Object> params);

    boolean save(Product obj);

    boolean update(Product obj);

    boolean delete(@Param("id") Long id);

    Product getByPartyId(@Param("partyId")Long partyId);
}
