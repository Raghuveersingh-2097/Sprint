package com.cg.healthyfy.daos;

import com.cg.healthyfy.domain.WeightLogInfo;

public interface WeightLogDAO {
public void addUserWeight(WeightLogInfo weg);
public void updateUserWeight(WeightLogInfo weg);
public void deleteUserWeight(WeightLogInfo weg);
public void findUserWeight(WeightLogInfo weg);


}
