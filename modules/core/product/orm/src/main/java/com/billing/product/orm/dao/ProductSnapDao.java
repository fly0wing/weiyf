package com.billing.product.orm.dao;

import com.billing.product.orm.model.ProductSnap;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-27 14:12:03.
 */
@MyBatisRepository
public interface ProductSnapDao {

    ProductSnap get(@Param("id") Long id);

    List<ProductSnap> search(Map<String, Object> params);

    boolean save(ProductSnap obj);

    boolean update(ProductSnap obj);

    boolean delete(@Param("id") Long id);

    ProductSnap getByPartyId(@Param("partyId")Long partyId);
}
