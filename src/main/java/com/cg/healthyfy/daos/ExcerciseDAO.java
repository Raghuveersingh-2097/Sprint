package com.cg.healthyfy.daos;

import com.cg.healthyfy.domain.ExcerciseInfo;

public interface ExcerciseDAO {
public void addFit(ExcerciseInfo ex);
public void updateFit(ExcerciseInfo ex);
public void deleteFit(ExcerciseInfo ex);
public void fetchFit(ExcerciseInfo ex);
}
