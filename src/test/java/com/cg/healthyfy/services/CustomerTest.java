package com.cg.healthyfy.services;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.cg.healthyfy.daos.CustomerDAO;
import com.cg.healthyfy.daos.CustomerDAOImpl;
import com.cg.healthyfy.domain.CustomerInfo;
import com.cg.healthyfy.exception.NoRecordFoundException;

public class CustomerTest {
	private static CustomerService service;
	private static CustomerDAO dao;
	private CustomerInfo customer1,customer2,customer3;
	@BeforeClass
	public static  void setUpTestEnv() {
		dao= new CustomerDAOImpl();
		service = new CustomerServiceImpl();
	}
	@Before 
	public void setUpTestMockData() {
		customer1=new CustomerInfo("Raghav Singh","Male","20-07-1997","7458059664","FIT","Zomato");
		customer2=new CustomerInfo("Umang Rai","Male","20-03-1997","9193458763","FIT","OLA");
		customer1=dao.saveCustomerDetail(customer1);
	}
	
	
	
	@Test
	public void showCustomerDetailsInvalid(){
		service.findUser(24);
	}
	/*
	@Test
	public void addCustomerDetails() {
		CustomerInfo custInfo=dao.findByUser(customer1.getId());
		assertEquals(custInfo,customer1);
	}
	@Test
	public void showCustomerDetailsvalid(){
		service.findUser(1);
	}
	@Test
	public void showCustomerDetailsException(){
		CustomerInfo customer=service.updateuser(customer2);
		assertEquals(customer,customer2);
	}
	*/
	
	@After 
	public void tearDownTestMockData() {
		dao.cancel_plan(customer1);
	}
	@AfterClass
	public static  void tearDownTestEnv() {
		service = null;
		dao= null;
	}
	}

