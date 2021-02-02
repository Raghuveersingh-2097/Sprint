package com.cg.healthyfy.services;

import java.util.Scanner;

import com.cg.healthify.constants.PaymentConstants;
import com.cg.healthyfy.daos.PaymentDAOImpl;
import com.cg.healthyfy.domain.LoginInfo;
import com.cg.healthyfy.domain.PaymentInfo;
import com.cg.healthyfy.exception.PaymentAmountException;
import com.cg.healthyfy.util.SameUtilContainer;

public class PaymentServiceImpl extends SameUtilContainer implements PaymentService{
	PaymentInfo pay=new PaymentInfo();
	PaymentDAOImpl pdao=new PaymentDAOImpl();
	LoginInfo login=new LoginInfo();
	Scanner sc=new Scanner(System.in);
	@Override
	public void addPaymentGateway() {
		try {
			System.out.println("Enter your PAYID: ");
			pay.setId(sc.nextInt());
			login.setId(pay.getId());
			System.out.println("Enter your payment Gateway: ");
			pay.setPlanCategory(sc.next());
			System.out.println("Enter your Payment");
			pay.setPayment(sc.nextDouble());
			Validate(pay.getPayment());
		}catch(Exception e) {
			System.out.println(e);
			System.exit(0);
		}
		if(pay.getPlanCategory().equalsIgnoreCase("UPI")) {
			pay.setDiscount(PaymentConstants.gold);
		}else
			if(pay.getPlanCategory().equalsIgnoreCase("CARD")) {
				pay.setDiscount(PaymentConstants.platinum);
			}
			else {
				pay.setDiscount(PaymentConstants.silver);
			}
		double netPay=pay.getPayment()-((pay.getPayment()*pay.getDiscount())/100);
		pay.setPayableAmount(netPay);
		pdao.addPayment(pay, login);   		 
	}
	@Override
public void UpdatePayment() {
	System.out.println("Enter the PAYID to Udpate payment details: ");
	pay.setId(sc.nextInt());
	System.out.println("Enter your new payment gateway");
	pay.setPlanCategory(sc.next());
	System.out.println("Enter your new payment");
	pay.setPayment(sc.nextDouble());
	if(pay.getPlanCategory().equalsIgnoreCase("UPI")) {
		pay.setDiscount(PaymentConstants.gold);
	}else
		if(pay.getPlanCategory().equalsIgnoreCase("CARD")) {
			pay.setDiscount(PaymentConstants.platinum);
		}
		else {
			pay.setDiscount(PaymentConstants.silver);
		}
	double netPay=pay.getPayment()-((pay.getPayment()*pay.getDiscount())/100);
	pay.setPayableAmount(netPay);
	pdao.updatePayment(pay);
}
	static void Validate(double io)throws PaymentAmountException{
		if(io<0) {
			throw new PaymentAmountException("Payment Should be postive or greater than zero ");
		}
	}
	@Override
	public void DeletePayment() {
		System.out.println("Please confirm your PAYID to delete your payment details.");
		pay.setId(sc.nextInt());
		System.out.println(pay.getPlanCategory());
	String n=pay.getPlanCategory();
	if(n==null) {
		System.out.println("NO RECORD IN PAYMENT PORTAL");
	}
	else {
		pdao.deletePayment(pay);	
	}
	
	}
	@Override
	public void findPayment() {
		System.out.println("Enter your PAYID to fetch your Details: ");
		pay.setId(sc.nextInt());
		if(pay.getId()==0) {
			System.out.println("NO RECORD TO FIND IN PAYMENT PORTAL");
		}else {
			pdao.findPaymentDetails(pay);
		}
		
	}
}
