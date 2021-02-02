package com.cg.healthyfy.daos;
import java.util.List;

import javax.persistence.Query;

import com.cg.healthyfy.domain.CustomerInfo;
import com.cg.healthyfy.domain.LoginInfo;
import com.cg.healthyfy.exception.NoRecordFoundException;
import com.cg.healthyfy.util.SameUtilContainer;

public class CustomerDAOImpl extends SameUtilContainer implements CustomerDAO{
	@Override
	public CustomerInfo saveCustomerDetail(CustomerInfo in){
	  LoginInfo log=new LoginInfo();	
	  em.getTransaction().begin();
      em.persist(in);
      log.setId(in.getId());
	  log.setPassword(in.getName()+in.getId());
      em.persist(log);
      System.out.println("Welcome Our New User: "+in.getName()+"\nYour LoginId is: "+log.getId()+"\nYour Password is: "+log.getPassword());
      em.getTransaction().commit();
      return in;
}	
	@Override
	public CustomerInfo update_customer_details(CustomerInfo cust) {
		String newContact=cust.getContact();
		String newMedical=cust.getMedicalCondition();
		String newAllergic=cust.getAllergicTo();
		em.getTransaction().begin();
		cust=em.find(CustomerInfo.class, cust.getId());
		cust.setContact(newContact);
		cust.setMedicalCondition(newMedical);
		cust.setAllergicTo(newAllergic);
		em.persist(cust);
		System.out.println("Your Details Are Updated....");
		em.getTransaction().commit();
		return cust;		
	}
	@Override
	public CustomerInfo cancel_plan(CustomerInfo cust)throws NoRecordFoundException{
		em.getTransaction().begin();
		cust=em.find(CustomerInfo.class, cust.getId());
		em.remove(cust);
		//em.remove(log);
		System.out.println("Your Plan is Cancelled");
		em.getTransaction().commit(); 
		return cust;
		}
	/*
	@Override
	public String userData(CustomerInfo cust)throws NoRecordFoundException {
		cust=em.find(CustomerInfo.class, cust.getId());
		String h=cust.getName();
		em.getTransaction().begin();
		   System.out.println("ID: "+cust.getId()+"\n"+"Name: "+cust.getName()+"\n"+"Contact: "+cust.getContact());
		   System.out.println("Gender: "+cust.getGender()+"\nDOB: "+cust.getDob()+"\nMedical Condition: "+cust.getMedical_condition());
		   em.getTransaction().commit();
		   return cust.getName();
		   }
	@Override
	public String saveCustomerDetails(CustomerInfo in) {
		in=new CustomerInfo(in.getId(),in.getName(),in.getGender(),in.getDob(),in.getContact(),in.getMedical_condition(),in.getAllergicTo());
		return in.toString();
	}
	@Override
	public String customerDaoupdate(CustomerInfo cust) {
		String newContact=cust.getContact();
		String newMedical=cust.getMedical_condition();
		String newAllergic=cust.getAllergicTo();
			return cust.toString();
	}
	*/
	@Override
	public List<CustomerInfo> findAll() {
		// TODO Auto-generated method stub
		Query query=em.createQuery("from CustomerInfo");
		@SuppressWarnings("unchecked")
		List<CustomerInfo> list=(List<CustomerInfo>)query.getResultList();
		for(CustomerInfo c:list) {
			System.out.println("Customer ID: "+c.getId());
			System.out.println("Name: "+c.getName());
			System.out.println("Gender: "+c.getGender());
			System.out.println("Date Of Birth: "+c.getDob());
			System.out.println("Contact Number:"+c.getContact());
			System.out.println("Medical Condition: "+c.getMedicalCondition()+"\nAllergy To: "+c.getAllergicTo());
			System.out.println("\n");
		}
		return list;
	}
	@Override
	public CustomerInfo findByUser(int i) throws NoRecordFoundException {
		// TODO Auto-generated method stub
		CustomerInfo cust=new CustomerInfo();
		cust=em.find(CustomerInfo.class, i);
		em.getTransaction().begin();
		System.out.println("Customer ID: "+cust.getId());
		System.out.println("Name: "+cust.getName());
		System.out.println("Gender: "+cust.getGender());
		System.out.println("Date Of Birth: "+cust.getDob());
		System.out.println("Contact Number:"+cust.getContact());
		System.out.println("Medical Condition: "+cust.getMedicalCondition()+"\nAllergy To: "+cust.getAllergicTo());
		em.getTransaction().commit(); 
		return cust;
	}
}

