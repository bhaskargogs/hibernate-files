package com.hibernate.main;

import java.util.Date;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.hibernate.model.Passport;
import com.hibernate.model.Person;

public class GetMethod {
	public static void main(String[] args) {
		AnnotationConfiguration annotationConfiguration=new AnnotationConfiguration();
		annotationConfiguration =annotationConfiguration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory=annotationConfiguration.buildSessionFactory();
		System.out.println("Enter the primary key!!!!!!!!!!!!!!!!");
		int pid=new Scanner(System.in).nextInt();
		//Loading Person Object on the basis of primary key of person object
		//fetch the session
		Session session=sessionFactory.openSession();
		//Get is eager and it will return  null if object does not exist in the database with given id 
		Passport passport=(Passport)session.get(Passport.class, pid);
		System.out.println("_+@)@(@(@(@Bhaskar!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!'");
		System.out.println("Hey!!!!!!!!!!!! Object is in database!!!!!!!"+passport);
	}

}
