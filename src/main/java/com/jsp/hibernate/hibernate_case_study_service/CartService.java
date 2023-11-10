package com.jsp.hibernate.hibernate_case_study_service;

import java.util.Scanner;

import com.jsp.hibernate_case_study_dao.Cartdao;
import com.jsp.hibernate_case_study_entity.Cart;

public class CartService 
{
	Cartdao cdao = new Cartdao();
	
	Scanner sc = new Scanner(System.in);
	
	public void addCart()
	{
		System.out.println("Enter the Cart Id");
		int cid=sc.nextInt();
		
		Cart cart=new Cart();
		cart.setCartId(cid);
		
		String message = cdao.addCart(cart);
		System.out.println(message);
	}
	public void updatecart()
	{
		System.out.println("Enter the Cart Id to be updated");
		int cid=sc.nextInt();
		
		Cart cart = new Cart();
		cart.setCartId(cid);
		
		String message = cdao.updateCart(cart);
		System.out.println(message);
		
	}
}
