package com.hibernate.caching.main;

import org.hibernate.Session;

import com.hibernate.caching.model.Bike;
import com.hibernate.util.HibernateSessionManagerUtil;

public class PersistBikeData {
	public static void main(String[] args) {
		Session session = HibernateSessionManagerUtil.getHibernateSession();
		
		Bike bike1=new Bike("Pulsor","220","Suzuki","2",950.34);
		Bike bike2 = new Bike("Speedbike","Singe","Blackout","2",349.00);
		
		session.getTransaction().begin();
		session.save(bike1);
		session.save(bike2);
		session.getTransaction().commit();
	}
}
