package com.cg.healthyfy.daos;

import com.cg.healthyfy.domain.NutritionInfo;

public interface NutritionDAO {

public void saveNutritionPlan(NutritionInfo nutrition);

public void updateNutritionPlan(NutritionInfo nutrition);
 
public void removeNutritionPlan(NutritionInfo nutrition);

public void CustomerNutritionPlan(NutritionInfo nutrition);
}
