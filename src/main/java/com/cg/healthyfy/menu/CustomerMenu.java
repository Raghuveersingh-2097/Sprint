package com.cg.healthyfy.menu;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import com.cg.healthyfy.domain.CustomerInfo;
import com.cg.healthyfy.exception.NoRecordFoundException;
import com.cg.healthyfy.services.CustomerServiceImpl;
import com.cg.healthyfy.util.SameUtilContainer;


public class CustomerMenu extends SameUtilContainer{

		CustomerServiceImpl custService=new CustomerServiceImpl();
		CustomerInfo custInfo = new CustomerInfo();
		int choice;
		String continueChoice;
		Scanner sc = new Scanner(System.in);
		public void add() {
			System.out.println("-------A Warm Welcome To Our New Customer---------");
			System.out.println("Enter Your Name: ");
			custInfo.setName(sc.next());
			sc.nextLine();
			System.out.println("Enter Your Gender: ");
			custInfo.setGender(sc.next());
			sc.nextLine();
			System.out.println("Enter Your Date of Birth: ");
			custInfo.setDob(sc.next());
			System.out.println("Enter Your Contact: ");
			custInfo.setContact(sc.next());
			System.out.println("Any Medical Condition: ");
			custInfo.setMedicalCondition(sc.next());
			sc.nextLine();
			System.out.println("Any Allergy: ");
			custInfo.setAllergicTo(sc.next());
			custService.adduser(custInfo);
		}
		public void CustMenu() {
		do {
			showMenu();
			System.out.println("Enter Your Choice");
			choice = sc.nextInt();
			switch (choice) {
		
			case 1:
				System.out.println("-------Please Provide below details to Update---------");
				System.out.println("Please Confirm Your ID:");
				custInfo.setId(sc.nextInt());
				System.out.println("New Contact: ");
				custInfo.setContact(sc.next());
				sc.nextLine();
				System.out.println("Current Medical Condition: ");
				custInfo.setMedicalCondition(sc.next());
				System.out.println("New Allergy: ");
				custInfo.setAllergicTo(sc.next());	
				custService.updateuser(custInfo);

				break;

			case 2:

				System.out.println("Please Confirm Your ID:");
				custInfo.setId(sc.nextInt());
				custService.deleteUser(custInfo);
				break;
			case 3:
				System.out.println("-------------User-Details------------");

				System.out.println("Please Confirm Your ID:");
				custInfo.setId(sc.nextInt());
				int value=custInfo.getId();
				custService.findUser(value);
				break;
			case 4:
				System.out.println("-------------All User Details------------");
				custService.findAll();
				System.out.println("------------------------------------------------------------");
				break;
			case 5:
				System.out.println("---------------Thanks For Utilisig HealthyFy App Services---------------");
				System.exit(0);
				break;
			default:
				System.out.println("Wrong Choice");
				break;
			}
			System.out.println("Wants to continue with customer menu: ");
			continueChoice = sc.next();
		} while (continueChoice.equalsIgnoreCase("Y"));
		System.out.println("---------------Thanks For Utilisig Nutrition App Services---------------");
	}
	static void Validate(int io)throws NoRecordFoundException{
		if(io==0) {
			throw new NoRecordFoundException("No Records Found");
		}
		
	}
	private static void showMenu() {
		System.out.println("---------HEALTHYAPP CUSTOMER MENU-----------");
		System.out.println("1. Update Existing Customer");
		System.out.println("2. Delete Existing Customer");
		System.out.println("3. Find Specific Customer Details");
		System.out.println("4. Display All Customers");
		System.out.println("5. Exit");
	}

}
