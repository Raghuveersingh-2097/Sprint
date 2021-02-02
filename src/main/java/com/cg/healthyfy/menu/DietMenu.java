package com.cg.healthyfy.menu;

import java.util.Scanner;

import com.cg.healthify.services.DietServiceImpl;
import com.cg.healthyfy.exception.NoRecordFoundException;

public class DietMenu {
	Scanner sc=new Scanner(System.in);	
	String ContChoice;
	DietServiceImpl dietimpl =new DietServiceImpl();
void menu() {
	System.out.println("1. ***--ADD DIET PLAN--***");
	System.out.println("2. ***--UPDATE DIET PLAN--***");
	System.out.println("3. ***--CANCEL DIET PLAN--***");
	System.out.println("4. ***--CHECK DIET PLAN--***");
	System.out.println("5. ***--EXIT--***");	
}
public void diet_menu(){
//menu();
do {
    System.out.println("Enter the Choice: ");
    menu();
	int choice=sc.nextInt();
switch(choice) {
case 1:
	dietimpl.addDiet();
	break;
case 2:
	dietimpl.updateDiet();
	break;
case 3:
    dietimpl.deleteDiet();
    break;
case 4:
	dietimpl.findDietData();
	break;
case 5:
	System.exit(0);
	break;
default:
	System.out.println("-------------------WRONG-CHOICE----------------------------");
	break;
}
System.out.println("Want to Continue with your Diet Plan Operation");
ContChoice=sc.next();
}while(ContChoice.equalsIgnoreCase("Y"));
}
}
