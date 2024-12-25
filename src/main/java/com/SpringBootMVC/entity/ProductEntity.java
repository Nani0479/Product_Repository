package com.SpringBootMVC.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Product_Information")
public class ProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long   id;
	private	String name;
	private	String madin;
	private String brand;
	private	double price;
	private	int    quantity;
	private	double disscount;
	private double tax;
	private double offerPrice;
	private double finalPrice;
	private double stockValue;
	
}
