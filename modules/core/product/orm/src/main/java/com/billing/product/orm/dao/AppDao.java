package com.billing.product.orm.dao;

import com.billing.product.orm.model.App;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-27 14:11:46.
 */
@MyBatisRepository
public interface AppDao {

    App get(@Param("id") Long id);

    List<App> search(Map<String, Object> params);

    boolean save(App obj);

    boolean update(App obj);

    boolean delete(@Param("id") Long id);
}
