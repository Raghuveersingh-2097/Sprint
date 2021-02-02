package com.cg.healthyfy.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import com.cg.healthyfy.daos.CaloriesLogDAOImpl;
import com.cg.healthyfy.domain.CaloriesLogInfo;
import com.cg.healthyfy.util.SameUtilContainer;

public class CaloriesLogServiceImpl extends SameUtilContainer implements CaloriesLogService{
Scanner sc=new Scanner(System.in);
CaloriesLogInfo calorie=new CaloriesLogInfo();
CaloriesLogDAOImpl cdao=new CaloriesLogDAOImpl();

	@Override
	public void addCaloriesLog() {
		// TODO Auto-generated method stub
		 System.out.println("Enter your FitnessID: ");
		 calorie.setId(sc.nextInt());
		    System.out.println("Enter your Calories Count: ");
		    calorie.setCaloriesLog(sc.nextDouble());
		    LocalDate sdate=LocalDate.now();
			LocalDate udate=LocalDate.now();
			 LocalTime stime=LocalTime.now();
			 LocalTime dtime=LocalTime.now();
			 calorie.setCreated_At(sdate);
			 calorie.setUpdated_At(udate);
			 calorie.setCreateTime(dtime);
			 calorie.setUpdateTime(dtime);
			 cdao.addUserCalories(calorie);
	}

	@Override
	public void UpdateCaloriesLog() {
		// TODO Auto-generated method stub
		System.out.println("Confirm your FitnessID to Update: ");
		calorie.setId(sc.nextInt());
		System.out.println("Enter New Calories Count: ");
	calorie.setCaloriesLog(sc.nextDouble());
		LocalDate udate=LocalDate.now();
		LocalTime dtime=LocalTime.now();
		calorie.setUpdated_At(udate);
		calorie.setUpdateTime(dtime);
		cdao.updateUserCalories(calorie);
	}

	@Override
	public void DeleteCaloriesLog() {
		// TODO Auto-generated method stub
		System.out.println("Confirm your FitnessID to delete your log: ");
		calorie.setId(sc.nextInt());
		cdao.deleteUserCalories(calorie);
	}

	@Override
	public void findCaloriesLog() {
		// TODO Auto-generated method stub
		System.out.println("Confirm your FitnessID to find your log: ");
		calorie.setId(sc.nextInt());
		cdao.findUserCalories(calorie);
	}
	

	
}
