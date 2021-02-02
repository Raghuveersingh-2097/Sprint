package com.cg.healthyfy.services;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import com.cg.healthify.constants.DietPlanConstants;
import com.cg.healthyfy.daos.DietDAOImpl;
import com.cg.healthyfy.domain.DietPlanInfo;
import com.cg.healthyfy.domain.LoginInfo;
import com.cg.healthyfy.exception.NoRecordFoundException;
import com.cg.healthyfy.util.SameUtilContainer;

public class DietServiceImpl extends SameUtilContainer{
	DietPlanInfo diet=new DietPlanInfo();
	DietDAOImpl dietdao =new DietDAOImpl();
	LoginInfo log=new LoginInfo();
	Scanner sc=new Scanner(System.in);
	public void addDiet() {
		int io=0;
		try {
			System.out.println("Enter DietID: ");
			diet.setId(sc.nextInt());
			Query query=em.createQuery("from LoginInfo");
			List<LoginInfo> loginm= query.getResultList();
			for(LoginInfo i:loginm) {
				if(i.getId()==diet.getId()) {
					io++;
					break;
				}
			}
			Validate(io);
		}
		catch(NoRecordFoundException m) {
			System.out.println(m);
		}
		if(io==1) {
			System.out.println("Enter Slot: ");
			diet.setSlots(sc.next());
			System.out.println("Enter type of food you take: ");
			diet.setTypeOfFood(sc.next());
			if(diet.getTypeOfFood().equalsIgnoreCase("NONVEG")) {
				diet.setProteinRatio(DietPlanConstants.non_veg_protien_ratio);
				diet.setRatioOfFat(DietPlanConstants.nonVegFatRatio);
				diet.setRatioOfcarbs(DietPlanConstants.nonVegCarbsRatio);
			}
			else {
				diet.setProteinRatio(DietPlanConstants.veg_protien_ratio);
				diet.setRatioOfFat(DietPlanConstants.vegFatRatio);
				diet.setRatioOfcarbs(DietPlanConstants.vegFatRatio);
			}
			diet.setTotal(diet.getRatioOfcarbs()+diet.getRatioOfFat());
			dietdao.save_diet_plan(diet, log);
		}
	}
	public void updateDiet() {
		int io=0;
		try {
			System.out.println("Please Confirm your ID to update diet plan ");
			diet.setId(sc.nextInt());
			Query query=em.createQuery("from LoginInfo");
			List<LoginInfo> loginm= query.getResultList();
			for(LoginInfo i:loginm) {
				if(i.getId()==diet.getId() ) {
					io++;
					break;
				}
			}
			Validate(io);
		}
		catch(NoRecordFoundException m) {
			System.out.println(m);
		}
		if(io==1) {
			System.out.println("New Slot: ");
			diet.setSlots(sc.next());
			System.out.println("New Food Type: ");
			diet.setTypeOfFood(sc.next());
			if(diet.getTypeOfFood().equalsIgnoreCase("NONVEG")) {
				diet.setProteinRatio(DietPlanConstants.non_veg_protien_ratio);
				diet.setRatioOfFat(DietPlanConstants.nonVegFatRatio);
				diet.setRatioOfcarbs(DietPlanConstants.nonVegCarbsRatio);
			}
			else {
				diet.setProteinRatio(DietPlanConstants.veg_protien_ratio);
				diet.setRatioOfFat(DietPlanConstants.vegFatRatio);
				diet.setRatioOfcarbs(DietPlanConstants.vegCarbsRatio);
			}
			diet.setTotal(diet.getRatioOfcarbs()+diet.getRatioOfFat());
			dietdao.update_diet_plan(diet);
		}
	}
	public void deleteDiet() {
		int io=0;
		try {
			System.out.println("Please Confirm your Id to remove your Diet plan: ");
			diet.setId(sc.nextInt());
			Query query=em.createQuery("from LoginInfo");
			List<LoginInfo> loginm= query.getResultList();
			for(LoginInfo i:loginm) {
				if(i.getId()==diet.getId()) {
					io++;
					break;
				}
			}
			Validate(io);
		}
		catch(NoRecordFoundException m) {
			System.out.println(m);
		}
		if(io==1) {
			dietdao.remove_diet_plan(diet);
		}
	}
	public void findDietData() {
		int io=0;
		try {
			System.out.println("Please give your ID to get your diet details: ");
			diet.setId(sc.nextInt());
			Query query=em.createQuery("from LoginInfo");
			List<LoginInfo> loginm= query.getResultList();
			for(LoginInfo i:loginm) {
				if(i.getId()==diet.getId()){
					io++;
					break;
				}
			}
			Validate(io);
		}
		catch(NoRecordFoundException m) {
			System.out.println(m);
		}
		if(io==1) {
			dietdao.customer_diet_plan_data(diet);
		}
	}
	static void Validate(int io)throws NoRecordFoundException{
		if(io==0) {
			throw new NoRecordFoundException("No Records Found");
		}
	}
}
