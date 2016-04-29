package com.hibernate.main;


import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.hibernate.model.Fruit;


public class FetchAllFruit {
	public static void main(String[] args) {
		AnnotationConfiguration annotationConfiguration = new AnnotationConfiguration();
		annotationConfiguration = annotationConfiguration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = annotationConfiguration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Fruit");
		List<Fruit> fruits = query.list();
		for (Fruit fruit : fruits) {
			System.out.println(fruit);
		}
	}
}
