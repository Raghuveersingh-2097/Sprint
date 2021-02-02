package com.cg.healthyfy.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

import com.cg.healthyfy.daos.WeightLogDAOImpl;
import com.cg.healthyfy.domain.WeightLogInfo;
import com.cg.healthyfy.util.SameUtilContainer;

public class WeightLogServiceImpl extends SameUtilContainer implements WeightLogService{

	
	WeightLogInfo weight=new WeightLogInfo();
	WeightLogDAOImpl wdao=new WeightLogDAOImpl();
	Scanner sc=new Scanner(System.in);
	
	@Override
	public void addWeightLog() {
    System.out.println("Enter your FitnessID: ");
    weight.setId(sc.nextInt());
    System.out.println("Enter your CurrentWeight: ");
    weight.setWeight(sc.nextDouble());
    LocalDate sdate=LocalDate.now();
	LocalDate udate=LocalDate.now();
	 LocalTime stime=LocalTime.now();
	 LocalTime dtime=LocalTime.now();
	weight.setCreated_At(sdate);
	weight.setUpdated_At(udate);
	weight.setCreateTime(dtime);
	weight.setUpdateTime(dtime);
	wdao.addUserWeight(weight);
	}

	@Override
	public void UpdateWeightLog() {
		// TODO Auto-generated method stub
		System.out.println("Confirm your FitnessID to Update: ");
		weight.setId(sc.nextInt());
		System.out.println("Enter New Weight: ");
		weight.setWeight(sc.nextDouble());
		LocalDate udate=LocalDate.now();
		LocalTime dtime=LocalTime.now();
		weight.setUpdated_At(udate);
		weight.setUpdateTime(dtime);
		wdao.updateUserWeight(weight);
	}

	@Override
	public void DeleteWeightLog() {
		// TODO Auto-generated method stub
		System.out.println("Confirm your FitnessID to delete your log: ");
		weight.setId(sc.nextInt());	
		wdao.deleteUserWeight(weight);
	}

	@Override
	public void findWeightLog() {
		// TODO Auto-generated method stub
		System.out.println("Confirm your FitnessID to find your log: ");
		weight.setId(sc.nextInt());	
		wdao.findUserWeight(weight);
	}

}
