package com.cg.healthyfy.menu;

import java.util.Scanner;

import com.cg.healthify.services.NutritionServiceImpl;

public class NutritionPlanMenu {
	Scanner sc=new Scanner(System.in);	
	String ContChoice;
	NutritionServiceImpl nut=new NutritionServiceImpl();
	void menu() {
		System.out.println("1. ***--ADD NUTRITION PLAN--***");
		System.out.println("2. ***--UPDATE NUTRITION PLAN--***");
		System.out.println("3. ***--DELETE NUTRITION PLAN--***");
		System.out.println("4. ***--CUSTOMER NUTRITION PLAN DETAILS--***");
		System.out.println("5. ***--EXIT--***");	
	}

	public void nutrition_menu(){
		//menu();
		do {
			System.out.println("Enter the Choice: ");
			menu();
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				nut.addNutrition();
				break;
			case 2:
				nut.updateNutrition();
				break;
			case 3:
				nut.deleteNutrition();
				break;
			case 4:
				nut.findNutritionData();
				break;
			case 5:
				System.exit(0);

			}
			System.out.println("Wants to continue Nutrition Plan operation.");
			ContChoice=sc.next();
		}while(ContChoice.equalsIgnoreCase("Y"));
	}
}

