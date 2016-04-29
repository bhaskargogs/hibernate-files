package com.hibernate.inheritance.main;

import org.hibernate.Session;

import com.hibernate.inheritance.model.NonVegPizza;
import com.hibernate.inheritance.model.Pizza;
import com.hibernate.inheritance.model.VegPizza;
import com.hibernate.util.HibernateSessionManagerUtil;

public class TableBySubclass {
	public static void main(String[] args) {
Session session = HibernateSessionManagerUtil.getHibernateSession();
		
		System.out.println("________________________________________________________");
		System.out.println("_________Implementation of Table per subclass heirarchy_____");
		System.out.println("________________________________________________________");
		Pizza pizza=new Pizza();
		pizza.setPid(100);
		pizza.setBase("Plain");
		pizza.setSize("Medium");
		pizza.setType("Stylish");
		pizza.setDescription("This is plain Pizza");
		
		VegPizza vegPizza=new VegPizza();
		vegPizza.setPid(200);
		vegPizza.setBase("Plain");
		vegPizza.setSize("Medium");
		vegPizza.setType("Grilled");
		vegPizza.setDescription("This is a veg Pizza ");
		vegPizza.setToppings("cheese,onions,tomato,mushroom,olives");
		vegPizza.setPrice(102);
		
		
		NonVegPizza nonvegPizza=new NonVegPizza();
		nonvegPizza.setPid(300);
		nonvegPizza.setBase("Cheese Burst");
		nonvegPizza.setSize("Family");
		nonvegPizza.setType("Homemade");
		nonvegPizza.setDescription("This is a non-veg Pizza");
		nonvegPizza.setToppings("onions, tomatoes, fish, olives");
		nonvegPizza.setPrice(250);
		
		
		session.getTransaction().begin();
		session.save(pizza);
		session.save(nonvegPizza);
		session.save(vegPizza);
		session.getTransaction().commit();
		
		System.out.println("_______Implemented table per subclass heirarchy________");

	}
}
