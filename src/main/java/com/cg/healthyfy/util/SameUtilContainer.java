package com.cg.healthyfy.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SameUtilContainer {
	  public static EntityManagerFactory emf=Persistence.createEntityManagerFactory("JPA-PU");	
	   public static EntityManager em=emf.createEntityManager();
	   public static  EntityTransaction tx = em.getTransaction();
}