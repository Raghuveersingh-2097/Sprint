package com.cg.healthyfy.menu;

import java.util.Scanner;

import com.cg.healthify.services.PaymentServiceImpl;
import com.cg.healthify.services.WeightLogServiceImpl;

public class WeightLogMenu {
	Scanner sc=new Scanner(System.in);	
	String ContChoice;
	WeightLogServiceImpl weg=new WeightLogServiceImpl();
	void menu() {
		System.out.println("1. ***--ADD WEIGHT LOG--***");
		System.out.println("2. ***--UPDATE WEIGHT LOG--***");
		System.out.println("3. ***--DELETE WEIGHT LOG--***");
		System.out.println("4. ***--FIND WEIGHT LOG--***");
		System.out.println("5. ***--EXIT--***");	
	}

	public void weightlog_menu(){
		//menu();
		do {
			System.out.println("Enter the Choice: ");
			menu();
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				weg.addWeightLog();
				break;
			case 2:
				weg.UpdateWeightLog();
				break;
			case 3:
				weg.DeleteWeightLog();
				break;
			case 4:
				weg.findWeightLog();
				break;
			}
			System.out.println("Wants to continue weightLog operation.");
			ContChoice=sc.next();
		}while(ContChoice.equalsIgnoreCase("Y"));
	}
}
