package com.cg.healthyfy.daos;

import java.util.List;

import com.cg.healthyfy.domain.*;
import com.cg.healthyfy.exception.NoRecordFoundException;

public interface CustomerDAO {
public CustomerInfo saveCustomerDetail(CustomerInfo cust);

public CustomerInfo update_customer_details(CustomerInfo cust) throws NoRecordFoundException;

public CustomerInfo cancel_plan(CustomerInfo cust)throws NoRecordFoundException;

public CustomerInfo findByUser(int i)throws NoRecordFoundException;

public List<CustomerInfo> findAll();
}
