package com.adapty.onlineshopping.Services;

import java.util.List;
import java.util.Optional;

import com.adapty.onlineshopping.Entities.Product;

public interface ProductInterface  {

    public List<Product>fetchAllProducts();

    public Optional<Product> fetchProductById(Product productId);

    public Product addProduct(Product productobj);

    public Product updateProductById(Product obj);

   //public Optional<List<Product> >findProductByProductCategory(CATEGORIES category);

   public String deleteByProductID(Product productObj);









    
}
