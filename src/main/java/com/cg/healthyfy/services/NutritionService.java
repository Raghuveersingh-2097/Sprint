package com.cg.healthyfy.services;

import com.cg.healthyfy.domain.CustomerInfo;
import com.cg.healthyfy.domain.NutritionInfo;

public interface NutritionService {
	
public void addNutrition();

public void updateNutrition();

public void deleteNutrition();

public void findNutritionData();

public String nutritionUpdate(NutritionInfo cust);

public String saveNutritionInfo(NutritionInfo cust);

public int checkDelete(NutritionInfo cust);

}
