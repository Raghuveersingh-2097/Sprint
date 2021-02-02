package com.cg.healthyfy.services;

import java.time.LocalTime;
import java.util.Scanner;

import com.cg.healthyfy.daos.NutritionDAOImpl;
import com.cg.healthyfy.domain.CustomerInfo;
import com.cg.healthyfy.domain.NutritionInfo;
import com.cg.healthyfy.util.SameUtilContainer;

public class NutritionServiceImpl extends SameUtilContainer implements NutritionService{
	NutritionInfo nutrition = new NutritionInfo();
	NutritionDAOImpl nimpl = new NutritionDAOImpl();
	Scanner sc = new Scanner(System.in);
	
	
	@Override
	public void addNutrition() {
		// TODO Auto-generated method stub
		System.out.println("Enter your ID: ");
		nutrition.setId(sc.nextInt());
		System.out.println("Enter the Name: ");
		nutrition.setName(sc.next());
		System.out.println("Enter the plan description: ");
		nutrition.setPlandescription(sc.next());
		System.out.println("Enter the Price:");
		nutrition.setPrice(sc.nextInt());
		LocalTime lTime=LocalTime.now();
		nutrition.setCreated_at(lTime);
		nimpl.saveNutritionPlan(nutrition);
	}

	@Override
	public void updateNutrition() {
		// TODO Auto-generated method stub
		System.out.println("Please Confirm your ID to update nutrition plan ");
		nutrition.setId(sc.nextInt());
		System.out.println("New plan description");
		nutrition.setPlandescription(sc.next());
		System.out.println("New Price:");
		nutrition.setPrice(sc.nextInt());
		nimpl.updateNutritionPlan(nutrition);
	}

	@Override
	public void deleteNutrition() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findNutritionData() {
		// TODO Auto-generated method stub
		System.out.println("Please give your ID to get your nutrition details: ");
		nutrition.setId(sc.nextInt());
		nimpl.CustomerNutritionPlan(nutrition);
	}

	@Override
	public String nutritionUpdate(NutritionInfo nut) {
		// TODO Auto-generated method stub
		nut=new NutritionInfo(nut.getId(),nut.getName(),nut.getPlandescription(),nut.getCreated_at(),nut.getPrice());
		return nut.getPlandescription();
	}

	@Override
	public String saveNutritionInfo(NutritionInfo cust) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int checkDelete(NutritionInfo cust) {
		// TODO Auto-generated method stub
		return 0;
	}

}
