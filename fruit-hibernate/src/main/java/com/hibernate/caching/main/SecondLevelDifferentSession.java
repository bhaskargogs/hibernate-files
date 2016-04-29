package com.hibernate.caching.main;

import java.util.Scanner;

import org.hibernate.Session;

import com.hibernate.caching.model.Car;
import com.hibernate.util.HibernateSessionManagerUtil;

public class SecondLevelDifferentSession {
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
		Car car=(Car)session.load(Car.class, cid);
		System.out.println("Hashcode  = == "+car.hashCode());
		System.out.println(car);
		System.out.println("_________________________Ahaha_______________________________");
		System.out.println("_________________________Ahaha_______________________________");
		System.out.println("((@(@Hey  I am going to load same entity!!!!!!!!!!!!!!!!!!!!");
		System.out.println("___Loading data second time__________");
		car=(Car)session.load(Car.class, cid);
		System.out.println("Hashcode  = == "+car.hashCode());
		System.out.println(car);
		System.out.println("_________________________Ahaha_______________________________");
		System.out.println("_________________________Ahaha_______________________________");
		System.out.println("_@)@(@*@&@&@&Query is not fired so far................");
		System.out.println("___closing the session____");
		session.close();
		session=HibernateSessionManagerUtil.getHibernateSession();
		System.out.println("___Loading data second time__________");
		car=(Car)session.load(Car.class, cid);
		System.out.println("Hashcode  = == "+car.hashCode());
		System.out.println(car);
		System.out.println("_________________________Ahaha_______________________________");
		System.out.println("_________________________Ahaha_______________________________");
		System.out.println("_@)@(@*@&@&@&Query is not fired........");
		
		
	}

}
