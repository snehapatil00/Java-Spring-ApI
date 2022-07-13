package com.adapty.onlineshopping.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.adapty.onlineshopping.Entities.Cart;

public interface CartInterface {

    public ArrayList fetchAllProducts();

    public Optional<Cart> fetchByCartItemId(String cartItemId);

    public String addTocart(Cart cartObj);

    public String deleteByCartId(String id);

    public Cart updateByCartId(Cart cartObj);

    public String deleteItemByProductId(String productId);

    
  //  public float totalByProductPrice();


}
