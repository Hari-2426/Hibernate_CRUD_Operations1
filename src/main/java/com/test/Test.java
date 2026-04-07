package com.test;



import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.util.HibernateConnection;

public class Test {
	
	
	public static void main(String[] args) {
		
		
		
		
		insertOperation();
		
		selectOperation();
		
		updateOperation();
		
		deleteOperation();
		
		selectOperation();
		
		hibernateStates();
		
		
		
		
		
		
		
	}

	private static void hibernateStates() {
		SessionFactory sf = HibernateConnection.getSessionFactory();

		// 🔹 STEP 1: TRANSIENT STATE
		Products p = new Products(1006, "Refrigerator", 30000.0, "Samsung");

		// 🔹 STEP 2: PERSISTENT STATE
		Session s1 = sf.openSession();
		s1.beginTransaction();

		s1.persist(p);  

		p.setPname("Double Door Refrigerator");  

		s1.getTransaction().commit();
		s1.close();  

		// 🔹 STEP 3: DETACHED STATE
		p.setPname("LG Refrigerator");  
		// ❗ Change NOT saved automatically

		// 🔹 STEP 4: REATTACH (Detached → Persistent again)
		Session s2 = sf.openSession();
		s2.beginTransaction();

		s2.merge(p);  
		// 👉 Reattaching detached object

		s2.getTransaction().commit();
		s2.close();

		System.out.println("All states executed successfully...");
	}

	private static void updateOperation() {
		SessionFactory sf=HibernateConnection.getSessionFactory();
		Session s=sf.openSession();
		
		Products p=s.find(Products.class, 1003);
		if(p!=null)
		{
			s.beginTransaction();
			p.setPname("Iqoo Neo 6");
			p.setPprice(25000.0d);
			p.setManufactureCompany("Vivo");
			s.getTransaction().commit();
			
			System.out.println("Data Updated Sucessfully!!!!");
			
			Products p1=s.find(Products.class, 1003);
			System.out.println(p1);
		}
		else
		{
			System.out.println("Data Not Found!!!!");
		}
		s.close();
		
	}

	private static void deleteOperation() {
		SessionFactory sf=HibernateConnection.getSessionFactory();
		Session s=sf.openSession();
		
		Products p=s.find(Products.class, 1005);
		if(p!=null)
		{
			s.beginTransaction();
			s.remove(p);
			
			s.getTransaction().commit();
			System.out.println("Deleted Product : "+p);
		}
		else
		{
			System.out.println("Data Not Found!!!!");
		}
		s.close();
		
	}

	private static void selectOperation() {
		SessionFactory sf=HibernateConnection.getSessionFactory();
		Session s=sf.openSession();
		for(int i=1002;i<=1005;i++)
		{
			Products p=s.find(Products.class, i);
			System.out.println(p);
		}
		
		System.out.println("Data Retrived Successfully!!!!!");
		s.close();
	}

	private static void insertOperation() {
		SessionFactory sf=HibernateConnection.getSessionFactory();
		Session s=sf.openSession();
		
		Products p1=new Products(1002,"Iphone 16",75000,"Apple");
		Products p2=new Products(1003,"Pixel",79000,"Google");
		Products p3=new Products(1004,"Nokia",85000,"Nokia");
		Products p4=new Products(1005,"Redmi Note 13",89999,"Xamoi");
		s.beginTransaction();
		s.persist(p1);
		s.persist(p2);
		s.persist(p3);
		s.persist(p4);
		s.getTransaction().commit();
		System.out.println("Data Inserted into database successfully!!!!");
		s.close();
	}

}
