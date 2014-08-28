package com.billing.product.orm.dao;

import com.billing.product.orm.model.SequenceValueItem;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-27 14:12:06.
 */
@MyBatisRepository
public interface SequenceValueItemDao {

    SequenceValueItem get(@Param("seq_name") String seqName);

    List<SequenceValueItem> search(Map<String, Object> params);

    boolean save(SequenceValueItem obj);

    boolean update(SequenceValueItem obj);

    boolean delete(@Param("id") Long id);
}
