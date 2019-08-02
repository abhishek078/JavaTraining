package com.visa.training.productapp.dal;

import java.util.List;

import com.visa.training.productapp.domain.Product;

public interface ProductDAO {
	
	public Product save(Product toBeSaved);
	public Product findById(int id);
	public List<Product> findAll();
	//methods for delete or update follow

}
