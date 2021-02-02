package com.cg.healthyfy.menu;

import java.util.Scanner;

import com.cg.healthify.services.PaymentServiceImpl;

public class PaymentMenu {
	Scanner sc=new Scanner(System.in);	
	String ContChoice;
	PaymentServiceImpl pay=new PaymentServiceImpl();
	void menu() {
		System.out.println("1. ***--MAKE PAYMENT--***");
		System.out.println("2. ***--UPDATE PAYMENT DETAILS--***");
		System.out.println("3. ***--DELETE PAYMENT DETAILS--***");
		System.out.println("4. ***--FIND PAYMENT DETAILS--***");
		System.out.println("5. ***--EXIT--***");	
	}

	public void payment_menu(){
		//menu();
		do {
			System.out.println("Enter the Choice: ");
			menu();
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				pay.addPaymentGateway();
				break;
			case 2:
				pay.UpdatePayment();
				break;
			case 3:
				pay.DeletePayment();
				break;
			case 4:
				pay.findPayment();
				break;
			}
			System.out.println("Wants to continue payment operation.");
			ContChoice=sc.next();
		}while(ContChoice.equalsIgnoreCase("Y"));
	}
}
