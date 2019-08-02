package com.visa.training.productapp.ui;

import java.util.Scanner;

import com.visa.training.productapp.domain.Product;
import com.visa.training.productapp.service.ProductService;
import com.visa.training.productapp.service.ProductServiceImpl;

public class ProductConsoleUI {
	
	ProductService service = new ProductServiceImpl();
	
	public void createProductWithUI() {
		String name = fromKeyboard("Enter name: ");
		float price = Float.parseFloat(fromKeyboard("Enter price: "));
		int qoh = Integer.parseInt(fromKeyboard("Enter the qoh"));
		
		Product p = new Product(name,price,qoh);
		int id = service.createNewProduct(p);
		System.out.println("Created product with id: "+id);
	}

	private String fromKeyboard(String string) {
		System.out.println(string);
		Scanner s = new Scanner(System.in);
		s.close();
		return s.nextLine();
		
	}

}
