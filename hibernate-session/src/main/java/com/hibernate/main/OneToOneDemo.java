package com.hibernate.main;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.hibernate.model.Passport;
import com.hibernate.model.Person;

public class OneToOneDemo {
	public static void main(String[] args) {
		AnnotationConfiguration annotationConfiguration=new AnnotationConfiguration();
		annotationConfiguration =annotationConfiguration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory=annotationConfiguration.buildSessionFactory();
		
		Passport passport=new  Passport();
		passport.setAddress("New Delhi, 20202");
		passport.setExpDate(new Date());
		passport.setLocation("Nehru Place , @3333");
		passport.setYear("2007");
		passport.setNumber("YSDH3338");
		
		Person person=new Person();
		person.setEmail("okaya@gmail.com");
		person.setGender("Male");
		person.setMobile("02938383");
		person.setName("Mr. Kumar Dave");
		
		passport.setPerson(person);
		
		//fetch the session
		Session session=sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(passport);
		session.getTransaction().commit();
		System.out.println("Hey!!!!!!!!!!!! Object is in database!!!!!!!");
	}

}
