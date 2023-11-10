package com.jsp.hibernate_case_study_entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cart 
{
	@Id
	private int cartId;
	@OneToMany
	private List<Product> plist = new ArrayList<Product>();
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public List<Product> getPlist() {
		return plist;
	}
	public void setPlist(List<Product> plist) {
		this.plist = plist;
	}
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", plist=" + plist + "]";
	}
	
}

