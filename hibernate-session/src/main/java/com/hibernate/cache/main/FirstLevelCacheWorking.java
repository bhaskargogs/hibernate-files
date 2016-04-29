package com.hibernate.cache.main;

import java.util.Scanner;

import org.hibernate.Session;

import com.hibernate.model.Laptop;
import com.hibernate.util.HibernateSessionManagerUtil;

public class FirstLevelCacheWorking {
	
	public static void main(String[] args) {
		
	    Session session =HibernateSessionManagerUtil.getHibernateSession();
	
		//starting the transaction
		session.beginTransaction();
		//till here cat object is in transient state
		//attaching cat object into session
		
		//loading Laptop from database.
		System.out.println("Enter ID for Laptop!");
		Scanner scan=new Scanner(System.in);
		int id=scan.nextInt();
		
		//first time loading Laptop with specified id , so data will be fetched from database.
		Laptop p =(Laptop) session.load(Laptop.class,id);
		System.out.println("laptop data 1= "+p);
		//second time loading Laptop with specified id 
		//so data will be fetched from first level caching, not from database
		 p =(Laptop) session.load(Laptop.class,id);
		System.out.println("laptop data 2 = "+p);
		
		
		//commit means first level caching wouldn't be invalidated
		session.getTransaction().commit();
		
		System.out.println("Transaction is commited");
		p =(Laptop) session.load(Laptop.class,id);
		System.out.println("laptop data 3 = "+p);
		
		//closing session means first level caching is invalidated
		//After closing the session object will be in detached state.
		//cat here still i can access the cat object
		session.close();
		
		System.out.println("We are creating session again and try to load the same laptop!");
		//opening new session.
		 session = HibernateSessionManagerUtil.getHibernateSession();
		p =(Laptop) session.load(Laptop.class,id);
		System.out.println("laptop data 4 = "+p);
	
	
		session.close();
		System.out.println("AHAHAHAHAHHA");
			
	}

}
