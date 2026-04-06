package com.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.test.Products;

public class HibernateConnection {
	
	public static SessionFactory sf=null;
	public static SessionFactory getSessionFactory()
	{
		if(sf==null)
		{	
			Configuration cf=new Configuration();
			cf.configure();
			cf.addAnnotatedClass(Products.class);
			return sf = cf.buildSessionFactory();
		}
		else
		{
			return sf;
		}
	}

}
