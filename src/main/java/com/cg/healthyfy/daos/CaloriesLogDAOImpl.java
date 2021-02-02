package com.cg.healthyfy.daos;

import java.time.LocalDate;
import java.time.LocalTime;

import com.cg.healthyfy.domain.CaloriesLogInfo;
import com.cg.healthyfy.domain.WeightLogInfo;
import com.cg.healthyfy.util.SameUtilContainer;

public class CaloriesLogDAOImpl extends SameUtilContainer implements CaloriesLogDAO{

	@Override
	public void addUserCalories(CaloriesLogInfo weg) {
weg=new CaloriesLogInfo(weg.getId(),weg.getCaloriesLog(),weg.getCreated_At(),weg.getUpdated_At(),weg.getCreateTime(),weg.getUpdateTime());		
em.getTransaction().begin();
em.persist(weg);
System.out.println("Calories Log Added");
em.getTransaction().commit();	
	}

	@Override
	public void updateUserCalories(CaloriesLogInfo weg) {
		// TODO Auto-generated method stub
		LocalDate newDate=weg.getUpdated_At();
		LocalTime newTime=weg.getUpdateTime();
		double newCalories=weg.getCaloriesLog();
		em.getTransaction().begin();
		weg=em.find(CaloriesLogInfo.class, weg.getId());
		weg.setCaloriesLog(newCalories);
		weg.setUpdated_At(newDate);
		weg.setUpdateTime(newTime);
		System.out.println("Calories Log Updated At: "+weg.getUpdateTime());
		em.getTransaction().commit();
	}

	@Override
	public void deleteUserCalories(CaloriesLogInfo weg) {
		// TODO Auto-generated method stub
		weg=em.find(CaloriesLogInfo.class, weg.getId());
		em.getTransaction().begin();
		em.remove(weg);
		System.out.println("Your Log is deleted");
		em.getTransaction().commit();
	}

	@Override
	public void findUserCalories(CaloriesLogInfo weg) {
		// TODO Auto-generated method stub
		weg=em.find(CaloriesLogInfo.class, weg.getId());
		em.getTransaction().begin();
		System.out.println("ID: "+weg.getId()+"\nCalories Log: "+weg.getCaloriesLog()+"\nCreate Date: "+weg.getCreated_At()+"\nCreate Time"+weg.getCreateTime());
		System.out.println("Update Date: "+weg.getUpdated_At()+"\nUpdate Time: "+weg.getUpdateTime());
		em.getTransaction().commit();
	}

}
