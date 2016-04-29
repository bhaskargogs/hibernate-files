package com.hibernate.main;

import java.util.Date;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.hibernate.model.Passport;
import com.hibernate.model.Person;

public class LoadMethod {
	public static void main(String[] args) {
		AnnotationConfiguration annotationConfiguration=new AnnotationConfiguration();
		annotationConfiguration =annotationConfiguration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory=annotationConfiguration.buildSessionFactory();
		System.out.println("Enter the primary key!!!!!!!!!!!!!!!!");
		int pid=new Scanner(System.in).nextInt();
		//Loading Person Object on the basis of primary key of person object
		//fetch the session
		Session session=sessionFactory.openSession();
		//it's lazy in nature.................query will be fired when we fetch the data
		Passport passport=(Passport)session.load(Passport.class, pid);		
		System.out.println("_@)@(@*@&@&@&Query is not fired so far................");
		
		System.out.println("Hey!!!!!!!!!!!! Object is in database!!!!!!!"+passport); //here query will be fired/////////
	}

}
