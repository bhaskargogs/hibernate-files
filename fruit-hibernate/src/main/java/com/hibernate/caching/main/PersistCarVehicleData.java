package com.hibernate.caching.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.hibernate.caching.model.Car;
import com.hibernate.caching.model.Vehicle;
import com.hibernate.util.HibernateSessionManagerUtil;

public class PersistCarVehicleData {

	public static void main(String[] args) {
		Session session = HibernateSessionManagerUtil.getHibernateSession();
		session.getTransaction().begin();
		Vehicle vehicle = new Vehicle("Car","4");
		Car c1 = new Car("Mustang", "2003", "Praveen Kumar", 13459.99);
		c1.setVehicle(vehicle);
		Car c2 = new Car("Lexis","LFA","Geovino",450654.34);
		c2.setVehicle(vehicle);
		Car c3 = new Car("Tesla","Series3","Anderson Motors",87234.98);
		c3.setVehicle(vehicle);
		List<Car> cars = new ArrayList<>();
		cars.add(c1);
		cars.add(c2);
		cars.add(c3);
		
		vehicle.setCars(cars);
		
		session.save(vehicle);
		session.getTransaction().commit();
		
		
		
	}

}
