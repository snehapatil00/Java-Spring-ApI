package com.adapty.onlineshopping.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adapty.onlineshopping.Entities.Product;
import com.adapty.onlineshopping.Services.ProductImpl;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductImpl srv;
    
    @GetMapping(value = "")
    public  List<Product>fetchAllProducts(){
        return srv.fetchAllProducts();
}
@GetMapping(value="{id}") 
public Optional<Product> fetchProductById(@PathVariable("id") Product productId){
    return srv.fetchProductById(productId);
}

@PostMapping(value = "/create")
    public Product addProduct(@RequestBody Product obj){
return srv.addProduct(obj);

    }

    @PutMapping(value="/modify/")
    public Product updateProductById(@RequestBody Product obj) {
       return srv.updateProductById(obj);
    }
   
//     @GetMapping(value="/find/{category}")
// public Optional<List<Product>>findProductByProductCategory (@PathVariable("category") CATEGORIES category){
//     return srv.findProductByProductCategory(category);
// }

@DeleteMapping(value  = "{id}")
    public String deleteByProductID (@PathVariable("id") Product productobj){
        return srv.deleteByProductID(productobj);
}

    
}