package com.cg.healthyfy.menu;

import java.util.Scanner;

public class MainMenu {
	Scanner sc=new Scanner(System.in);	
	String ContChoice;
	void menu(){
		System.out.println("1. ***--CUSTOMER--***");
		System.out.println("2. ***--DIET-PLAN--***");
		System.out.println("3. ***--NUTRITION-PLAN--***");
		System.out.println("4. ***--PAYMENT--***");
		System.out.println("5. ***--EXCERCISE PLAN--***");
		System.out.println("6. ***--WEIGHT-LOG--***");
		System.out.println("7. ***--CALORIES-LOG--***");
	}
	public void main_menu(){
		do {
			menu();
			System.out.println("Enter the Choice: ");
			int choice=sc.nextInt();
			switch(choice) {

			case 1:
				CustomerMenu cMenu=new CustomerMenu();
				cMenu.CustMenu();
				break;
			case 2:
				DietMenu dMenu=new DietMenu();
				dMenu.diet_menu();
				break;
			case 3:
				NutritionPlanMenu nMenu=new NutritionPlanMenu();
				nMenu.nutrition_menu();
			case 4:
				PaymentMenu pay=new PaymentMenu();
				pay.payment_menu();
				break;
			case 5:
				ExcerciseMenu exc=new ExcerciseMenu();
				exc.excercise_menu();
				break;
			case 6:
				WeightLogMenu weg=new WeightLogMenu();
				weg.weightlog_menu();
				break;
			case 7:
				CaloriesLogMenu cal=new CaloriesLogMenu();
				cal.calorieslog_menu();
			default:
				System.out.println("--------------------WRONG-CHOICE--------------------");
				break;
			}System.out.println("Wants to Continue with main menu.");
			ContChoice=sc.next();
		}while(ContChoice.equalsIgnoreCase("Y"));
	}
}
