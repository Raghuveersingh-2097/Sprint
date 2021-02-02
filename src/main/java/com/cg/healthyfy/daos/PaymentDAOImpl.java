package com.cg.healthyfy.daos;

import com.cg.healthyfy.domain.LoginInfo;
import com.cg.healthyfy.domain.PaymentInfo;
import com.cg.healthyfy.util.SameUtilContainer;

public class PaymentDAOImpl extends SameUtilContainer implements PaymentDAO{
	@Override
public void addPayment(PaymentInfo pay, LoginInfo login) {
  pay=new PaymentInfo(pay.getId(),pay.getPayment(),pay.getDiscount(),pay.getPlanCategory(),pay.getPayableAmount());
  em.getTransaction().begin();
  System.out.println("You have to pay "+pay.getPayableAmount()+" for your plan");
  em.persist(pay);
  em.getTransaction().commit();
	}
	@Override
public void updatePayment(PaymentInfo pay) {
		String newGateway=pay.getPlanCategory();
		double newDiscount=pay.getDiscount();
		double newPayment=pay.getPayment();
		double newNetPayableAmount=pay.getPayableAmount();
		em.getTransaction().begin();
		pay=em.find(PaymentInfo.class, pay.getId());
		pay.setPlanCategory(newGateway);
		pay.setDiscount(newDiscount);
		pay.setPayment(newPayment);
		pay.setPayableAmount(newNetPayableAmount);
        em.persist(pay);
        System.out.println("Payment Details Updated");
        em.getTransaction().commit();
}
	@Override
	public void deletePayment(PaymentInfo pay) {
		em.getTransaction().begin();
		pay=em.find(PaymentInfo.class,pay.getId());
		em.remove(pay);
		System.out.println("Payment Deleted");
		em.getTransaction().commit();
	}
	@Override
	public void findPaymentDetails(PaymentInfo pay) {
	  em.getTransaction().begin();
	  pay=em.find(PaymentInfo.class, pay.getId());
	  System.out.println("Your PAYID: "+pay.getId()+"\nDiscount: "+pay.getDiscount());
	  System.out.println("Your PaymentAmount: "+pay.getPayment()+"\nYour Payment Gateway: "+pay.getPlanCategory());
	  System.out.println("Your Net Pay Amount: "+pay.getPayableAmount());
	  em.getTransaction().commit();	
	}
}
