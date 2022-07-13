package com.adapty.onlineshopping.Repository;




import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adapty.onlineshopping.Entities.Cart;
@Repository
public interface CartRepository extends JpaRepository<Cart,String>{

   

    @Transactional
    public Optional<String> deleteByProductId(String productId);


    //public Optional<float> totalByProductPrice();

   
    
}
