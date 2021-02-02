package com.cg.healthyfy.services;

import java.util.Scanner;

import com.cg.healthyfy.daos.ExcerciseDAOImpl;
import com.cg.healthyfy.domain.ExcerciseInfo;
import com.cg.healthyfy.util.SameUtilContainer;

public class ExcerciseServiceImpl extends SameUtilContainer implements ExcerciseService{
	 ExcerciseInfo exc= new  ExcerciseInfo();
	 ExcerciseDAOImpl exdao=new  ExcerciseDAOImpl();
	 Scanner sc=new Scanner(System.in);
	@Override
	public void addExcercise() {
		// TODO Auto-generated method stub
		System.out.println("Enter your Excersise ID:");
		exc.setExceriseId(sc.nextInt());
		System.out.println("Excercise Type: ");
		exc.setExcerciseType(sc.next());
		System.out.println("Your Plan: ");
		exc.setPlan(sc.next());
		exdao.addFit(exc);
	}

	@Override
	public void updateExcercise() {
		// TODO Auto-generated method stub
		System.out.println("Confirm your ID to update Excercise plan: ");
		exc.setExceriseId(sc.nextInt());
		System.out.println("Enter your new Excercise Type:");
		exc.setExcerciseType(sc.next());
		System.out.println("New Excercise plan: ");
		exc.setPlan(sc.next());
	    exdao.updateFit(exc);	
	}

	@Override
	public void deleteExcercise() {
		// TODO Auto-generated method stub
		System.out.println("Confirm your ID to delete your exercise details: ");
		exc.setExceriseId(sc.nextInt());
		exdao.deleteFit(exc);
		
	}

	@Override
	public void findExcercise() {
		// TODO Auto-generated method stub
		System.out.println("Please give your ID to get your exercise details: ");
		exc.setExceriseId(sc.nextInt());
		exdao.fetchFit(exc);
	}

}
