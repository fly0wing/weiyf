package com.billing.web.dao;

import com.billing.web.model.Customer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by zhangkai on 2014/8/19.
 */
@Repository
public interface CustomerDao {
    public Customer getOne(@Param("id") long id);
}
