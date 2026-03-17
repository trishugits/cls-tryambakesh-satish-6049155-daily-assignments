package cg.demo.associationmapping;

import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;

import java.util.Set;

import jakarta.persistence.*;
//INVERSE SIDE ------MAPPED BY
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pId;
	private String pName;
	private int price;
	@ManyToMany(mappedBy="products")
	Set<Customer> customers;
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
