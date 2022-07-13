package com.adapty.onlineshopping.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adapty.onlineshopping.Entities.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product,String>{

  // public Optional<List<Product>>findProductByProductCategory (CATEGORIES category);

    
}
