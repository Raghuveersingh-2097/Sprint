package com.cg.healthyfy.services;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import com.cg.healthyfy.daos.CustomerDAO;
import com.cg.healthyfy.daos.CustomerDAOImpl;
import com.cg.healthyfy.domain.CustomerInfo;
import com.cg.healthyfy.domain.LoginInfo;
import com.cg.healthyfy.exception.NoRecordFoundException;
import com.cg.healthyfy.menu.CustomerMenu;
import com.cg.healthyfy.menu.MainMenu;
import com.cg.healthyfy.util.SameUtilContainer;

public class CustomerServiceImpl extends SameUtilContainer implements CustomerService{
CustomerDAO custdao;
public CustomerServiceImpl() {
	custdao=new CustomerDAOImpl();
}
LoginInfo login=new LoginInfo();
public CustomerInfo adduser(CustomerInfo cust) {
    custdao.saveCustomerDetail(cust);
    return cust;
}
public CustomerInfo updateuser(CustomerInfo cust){
	int io1=0;
	int ini=cust.getId();
	try {
		Query query=em.createQuery("from CustomerInfo");
		List<CustomerInfo> customer= query.getResultList();
		for(CustomerInfo i:customer) {
			if(i.getId()==ini) {
				io1++;
				break;
			}
		}  
		Validate(io1);
	}
	catch(NoRecordFoundException m) {
		System.out.println(m);
	}if(io1==1) {
	custdao.update_customer_details(cust);
	}
	return cust;
}
public CustomerInfo deleteUser(CustomerInfo cust){
	int io1=0;
	int ini=cust.getId();
	try {
		Query query=em.createQuery("from CustomerInfo");
		List<CustomerInfo> customer= query.getResultList();
		for(CustomerInfo i:customer) {
			if(i.getId()==ini) {
				io1++;
				break;
			}
		}  
		Validate(io1);
	}
	catch(NoRecordFoundException m) {
		System.out.println(m);
	}if(io1==1) {
	custdao.cancel_plan(cust);
	}
	return cust;
}

public void loginAuthentication() throws NoRecordFoundException {
	 Scanner sc=new Scanner(System.in);
	
 	   System.out.println("Enter your ID:");
 	   int ini=sc.nextInt();
 	System.out.println("Enter Password:");
 	String password=sc.next();
 	int io=0;
     
		   Query query=em.createQuery("from LoginInfo");
		   List<LoginInfo> loginm= query.getResultList();
		   for(LoginInfo i:loginm) {
			  if(i.getId()==ini && i.getPassword().equals(password)) {
				  io++;
				  break;
			  }
		   }
		   if(io==0) {
			   System.out.println("Invalid User!!");
		   }
		   else {
			   MainMenu mains=new MainMenu();
			   mains.main_menu();		  
		   }
}
static void Validate(int io)throws NoRecordFoundException{
	if(io==0) {
		 throw new NoRecordFoundException("No Records Found");
	}
}
/*
@Override
public String customerUpdate(CustomerInfo cust) {
	cust=em.find(CustomerInfo.class, cust.getId());
	String gg=cust.getMedical_condition();
	return gg;
}
@Override
public String saveCustomer(CustomerInfo in) {
	// TODO Auto-generated method stub
	in=new CustomerInfo(in.getId(),in.getName(),in.getGender(),in.getDob(),in.getContact(),in.getMedical_condition(),in.getAllergicTo());
	return in.toString();
}
@Override
public int checkDelete(CustomerInfo cust) {
	// TODO Auto-generated method stub
	int i=0;
	cust=em.find(CustomerInfo.class, cust.getId());
	if(cust==null) {
		i=0;
	}
	else {
		em.remove(cust);
		i=1;
	}
	
	return i;
}*/
@Override
public List<CustomerInfo> findAll() {
	custdao.findAll();
	return null;
}
@Override
public int findUser(int i)throws NoRecordFoundException{
	int io1=0;
	try {
		Query query=em.createQuery("from CustomerInfo");
		List<CustomerInfo> customer= query.getResultList();
		for(CustomerInfo ii:customer) {
			if(ii.getId()==i) {
				io1++;
				break;
			}
		}  
		Validate(io1);
	}
	catch(NoRecordFoundException m) {
		System.out.println(m);
	}if(io1==1) {
	custdao.findByUser(i);
	}
	return i;
}
}
	
