package com.SpringBootMVC.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetails {
 
private	String name;
private	String madin;
private	String brand;
private	double price;
private	int quantity;
private	double disscount;
	
}
