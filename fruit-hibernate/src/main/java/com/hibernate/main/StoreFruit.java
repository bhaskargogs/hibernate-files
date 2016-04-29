package com.hibernate.main;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.hibernate.model.Fruit;

public class StoreFruit {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the fruit name: ");
		String name = sc.next();
		System.out.println("Enter the fruit type: ");
		String type = sc.next();
		System.out.println("Enter the price: ");
		float price = sc.nextFloat();
		
		Fruit fruit = new Fruit();
		fruit.setName(name);
		fruit.setType(type);
		fruit.setPrice(price);
		
		AnnotationConfiguration annotationConfiguration = new AnnotationConfiguration();
		annotationConfiguration = annotationConfiguration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = annotationConfiguration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(fruit);
		session.getTransaction().commit();
	}
}
