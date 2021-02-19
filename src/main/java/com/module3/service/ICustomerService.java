package com.module3.service;

import com.module3.model.Customer;

import java.util.List;

public interface ICustomerService extends IGenaricService<Customer>{
    List<Customer> findName(String name);
}
