package com.billing.user.orm.dao;

import com.billing.user.orm.model.SequenceValueItem;
import com.billing.utils.mybatis.MyBatisRepository;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by gencode on 2014-8-30 18:18:53.
 */
@MyBatisRepository
public interface SequenceValueItemDao {
    public static final String SEQ_NAME = "sequence_value_item";

    SequenceValueItem get(@Param(SequenceValueItem.FN_seqName) String seqName);

    List<SequenceValueItem> search(Map<String, Object> params);

    boolean save(SequenceValueItem obj);

    boolean update(SequenceValueItem obj);

    boolean delete(@Param(SequenceValueItem.FN_seqName) String seqName);
}
