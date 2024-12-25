package com.SpringBootMVC.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBootMVC.Model.ProductDetails;
import com.SpringBootMVC.entity.ProductEntity;
import com.SpringBootMVC.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	double StockValue;
	double DisscountPrice;
	double FinalPrice;;
	double tax;
	double OfferPrice;
	public void saveProducts(ProductDetails productDetails) {
		
		StockValue=productDetails.getPrice()*productDetails.getQuantity();
		
		
		DisscountPrice=productDetails.getPrice()*productDetails.getDisscount()/100;
		
		
		tax=0.18*productDetails.getPrice();
		
		
		OfferPrice=productDetails.getPrice()-DisscountPrice;
		
		FinalPrice=OfferPrice+tax;
		
		//Add the data to entity class
		
		ProductEntity entity=new ProductEntity();
		entity.setName(productDetails.getName());
		entity.setMadin(productDetails.getMadin());
		entity.setBrand(productDetails.getBrand());
		entity.setPrice(productDetails.getPrice());
		entity.setQuantity(productDetails.getQuantity());
		entity.setDisscount(productDetails.getDisscount());
		
		entity.setStockValue(StockValue);
		entity.setDisscount(DisscountPrice);
		entity.setTax(tax);
		entity.setOfferPrice(OfferPrice);
		entity.setFinalPrice(FinalPrice);
		
		productRepository.save(entity);
		
	}

	public List<ProductEntity> getallproducts() {
		List<ProductEntity> products=productRepository.findAll();
		return products;
		
	}

	public ProductEntity searchproduct(Long id) {
		Optional<ProductEntity> entity=productRepository.findById(id);	
		if(entity.isPresent()) {
			ProductEntity product=entity.get();
			return product;
			
		}
		else {
			return null;
		}
	}

	public void deleteById(long id) {
		productRepository.deleteById(id);
		
	}

	public ProductDetails edit_product(long id) {
		Optional<ProductEntity> entity=productRepository.findById(id);
		if(entity.isPresent()) {
		ProductDetails edit= new ProductDetails();
		ProductEntity addModel=entity.get();
		edit.setName(addModel.getName());
		edit.setBrand(addModel.getBrand());
		edit.setMadin(addModel.getMadin());
		edit.setPrice(addModel.getPrice());
		edit.setQuantity(addModel.getQuantity());
		edit.setDisscount(addModel.getDisscount());
		
		return edit;
		}
		else {
			return null;
		}
		
	
		
		
	}

	public void update_product(long id, ProductDetails details) {
	Optional<ProductEntity> optional=	productRepository.findById(id);
	ProductEntity entity=optional.get();
	if(optional.isPresent()) {
		entity.setName(details.getName());
		entity.setBrand(details.getBrand());
		entity.setMadin(details.getMadin());
		entity.setPrice(details.getPrice());
		entity.setDisscount(details.getDisscount());
		entity.setQuantity(details.getQuantity());
		entity.setOfferPrice(OfferPrice);
		entity.setFinalPrice(FinalPrice);
		entity.setTax(tax);
		entity.setStockValue(StockValue);
		productRepository.save(entity);
		
		
		}
	
	}
	
}
