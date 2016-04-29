package com.hibernate.main;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.hibernate.model.Human;
import com.hibernate.model.Laptop;
import com.hibernate.util.HibernateSessionManagerUtil;

public class FetchOneToManyNPlusOne {
	
	public static void main(String[] args) {
		Session session=HibernateSessionManagerUtil.getHibernateSession();
		int count=0;
		Query query=session.createQuery("from Human");
		count++;
		List<Human> list=query.list();
		
		for(Human entity:list){
			System.out.println("__ "+count++);
			List<Laptop> laptops=entity.getLaptops();
			System.out.println(laptops);
		}
		
		System.out.println("Total number of queries are = "+count);
	}

}
