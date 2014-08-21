package com.billing.web.service;

import com.billing.web.dao.CustomerDao;
import com.billing.web.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhangkai on 2014/8/19.
 */
@Service
public class CustomerService {
    @Autowired
    private CustomerDao customerDao;

    public Customer getOne(Long id) {
        return customerDao.getOne(id);
    }
}
