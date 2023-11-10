package com.jsp.hibernate_case_study_dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.jsp.hibernate_case_study_entity.Product;

public class Productdao
{
	Configuration cfg = new Configuration().configure().addAnnotatedClass(Product.class);
	SessionFactory sf = cfg.buildSessionFactory();		
	
	public String addProduct(Product product) 
	{
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		session.save(product);
		trans.commit();
		session.close();

		return "product successfully saved";
	}
	
	public Product getproductbyId(int id) 
	{	
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		
		return null;	
	}
	
	public List<Product> getallproducts() 
	{
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		Query query = session.createQuery("from Product");
		List<Product> products = query.getResultList();
		trans.commit();
		session.close();
		
		return products;	
	}
	
	public String updateproduct (Product product) 
	{
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		session.update(product);
		trans.commit();
		session.close();
		
		return "product successfully updated";
	}
	
	public String deleteproduct(Product product) 
	{
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		session.delete(product);
		trans.commit();
		session.close();
		
		return "product successfully deleted";
	}
}
