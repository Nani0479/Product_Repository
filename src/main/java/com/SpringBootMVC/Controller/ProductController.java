package com.SpringBootMVC.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

import com.SpringBootMVC.Model.ProductDetails;
import com.SpringBootMVC.entity.ProductEntity;
import com.SpringBootMVC.service.ProductService;

import jakarta.websocket.server.PathParam;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	
@GetMapping("/Product")
	public String getProductForm() {
	
		return "add-product";
	}



@PostMapping("/saveproduct")
public String saveproduct(ProductDetails ProductDetails) {
	productService.saveProducts(ProductDetails);
     return "myview";
}

@GetMapping("/getallproducts")
public String getProducts(Model model) {
	List<ProductEntity> products=productService.getallproducts();
	model.addAttribute("products",products);
	return "getAllProducts";
}


@GetMapping("/searchProduct")
public String SearchProduct() {
	return "search-product";
}

@PostMapping("/search")
public String searchproduct(@RequestParam long id,Model model) {
	ProductEntity entity=productService.searchproduct(id);
	model.addAttribute("product", entity);
	return "search-product";
}

@GetMapping("/delete/{id}")
public String deleteById(@PathVariable("id") long id) {
	productService.deleteById(id);
	
	return "redirect:/getallproducts";
}

@GetMapping("/edit/{id}")
public String edit_product(@PathVariable("id") long id,Model model) {
	ProductDetails model1= productService.edit_product(id);
	model.addAttribute("product", model1);
	model.addAttribute("id", id);
	return "edit-product";
}
@PostMapping("/edit-product/{id}")
public String update_product(@PathVariable("id") Long id,ProductDetails details) {
	
	productService.update_product(id,details);
	
	return "redirect:/getallproducts";
}


		
}
