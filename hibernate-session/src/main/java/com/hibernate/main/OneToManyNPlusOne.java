package com.hibernate.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.hibernate.model.Human;
import com.hibernate.model.Laptop;
import com.hibernate.util.HibernateSessionManagerUtil;

public class OneToManyNPlusOne {
	
	public static void main(String[] args) {
		
		List<Laptop> laptops=new ArrayList<>();
		Laptop laptop1=new Laptop("Dell","I3","3GB","G1",24);
		Laptop laptop2=new Laptop("HP","I3","8GB","G2",24);
		Laptop laptop3=new Laptop("Leneo","I4","2GB","G4",34);
		Laptop laptop4=new Laptop("Accer","I4","4GB","G5",24);
		laptops.add(laptop1);
		laptops.add(laptop2);
		laptops.add(laptop3);
		laptops.add(laptop4);
		
		List<Human> humans=new ArrayList<>();
		Human human1=new Human("AK","ak@gmail.com","Male",30);
		Human human2=new Human("BK","bk@gmail.com","Male",20);
		Human human3=new Human("PK","pk@gmail.com","Male",10);
		Human human4=new Human("GK","gk@gmail.com","Male",20);
		Human human5=new Human("MK","mk@gmail.com","Male",50);
		Human human6=new Human("LK","lk@gmail.com","Male",70);
		humans.add(human1);
		humans.add(human2);
		humans.add(human3);
		humans.add(human4);
		humans.add(human5);
		humans.add(human6);
		
		
		Session session=HibernateSessionManagerUtil.getHibernateSession();
		System.out.println("______________________________HOME______________________________________");
		session.getTransaction().begin();
		 laptop1.setHuman(human5);
		 laptop2.setHuman(human5);
		 laptop3.setHuman(human5);
		 laptop4.setHuman(human5);
		  session.save(laptop1);
		  session.save(laptop2);
		  session.save(laptop3);
		  session.save(laptop4);
		
		System.out.println("______________________________HOME______________________________________");
		
		session.getTransaction().commit();
		
		
		
	}

}
