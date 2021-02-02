package com.cg.healthyfy.daos;

import com.cg.healthyfy.domain.ExcerciseInfo;
import com.cg.healthyfy.util.SameUtilContainer;

public class ExcerciseDAOImpl extends SameUtilContainer implements ExcerciseDAO{

	@Override
	public void addFit(ExcerciseInfo ex) {
		// TODO Auto-generated method stub
ex=new ExcerciseInfo(ex.getExceriseId(),ex.getExcerciseType(),ex.getPlan());
em.getTransaction().begin();
em.persist(ex);
System.out.println("Excerise Details Added: ");
em.getTransaction().commit();
	}

	@Override
	public void updateFit(ExcerciseInfo ex) {
		// TODO Auto-generated method stub
String newType=ex.getExcerciseType();
String newPlan=ex.getPlan();
em.getTransaction().begin();
ex=em.find(ExcerciseInfo.class, ex.getExceriseId());
ex.setExcerciseType(newType);
ex.setPlan(newPlan);
em.persist(ex);
System.out.println("Files Deleted.");
em.getTransaction().commit();
	}

	@Override
	public void deleteFit(ExcerciseInfo ex) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		ex=em.find(ExcerciseInfo.class,ex.getExceriseId());
		em.remove(ex);
		System.out.println("Exercise Deleted");
		em.getTransaction().commit();	
	}

	@Override
	public void fetchFit(ExcerciseInfo ex) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		ex = em.find(ExcerciseInfo.class, ex.getExceriseId());
		System.out.println("ExerciseID: " + ex.getExceriseId() + "\n"+ "Exercise Type : " +ex.getExcerciseType()+ "\n"+"Exercise Plan :" + ex.getPlan()+ "\n");
		em.getTransaction().commit();
		
	}

}
