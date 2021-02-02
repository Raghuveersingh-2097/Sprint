package com.cg.healthyfy.menu;

import java.util.Scanner;

import com.cg.healthyfy.exception.NoRecordFoundException;
import com.cg.healthyfy.services.CustomerServiceImpl;

public class LoginMenu {
	CustomerServiceImpl custimpl =new CustomerServiceImpl();
	CustomerMenu cMenu=new CustomerMenu();
	Scanner sc=new Scanner(System.in);	
	String ContChoice;
	void menu() {
		System.out.println("1. NEW USER");
		System.out.println("2. EXISTING USER");
	}
	public void loginMenu(){
		do {
			menu();
			System.out.println("Enter the Choice: ");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				cMenu.add();
				break;
			case 2:
				custimpl.loginAuthentication();
				break;
			default:
				System.exit(0);
				break;
			}System.out.println("Wants to Continue with login menu.");
			ContChoice=sc.next();
		}while(ContChoice.equalsIgnoreCase("Y"));
	}
}