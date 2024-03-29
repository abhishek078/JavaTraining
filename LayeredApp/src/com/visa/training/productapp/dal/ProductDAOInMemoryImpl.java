package com.visa.training.productapp.dal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.visa.training.productapp.domain.Product;

public class ProductDAOInMemoryImpl implements ProductDAO {

	Map<Integer,Product> db = new HashMap<>();
	int idSequence = 0;
	
	@Override
	public Product save(Product toBeSaved) {
		int id = ++idSequence;
		toBeSaved.setId(id);
		db.put(id, toBeSaved);
		return toBeSaved;
	}

	@Override
	public Product findById(int id) {
		return db.get(id);
	}

	@Override
	public List<Product> findAll() {
		
		return new ArrayList<>(db.values());
	}

}
