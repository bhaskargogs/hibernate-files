package com.hibernate.main;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.hibernate.model.MobileEntity;

public class FetchMobile {
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter the mobile id");
		int mid=scanner.nextInt();
		
		AnnotationConfiguration annotationConfiguration=new AnnotationConfiguration();
		annotationConfiguration =annotationConfiguration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory=annotationConfiguration.buildSessionFactory();
		
		//fetch the session
		Session session=sessionFactory.openSession();
		MobileEntity entity=(MobileEntity)session.load(MobileEntity.class,mid);
		System.out.println(entity);
		
	}
}
