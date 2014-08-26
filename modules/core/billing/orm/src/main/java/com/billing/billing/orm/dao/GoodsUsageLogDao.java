package com.billing.billing.orm.dao;

import com.billing.billing.orm.model.GoodsUsageLog;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-26 15:53:00.
 */
@MyBatisRepository
public interface GoodsUsageLogDao {

    GoodsUsageLog get(Long id);

    List<GoodsUsageLog> search(Map<String, Object> params);

    void save(GoodsUsageLog obj);

    void update(GoodsUsageLog obj);

    void delete(Long id);
}
