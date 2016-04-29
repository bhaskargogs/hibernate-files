package com.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateSessionManagerUtil {

	static private SessionFactory sessionFactory;
	
	static {
		AnnotationConfiguration annotationConfiguration=new AnnotationConfiguration();
		annotationConfiguration =annotationConfiguration.configure("hibernate.cfg.xml");
	 sessionFactory=annotationConfiguration.buildSessionFactory();
	}
	
	public static Session getHibernateSession(){
			return sessionFactory.openSession();
	}
	
}
