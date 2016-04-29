package com.hibernate.main;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.hibernate.model.Fruit;

public class FetchFruit {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter the Fruit ID");
		int id = scanner.nextInt();
		AnnotationConfiguration annotationConfiguration = new AnnotationConfiguration();
		annotationConfiguration = annotationConfiguration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = annotationConfiguration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Fruit fruit = (Fruit) session.load(Fruit.class, id);
		System.out.println(fruit);
	}
}
