package com.hibernate.caching.main;

import java.util.Iterator;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;

import com.hibernate.caching.model.Car;
import com.hibernate.util.HibernateSessionManagerUtil;

public class QueryCaching {
	
	public static void main(String[] args) {
		
		//till here Laptop object is in transient state
		//attaching Laptop object into session
		//loading Laptop from database.
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter ID for Car!");
		int id=scan.nextInt();
		
		 Session session = HibernateSessionManagerUtil.getHibernateSession();
			//starting the transaction
			session.beginTransaction();
			 
			  System.out.println("Firing query first time!!!");
			  System.out.println("Firing query first time!!!");
			  System.out.println("Firing query first time!!!");
			  System.out.println("Firing query first time!!!");
			  System.out.println("Firing query first time!!!");
			  
		Query query = session.createQuery("from Car c where c.id="+id);
		query.setCacheable(true);
		//query.setCacheRegion("###amog##");
		 Iterator it = query.list().iterator();
		 while (it.hasNext ()){
			 	Car p = (Car) it.next();
			 System.out.println("Laptop  =  "+p);
			 System.out.println("HashCode()  = "+p.hashCode());
		 }
		 
		   System.out.println("_#__##)Firing same query in same session again________####");
		    query = session.createQuery("from Car c where c.id="+id);
			query.setCacheable(true);
			//query.setCacheRegion("###amog##");
			 it = query.list().iterator();
			 while (it.hasNext ()){
				 	Car p = (Car) it.next();
				 System.out.println("Car  =  "+p);
				 System.out.println("HashCode()  = "+p.hashCode());
			 }

		 
		  System.out.println("Firing query second time!!!");
		  System.out.println("Firing query second time!!!");
		  System.out.println("Firing query second time!!!");
		  System.out.println("Firing query second time!!!");
		  System.out.println("Firing query second time!!!");
		  System.out.println("Firing query second time!!!");
		  System.out.println("Firing query second time!!!");
		  System.out.println("Firing query second time!!!");
		  System.out.println("Firing query second time!!!");
		  System.out.println("Firing query second time!!!");
		  System.out.println("Firing query second time!!!");
		  System.out.println("Firing query second time!!!");
		  System.out.println("Firing query second time!!!");
		  System.out.println("Firing query second time!!!");
			session.getTransaction().commit();
		  session.close();
		  session =  HibernateSessionManagerUtil.getHibernateSession();
		 
		  query = session.createQuery("from Car c where c.id="+id);
		//query.setCacheMode(CacheMode.REFRESH);
		  query.setCacheable(true);
		 // query.setCacheRegion("###amog##");
		 it = query.list().iterator();
		 while (it.hasNext ()){
			 Car p = (Car) it.next();
			 System.out.println("Car  =  "+p);
			 System.out.println("__#+_#HashCode()  ............ =  "+p.hashCode());
		 }       
			
	
		//session.close();
		 //session = HibernateFactoryUtil.openSession();
		System.out.println("_@@@@@@@@@@@@");
		System.out.println("_@@@@@@@@@@@@");
		System.out.println("_@@@@@@@@@@@@");
		System.out.println("_@@@@@@@@@@@@");
		System.out.println("_@@@@@@@@@@@@");
		System.out.println("_@@@@@@@@@@@@");
		
		System.out.println("_@@@@@@@@@@@@");System.out.println("_@@@@@@@@@@@@");
		
		System.out.println("_@@@@@@@@@@@@");
		System.out.println("_@@@@@@@@@@@@");
		System.out.println("_@@@@@@@@@@@@");
		
		Car car=(Car)session.load(Car.class, id);
		System.out.println("Car = "+car);
		System.out.println("__#+_#HashCode()  ............ =  "+car.hashCode());
		
		session.close();
		//After closing the session object will be in detached state.
		System.out.println("Object is fetched");
	}
}
