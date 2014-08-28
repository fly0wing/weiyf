package com.billing.product.orm.dao;

import com.billing.product.orm.model.AppCategoryType;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-27 14:11:48.
 */
@MyBatisRepository
public interface AppCategoryTypeDao {

    AppCategoryType get(@Param("app_category_type_id") String appCategoryTypeId);

    List<AppCategoryType> search(Map<String, Object> params);

    boolean save(AppCategoryType obj);

    boolean update(AppCategoryType obj);

    boolean delete(@Param("id") Long id);
}
