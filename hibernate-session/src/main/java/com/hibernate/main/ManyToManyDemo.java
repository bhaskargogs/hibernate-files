package com.hibernate.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.hibernate.model.Address;
import com.hibernate.model.CreditCard;
import com.hibernate.model.Passport;
import com.hibernate.model.Person;

public class ManyToManyDemo {
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
		
		CreditCard creditCard1=new CreditCard();
		creditCard1.setCardNumber("02393838376262");
		creditCard1.setCvv("896");
		creditCard1.setType("VISA");
		creditCard1.setName("Amit Kumar");
		creditCard1.setPerson(person);//this we have to do for sure
		
		CreditCard creditCard2=new CreditCard();
		creditCard2.setCardNumber("9736352536373");
		creditCard2.setCvv("643");
		creditCard2.setType("MASTER");
		creditCard2.setName("Amit Kumar");
        creditCard2.setPerson(person); ///this we have to do for sure
		
		List<CreditCard> cards=new ArrayList<>();
		cards.add(creditCard1);
		cards.add(creditCard2);
		
		person.setCreditCards(cards); //
		
		//Many to Many
		Address address1=new Address();
		address1.setCity("Fremont");
		address1.setStreet("CA102");
		address1.setPincode("9393");
		
		Address address2=new Address();
		address2.setCity("New York");
		address2.setStreet("NY102");
		address2.setPincode("3292");
		Set<Address> addresses=new HashSet<>();
		addresses.add(address1);
		addresses.add(address2);
		
		Person person1=new Person();
		person1.setEmail("krjsywww@gmail.com");
		person1.setGender("Female");
		person1.setMobile("0937363333");
		person1.setName("Ms. Komal Singh");
		
		person.setAddresses(addresses);
		person1.setAddresses(addresses);
		
		
		//fetch the session
		Session session=sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(passport); //here we are persisting person with passport
		System.out.println("_______________________________________");
		System.out.println("_______________________________________");
		System.out.println("_______________________________________");
		System.out.println("_______________________________________");
		session.save(person1); //here we are saving person independently 
		session.getTransaction().commit();
		System.out.println("Hey!!!!!!!!!!!! Object is in database!!!!!!!");
	}

}
