package com.hibernate.caching.main;

import java.util.Scanner;

import org.hibernate.Session;

import com.hibernate.caching.model.Vehicle;
import com.hibernate.util.HibernateSessionManagerUtil;

public class SecondLevelInheritanceDifferentSession {
	public static void main(String[] args) {
		Session session = HibernateSessionManagerUtil.getHibernateSession();
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the cid");
		int cid=scanner.nextInt();
	
		System.out.println("______________________________________________________________");
		System.out.println("______________________________________________________________");
		System.out.println("_______Implementing first level cahcing in different session_____");
		System.out.println("_______Implementing first level cahcing in different session_____");
		System.out.println("_______Implementing first level cahcing in different session_____");
		System.out.println("______________________________________________________________");
		System.out.println("______________________________________________________________");
		///Loading laptop entity first time
		System.out.println("___Loading data firsttime__________");
		Vehicle vehicle=(Vehicle)session.load(Vehicle.class, cid);
		System.out.println("Hashcode  = == "+vehicle.hashCode());
		System.out.println(vehicle);
		System.out.println("_________________________Ahaha_______________________________");
		System.out.println("_________________________Ahaha_______________________________");
		System.out.println("((@(@Hey  I am going to load same entity!!!!!!!!!!!!!!!!!!!!");
		System.out.println("___Loading data second time__________");
		vehicle=(Vehicle)session.load(Vehicle.class, cid);
		System.out.println("Hashcode  = == "+vehicle.hashCode());
		System.out.println(vehicle);
		System.out.println("_________________________Ahaha_______________________________");
		System.out.println("_________________________Ahaha_______________________________");
		System.out.println("_@)@(@*@&@&@&Query is not fired so far................");
		System.out.println("___closing the session____");
		session.close();
		session=HibernateSessionManagerUtil.getHibernateSession();
		System.out.println("___Loading data second time__________");
		vehicle=(Vehicle)session.load(Vehicle.class, cid);
		System.out.println("Hashcode  = == "+vehicle.hashCode());
		System.out.println(vehicle);
		System.out.println("_________________________Ahaha_______________________________");
		System.out.println("_________________________Ahaha_______________________________");
		System.out.println("_@)@(@*@&@&@&Query is not fired........");
		
		
	}

}
