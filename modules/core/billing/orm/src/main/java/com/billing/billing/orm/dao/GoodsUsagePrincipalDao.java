package com.billing.billing.orm.dao;

import com.billing.billing.orm.model.GoodsUsagePrincipal;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-26 15:52:59.
 */
@MyBatisRepository
public interface GoodsUsagePrincipalDao {

    GoodsUsagePrincipal get(Long id);

    List<GoodsUsagePrincipal> search(Map<String, Object> params);

    void save(GoodsUsagePrincipal obj);

    void update(GoodsUsagePrincipal obj);

    void delete(Long id);
}
