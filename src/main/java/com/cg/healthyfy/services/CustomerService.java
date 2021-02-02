package com.cg.healthyfy.services;

import java.util.List;

import com.cg.healthyfy.domain.CustomerInfo;

public interface CustomerService {
	
public CustomerInfo adduser(CustomerInfo cust);

public CustomerInfo updateuser(CustomerInfo cust);

public CustomerInfo deleteUser(CustomerInfo cust);

public int findUser(int i);

public List<CustomerInfo> findAll();

}
