package com.jsp.hibernate_case_study_dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.jsp.hibernate_case_study_entity.Cart;
import com.jsp.hibernate_case_study_entity.Product;

public class Cartdao
{
	Configuration cfg = new Configuration().configure().addAnnotatedClass(Cart.class);
	SessionFactory sf = cfg.buildSessionFactory();	
	
	public String addCart(Cart cart)
	{
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		session.save(cart);
		trans.commit();
		session.close();
		return "product added to cart";
	}
	public Product getCartbyId(int id) 
	{	
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		
		return null;	
	}
	
	public List<Cart> getallCart() 
	{
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		Query query = session.createQuery("from Cart");
		List<Cart> cart = query.getResultList();
		trans.commit();
		session.close();
		
		return cart;	
	}
	
	public String updateCart (Cart cart) 
	{
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		session.update(cart);
		trans.commit();
		session.close();
		
		return "cart successfully updated";
	}
	
	public String deleteCart(Cart cart) 
	{
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		session.delete(cart);
		trans.commit();
		session.close();
		
		return "product in cart successfully deleted";
	}


}
