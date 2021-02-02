package com.cg.healthyfy.daos;

import java.time.*;

import com.cg.healthyfy.domain.CaloriesLogInfo;
import com.cg.healthyfy.domain.WeightLogInfo;
import com.cg.healthyfy.util.SameUtilContainer;

public class WeightLogDAOImpl extends SameUtilContainer implements WeightLogDAO{

	@Override
	public void addUserWeight(WeightLogInfo weg) {
    weg=new WeightLogInfo(weg.getId(),weg.getWeight(),weg.getCreated_At(),weg.getUpdated_At(),weg.getCreateTime(),weg.getUpdateTime());
    em.getTransaction().begin();
    em.persist(weg);
    System.out.println("Weight Log Added");
    em.getTransaction().commit();
		
	}

	@Override
	public void updateUserWeight(WeightLogInfo weg) {
		LocalDate newDate=weg.getUpdated_At();
		LocalTime newTime=weg.getUpdateTime();
		double newWeight=weg.getWeight();
		em.getTransaction().begin();
		weg=em.find(WeightLogInfo.class, weg.getId());
		weg.setWeight(newWeight);
		weg.setUpdated_At(newDate);
		weg.setUpdateTime(newTime);
		System.out.println("Weight Log Updated At: "+weg.getUpdateTime());
		em.getTransaction().commit();
		
	}

	@Override
	public void deleteUserWeight(WeightLogInfo weg) {
		// TODO Auto-generated method stub
		weg=em.find(WeightLogInfo.class, weg.getId());
		em.getTransaction().begin();
		em.remove(weg);
		System.out.println("Your Log is deleted");
		em.getTransaction().commit();
	}

	@Override
	public void findUserWeight(WeightLogInfo weg) {
		// TODO Auto-generated method stub
		weg=em.find(WeightLogInfo.class, weg.getId());
		em.getTransaction().begin();
		System.out.println("ID: "+weg.getId()+"\nWeight Log: "+weg.getWeight()+"\nCreate Date: "+weg.getCreated_At()+"\nCreate Time"+weg.getCreateTime());
		System.out.println("Update Date: "+weg.getUpdated_At()+"\nUpdate Time: "+weg.getUpdateTime());
		em.getTransaction().commit();

	}

}
