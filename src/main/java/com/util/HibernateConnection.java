package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.test.Products;

public class HibernateConnection {
	
	
	public static SessionFactory getSessionFactory()
	{
		Configuration cf=new Configuration();
		cf.configure();
		cf.addAnnotatedClass(Products.class);
		SessionFactory sf = cf.buildSessionFactory();
		return sf;
	}

}
