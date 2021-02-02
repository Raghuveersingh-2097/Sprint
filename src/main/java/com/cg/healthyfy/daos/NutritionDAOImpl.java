package com.cg.healthyfy.daos;

import com.cg.healthyfy.domain.NutritionInfo;
import com.cg.healthyfy.util.SameUtilContainer;

public class NutritionDAOImpl extends SameUtilContainer implements NutritionDAO{

	@Override
	public void saveNutritionPlan(NutritionInfo nutrition) {
		// TODO Auto-generated method stub
		nutrition = new NutritionInfo(nutrition.getId(),nutrition.getName(),nutrition.getPlandescription(),nutrition.getCreated_at(),nutrition.getPrice());
		em.getTransaction().begin();
		em.persist(nutrition);
		System.out.println("Nutrition Plan Saved.");
		em.getTransaction().commit();
	}

	@Override
	public void updateNutritionPlan(NutritionInfo nutrition) {
		// TODO Auto-generated method stub
		String newPlan=nutrition.getPlandescription();
		int newPrice = nutrition.getPrice();
		em.getTransaction().begin();
		nutrition = em.find(NutritionInfo.class, nutrition.getId());
		nutrition.setPlandescription(newPlan);
		nutrition.setPrice(newPrice);
		em.persist(nutrition);
		System.out.println("Your nutrition plan is Updated...");
		em.getTransaction().commit();	
	}

	@Override
	public void removeNutritionPlan(NutritionInfo nutrition) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void CustomerNutritionPlan(NutritionInfo nutrition) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		nutrition = em.find(NutritionInfo.class, nutrition.getId());
		System.out.println("NutritionID: " + nutrition.getId() + "\n"+ "Name : " +nutrition.getName()+ "\n"+"Plan Description :" + nutrition.getPlandescription()+ "\n"
		+ "Price : "+nutrition.getPrice());
		em.getTransaction().commit();
	}

}
