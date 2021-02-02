package com.cg.healthyfy.menu;

import java.util.Scanner;

import com.cg.healthify.services.CaloriesLogServiceImpl;


public class CaloriesLogMenu {

	Scanner sc=new Scanner(System.in);	
	String ContChoice;
	CaloriesLogServiceImpl csi=new CaloriesLogServiceImpl();
	void menu() {
		System.out.println("1. ***--ADD CALORIES LOG--***");
		System.out.println("2. ***--UPDATE CALORIES LOG--***");
		System.out.println("3. ***--DELETE CALORIES LOG--***");
		System.out.println("4. ***--FIND CALORIES LOG--***");
		System.out.println("5. ***--EXIT--***");	
	}

	public void calorieslog_menu(){
		//menu();
		do {
			System.out.println("Enter the Choice: ");
			menu();
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				csi.addCaloriesLog();
				break;
			case 2:
				csi.UpdateCaloriesLog();
				break;
			case 3:
				csi.DeleteCaloriesLog();  
				break;
			case 4:
				csi.findCaloriesLog();
				break;
			case 5:
				System.exit(0);
				break;
			}
			System.out.println("Wants to continue caloriesLog operation.");
			ContChoice=sc.next();
		}while(ContChoice.equalsIgnoreCase("Y"));
	}
}

