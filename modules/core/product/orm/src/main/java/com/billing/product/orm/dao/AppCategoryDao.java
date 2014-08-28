package com.billing.product.orm.dao;

import com.billing.product.orm.model.AppCategory;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-27 14:11:47.
 */
@MyBatisRepository
public interface AppCategoryDao {

    AppCategory get(@Param("app_category_id") Long appCategoryId);

    List<AppCategory> search(Map<String, Object> params);

    boolean save(AppCategory obj);

    boolean update(AppCategory obj);

    boolean delete(@Param("id") Long id);
}
