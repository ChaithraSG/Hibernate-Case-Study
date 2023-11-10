package com.jsp.hibernate_case_study_dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jsp.hibernate_case_study_entity.Product;

public class Productsdao {

	Configuration cfg=new Configuration().configure().addAnnotatedClass(Product.class);
	SessionFactory sf = cfg.buildSessionFactory();
	
	Scanner sc=new Scanner(System.in);


	public void addProduct() {

		System.out.println("enter productid");
		int pId=sc.nextInt();
		System.out.println("enter productName");
		String pname=sc.next();
		System.out.println("enter productprice");
		int pPrice=sc.nextInt();
		System.out.println("enter ProductQuantity");

		Product p=new Product();
		p.setProductId(pId);
		p.setProductName(pname);
		
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(p);
		transaction.commit();
		session.close();


	}
	public void getProductById() {
		System.out.println("enter productid to fetched");
		int pId=sc.nextInt();
		
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		Product product = session.get(Product.class, pId);
		System.out.println(product);
		
		
		
	}
	public void getAllProduct() {
		
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		
		Query query = session.createQuery("from Product");
		List<Product> list = query.getResultList();
		
		for(Product p:list) {
			System.out.println(p);
		}
		
		transaction.commit();
		session.close();
		
		
	}
	public void updateProduct() {
		System.out.println("enter product id");
		int pId=sc.nextInt();

		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		Product product = session.get(Product.class, pId);
		
		if(product!=null)
		{
			System.out.println("Enter the name for updation,Invalid input");
			String pname=sc.next();
			product.setProductName(pname);
			session.update(product);
			
		}
		else {
			System.out.println("Product not present in db");
		}
		tr.commit();
		session.close();

		
	}
	public void deleteProduct() {
		
		System.out.println("enter product id");
		int pId=sc.nextInt();

		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		Product product = session.get(Product.class, pId);
		
		if(product!=null)
		{
			session.delete(product);
		}
		else {
			System.out.println("product not present");
		}
		tr.commit();
		session.close();
		
	}

}

