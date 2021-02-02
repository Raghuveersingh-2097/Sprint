package com.cg.healthyfy.daos;

import com.cg.healthyfy.domain.DietPlanInfo;
import com.cg.healthyfy.domain.LoginInfo;

public interface DietDAO {
	
public void save_diet_plan(DietPlanInfo diet,LoginInfo login);

public void update_diet_plan(DietPlanInfo diet);

public void remove_diet_plan(DietPlanInfo diet);

public void customer_diet_plan_data(DietPlanInfo diet);

}
