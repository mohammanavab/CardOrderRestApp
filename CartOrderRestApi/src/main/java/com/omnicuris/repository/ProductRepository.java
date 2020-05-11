package com.omnicuris.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.omnicuris.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{
	
}
