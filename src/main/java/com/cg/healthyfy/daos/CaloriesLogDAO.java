package com.cg.healthyfy.daos;

import com.cg.healthyfy.domain.CaloriesLogInfo;

public interface CaloriesLogDAO {

	public void addUserCalories(CaloriesLogInfo weg);
	public void updateUserCalories(CaloriesLogInfo weg);
	public void deleteUserCalories(CaloriesLogInfo weg);
	public void findUserCalories(CaloriesLogInfo weg);	
}
