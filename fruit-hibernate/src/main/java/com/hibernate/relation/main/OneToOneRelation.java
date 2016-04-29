package com.hibernate.relation.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.hibernate.relation.model.Mobile;
import com.hibernate.relation.model.Student;
import com.hibernate.relation.model.Teacher;

public class OneToOneRelation {

	public static void main(String[] args) {
		AnnotationConfiguration annotationConfiguration = new AnnotationConfiguration();
		annotationConfiguration = annotationConfiguration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = annotationConfiguration.buildSessionFactory();
		Mobile mobile = new Mobile();
		mobile.setNumber("9198125763");
		mobile.setVendor("Apple");
		mobile.setModel("Iphone 5S");
		mobile.setPrice(599);
		Teacher teacher = new Teacher();
		teacher.setName("Justin Zhen");
		teacher.setAge(35);
		teacher.setCname("Information privacy and Security");
		teacher.setGender("male");
		mobile.setTeacher(teacher);
		Session se = sessionFactory.openSession();
		se.getTransaction().begin();
		se.save(mobile);
		se.getTransaction().commit();
	}

}
