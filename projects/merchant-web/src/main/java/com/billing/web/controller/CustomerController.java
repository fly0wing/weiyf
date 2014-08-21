package com.billing.web.controller;

import com.billing.web.model.Customer;
import com.billing.web.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by zhangkai on 2014/8/19.
 */
@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "getOne.do")
    public
    @ResponseBody
    Customer getOne(@RequestParam("id") final Long id,
                    ModelAndView modelAndView) {
        Customer customer = customerService.getOne(id);

        modelAndView.addObject(customer);
        return customer;
    }
}
