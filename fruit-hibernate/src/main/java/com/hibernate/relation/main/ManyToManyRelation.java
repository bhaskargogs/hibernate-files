package com.hibernate.relation.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.hibernate.relation.model.Address;
import com.hibernate.relation.model.Mobile;
import com.hibernate.relation.model.Student;
import com.hibernate.relation.model.Teacher;

public class ManyToManyRelation {

	public static void main(String[] args) {
		AnnotationConfiguration annotationConfiguration = new AnnotationConfiguration();
		annotationConfiguration = annotationConfiguration.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = annotationConfiguration.buildSessionFactory();

		Mobile mobile = new Mobile();
		mobile.setModel("S6");
		mobile.setNumber("827834891");
		mobile.setPrice(499);
		mobile.setVendor("Samsung");

		Teacher teacher = new Teacher();
		teacher.setName("Nagendra");
		teacher.setAge(35);
		teacher.setCname("Spring Framework, Hibernate and JS");
		teacher.setGender("male");
		mobile.setTeacher(teacher);
		
		Student s1 = new Student();
		s1.setName("Bhaskar");
		s1.setGrade(3);
		s1.setGender("male");
		s1.setStandard("Graduate");
		s1.setTeacher(teacher);

		Student s2 = new Student();
		s2.setName("Harish");
		s2.setGrade(4);
		s2.setGender("male");
		s2.setStandard("Undergraduate");
		s2.setTeacher(teacher);

		List<Student> students = new ArrayList<>();
		students.add(s1);
		students.add(s2);

		teacher.setStudents(students);
		
		Teacher teacher2 = new Teacher();
		teacher2.setAge(40);
		teacher2.setName("Mr. Harish");
		teacher2.setCname("The beauty of Cars");
		teacher2.setGender("male");
		
		Address ad1 = new Address();
		ad1.setStreet("Bethoveen");
		ad1.setCity("Fremont");
		ad1.setPincode("94538");
		
		Address ad2 = new Address();
		ad2.setStreet("Lawndale");
		ad2.setCity("Greensboro");
		ad2.setPincode("27411");
		
		Set<Address> addresses = new HashSet<>();
		addresses.add(ad1);
		addresses.add(ad2);
		
		teacher.setAddresses(addresses);
		teacher2.setAddresses(addresses);
		

		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(mobile);
		session.save(teacher2);
		session.getTransaction().commit();
	}

}
