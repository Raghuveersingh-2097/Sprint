package com.cg.healthyfy.daos;

import com.cg.healthyfy.domain.CustomerInfo;
import com.cg.healthyfy.domain.DietPlanInfo;
import com.cg.healthyfy.domain.LoginInfo;
import com.cg.healthyfy.exception.NoRecordFoundException;
import com.cg.healthyfy.util.SameUtilContainer;

public class DietDAOImpl extends SameUtilContainer{
	public void save_diet_plan(DietPlanInfo diet,LoginInfo login) {
		 diet=new DietPlanInfo(diet.getId(),diet.getSlots(),diet.getTypeOfFood(),diet.getProteinRatio(),diet.getRatioOfFat(),diet.getRatioOfcarbs(),diet.getTotal());
		 em.getTransaction().begin();
	      em.persist(diet);
	      System.out.println("Diet Plan Saved.");
	      em.getTransaction().commit();
	}
	public void update_diet_plan(DietPlanInfo diet) {
		String newSlot=diet.getSlots();
		String newFoodType=diet.getTypeOfFood();
		double newCarbs=diet.getRatioOfcarbs();
		double newFat=diet.getRatioOfFat();
		double newTotal=diet.getTotal();
		em.getTransaction().begin();
		diet=em.find(DietPlanInfo.class, diet.getId());
		diet.setSlots(newSlot);
		diet.setTypeOfFood(newFoodType);
		diet.setRatioOfcarbs(newCarbs);
		diet.setRatioOfFat(newFat);
		diet.setTotal(newTotal);
		em.persist(diet);
		System.out.println("Your diet plan is Updated...");
		em.getTransaction().commit();

	}
	public void remove_diet_plan(DietPlanInfo diet) {
		diet=em.find(DietPlanInfo.class, diet.getId());
		em.getTransaction().begin();	
		em.remove(diet);
		System.out.println("Your Current Diet Plan is Removed");
		em.getTransaction().commit(); 
	}
	public void customer_diet_plan_data(DietPlanInfo diet) {
		 em.getTransaction().begin();
		   diet=em.find(DietPlanInfo.class, diet.getId());
		   System.out.println("DietID: "+diet.getId()+"\n"+"Slots: "+diet.getSlots()+"\n"+"FOOD TYPE"+diet.getTypeOfFood()+"\n"+"PROTIEN RATIO"+diet.getProteinRatio());
		   em.getTransaction().commit();
		   }
	}

