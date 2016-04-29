package com.hibernate.cache.main;

import java.util.Scanner;

import org.hibernate.Session;

import com.hibernate.model.Laptop;
import com.hibernate.util.HibernateSessionManagerUtil;

public class FirstLevelSecondCaching {
	public static void main(String[] args) {
		Session session=HibernateSessionManagerUtil.getHibernateSession();
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the lid");
		int lid=scanner.nextInt();
	
		///Loading laptop entity first time
		System.out.println("___Loading data firsttime__________");
		Laptop laptop=(Laptop)session.load(Laptop.class, lid);
		System.out.println("Hashcode  = == "+laptop.hashCode());
		System.out.println(laptop);
		System.out.println("_________________________Ahaha_______________________________");
		System.out.println("_________________________Ahaha_______________________________");
		System.out.println("((@(@Hey  I am going to load same entity!!!!!!!!!!!!!!!!!!!!");
		System.out.println("___Loading data second time__________");
		laptop=(Laptop)session.load(Laptop.class, lid);
		System.out.println("Hashcode  = == "+laptop.hashCode());
		System.out.println(laptop);
		System.out.println("_________________________Ahaha_______________________________");
		System.out.println("_________________________Ahaha_______________________________");
		System.out.println("_@)@(@*@&@&@&Query is not fired so far................");
		System.out.println("___closing the session____");
		session.close();
		session=HibernateSessionManagerUtil.getHibernateSession();
		System.out.println("___Loading data third time__________");
		laptop=(Laptop)session.load(Laptop.class, lid);
		System.out.println("Hashcode  = == "+laptop.hashCode());
		System.out.println(laptop);
		System.out.println("_@)@(@*@&@&@&Query is not fired so far................");
	}

}
