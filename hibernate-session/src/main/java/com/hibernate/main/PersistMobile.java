package com.hibernate.main;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.hibernate.model.MobileEntity;

public class PersistMobile {
	
	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the mobile name");
		String mname=scanner.next();
		
		System.out.println("Enter the mobile model");
		String model=scanner.next();
		
		System.out.println("Enter the mobile color");
		String color=scanner.next();
		
		
		System.out.println("Enter the mobile vendor");
		String vendor=scanner.next();
		
		System.out.println("Enter the mobile price");
		float price=scanner.nextFloat();
		MobileEntity mobileEntity=new MobileEntity();
		mobileEntity.setColor(color);
		mobileEntity.setModel(model);
		mobileEntity.setName(mname);
		mobileEntity.setPrice(price);
		
		AnnotationConfiguration annotationConfiguration=new AnnotationConfiguration();
		annotationConfiguration =annotationConfiguration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory=annotationConfiguration.buildSessionFactory();
		
		//fetch the session
		Session session=sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(mobileEntity);
		session.getTransaction().commit();
		System.out.println("Hey!!!!!!!!!!!! Object is in database!!!!!!!");
	}

}
