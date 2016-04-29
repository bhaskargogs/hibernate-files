package com.hibernate.caching.main;

import java.util.Scanner;

import org.hibernate.Session;

import com.hibernate.caching.model.Bike;
import com.hibernate.util.HibernateSessionManagerUtil;

public class FirstLevelOneSession {
	public static void main(String[] args) {
		Session session = HibernateSessionManagerUtil.getHibernateSession();
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the bid");
		int bid=scanner.nextInt();
	
		System.out.println("______________________________________________________________");
		System.out.println("______________________________________________________________");
		System.out.println("_______Implementing first level cahcing in one session_____");
		System.out.println("_______Implementing first level cahcing in one session_____");
		System.out.println("_______Implementing first level cahcing in one session_____");
		System.out.println("______________________________________________________________");
		System.out.println("______________________________________________________________");
		///Loading laptop entity first time
		System.out.println("___Loading data firsttime__________");
		Bike bike=(Bike)session.load(Bike.class, bid);
		System.out.println("Hashcode  = == "+bike.hashCode());
		System.out.println(bike);
		System.out.println("_________________________Ahaha_______________________________");
		System.out.println("_________________________Ahaha_______________________________");
		System.out.println("((@(@Hey  I am going to load same entity!!!!!!!!!!!!!!!!!!!!");
		System.out.println("___Loading data second time__________");
		bike=(Bike)session.load(Bike.class, bid);
		System.out.println("Hashcode  = == "+bike.hashCode());
		System.out.println(bike);
		System.out.println("_________________________Ahaha_______________________________");
		System.out.println("_________________________Ahaha_______________________________");
		System.out.println("_@)@(@*@&@&@&Query is not fired so far................");
		System.out.println("___closing the session____");
		session.close();
		
	}

}
