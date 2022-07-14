package com.adapty.onlineshopping.Controller;

import java.util.ArrayList;
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
import com.adapty.onlineshopping.Entities.Cart;
import com.adapty.onlineshopping.Services.CartImpl;

@RestController
@RequestMapping("/api/cart")
public class CartController 
{
    @Autowired
     CartImpl srv;                          //cartImplementation object

    // Fetching all the product in the cart table
    @GetMapping(value = "")
    public ArrayList fetchAllProducts()
    {
        return srv.fetchAllProducts();
    }
    

    // fetching the product by cartItemId
    @GetMapping(value = "/{id}")
    public Optional<Cart> fetchByCartItemId(@PathVariable("id") String cartItemId)
    {
        return srv.fetchByCartItemId(cartItemId);
    }


    // add the product in the cart
    @PostMapping(value = "/add")
    public String addTocart(@RequestBody Cart cartObj)
    {
       return srv.addTocart(cartObj);
    }


    //To delete by cartaId
    @DeleteMapping(value  = "/{id}")
    public String deleteByCarttId (@PathVariable("id") String id)
    {
        return srv.deleteByCartId(id);
    }


    //Update the cart data
    @PutMapping(value="/modify/")
    public Cart updateByCartId(@RequestBody Cart cartObj)
    {
        return srv.updateByCartId(cartObj);
    }
     

    //delete the cart data by productId
    @DeleteMapping(value  = "/item/{pid}")
    public String deleteItemByProductId (@PathVariable("pid") String productId)
    {
        return srv.deleteItemByProductId(productId);
    }

}