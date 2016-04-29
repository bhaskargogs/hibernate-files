package com.hibernate.main;

import java.util.Date;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.hibernate.model.Passport;
import com.hibernate.model.Person;

public class UpdateThePassportForPersion {
	public static void main(String[] args) {
		AnnotationConfiguration annotationConfiguration=new AnnotationConfiguration();
		annotationConfiguration =annotationConfiguration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory=annotationConfiguration.buildSessionFactory();
		
		Passport passport=new  Passport();
		passport.setAddress("Bombay, 20202");
		passport.setExpDate(new Date());
		passport.setLocation("Juhi Park , @3333");
		passport.setYear("2002");
		passport.setNumber("AB833622A");
		System.out.println("Enter the primary key!!!!!!!!!!!!!!!!");
		int pid=new Scanner(System.in).nextInt();
		//Loading Person Object on the basis of primary key of person object
		//fetch the session
		Session session=sessionFactory.openSession();
		session.getTransaction().begin();
		Person person=(Person)session.load(Person.class, pid);		
		passport.setPerson(person);
		//person.setPassport(passport);
		session.save(passport);
		session.getTransaction().commit();
		System.out.println("Hey!!!!!!!!!!!! Object is in database!!!!!!!");
	}

}
