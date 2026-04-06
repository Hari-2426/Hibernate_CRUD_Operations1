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
