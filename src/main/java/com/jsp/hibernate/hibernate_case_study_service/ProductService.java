package com.jsp.hibernate.hibernate_case_study_service;

import java.util.List;
import java.util.Scanner;

import com.jsp.hibernate_case_study_dao.Productdao;
import com.jsp.hibernate_case_study_entity.Product;

public class ProductService 
{
	Productdao dao = new Productdao();
	
	Scanner sc = new Scanner(System.in);
		public void addProduct()
		{
			System.out.println("Enter product name");
			String name = sc.next();
			
			System.out.println("Enter product price");
			String price = sc.next();
			
			System.out.println("Enter product quantity");
			String quantity = sc.next();
			
			Product product = new Product();
			product.setProductName(name);
			product.setProductPrice(price);
			product.setProductQuantity(quantity);
			
			String message = dao.addProduct(product);
			System.out.println(message);
		}
		
		public void updateproduct() 
		{
			System.out.println("Enter the product Id to update:");
			int id = sc.nextInt();
			
			Product product = dao.getproductbyId(id);
			if(product != null)
			{
				System.out.println(product.getProductName()+" "+product.getProductPrice()+" "+product.getProductQuantity()+" ");
				
				System.out.println("Enter product name");
				String name = sc.next();
				
				System.out.println("Enter product price");
				String price = sc.next();
				
				System.out.println("Enter product quantity");
				String quantity = sc.next();
				
				product.setProductName(name);
				product.setProductPrice(price);
				product.setProductQuantity(quantity);
				
				dao.updateproduct(product);
			}
			else
			{
				System.out.println("product not updated");
			}
		}
		
		public void getproductbyId()
		{
			System.out.println("Enter the productid to update");
			int id = sc.nextInt();
			
			Product product = dao.getproductbyId(id);
		}

		public void deleteproduct() {
			System.out.println("Enter the productId to delete");
			int id = sc.nextInt();
			
//			Product product = dao.deleteproduct(id);
			
		}

		public void getallproducts() 
		{
			System.out.println("product deatils");
			int id = sc.nextInt();
		
			List<Product> product = dao.getallproducts();		
		}


}
