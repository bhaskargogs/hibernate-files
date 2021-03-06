package com.hibernate.caching.main;

import java.util.Iterator;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;

import com.hibernate.caching.model.Car;
import com.hibernate.util.HibernateSessionManagerUtil;

public class FirstLevelCacheNotWorking {
	
	public static void main(String[] args) {
		 Session session = HibernateSessionManagerUtil.getHibernateSession();
		//starting the transaction
		session.beginTransaction();
		//till here Laptop object is in transient state
		//attaching Laptop object into session
		//loading Laptop from database.
		System.out.println("Enter ID for Car!");
		Scanner scan=new Scanner(System.in);
		int id=scan.nextInt();
		
		Query query = session.createQuery("from Car c where c.id="+id); //This is HQL query!!!
		 Iterator it = query.list().iterator();
		 while (it.hasNext ()){
			 	Car p = (Car) it.next();
			 System.out.println("Car  =  "+p);
		 }

		 
		  System.out.println("Firing query second time!!!");
		  query = session.createQuery("from Car c where c.id="+id);
		 it = query.list().iterator();
		 while (it.hasNext ()){
			 Car p = (Car) it.next();
			 System.out.println("Car  =  "+p);
		 }       
		session.getTransaction().commit();
		session.close();
		//After closing the session object will be in detached state.
		System.out.println("Object is fetched");
	}
}
