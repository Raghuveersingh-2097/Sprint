package com.cg.healthyfy.menu;

import java.util.Scanner;

import com.cg.healthify.services.ExcerciseServiceImpl;
import com.cg.healthify.services.WeightLogServiceImpl;

public class ExcerciseMenu {

	Scanner sc=new Scanner(System.in);	
	String ContChoice;
	ExcerciseServiceImpl exc=new ExcerciseServiceImpl(); 
	void menu() {
		System.out.println("1. ***--ADD EXCERISE PLAN--***");
		System.out.println("2. ***--UPDATE EXCERISE PLAN--***");
		System.out.println("3. ***--DELETE EXCERISE PLAN--***");
		System.out.println("4. ***--FIND EXCERISE DETAILS--***");
		System.out.println("5. ***--EXIT--***");	
	}

	public void excercise_menu(){
		//menu();
		do {
			System.out.println("Enter the Choice: ");
			menu();
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				exc.addExcercise();
				break;
			case 2:
				exc.updateExcercise();
				break;
			case 3:
				exc.deleteExcercise();
				break;
			case 4:
				exc.findExcercise();
				break;
			}
			System.out.println("Wants to continue excercise operation.");
			ContChoice=sc.next();
		}while(ContChoice.equalsIgnoreCase("Y"));
	}
}
