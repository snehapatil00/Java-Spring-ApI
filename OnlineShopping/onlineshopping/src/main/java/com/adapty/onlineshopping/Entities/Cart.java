package com.adapty.onlineshopping.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;




@Entity(name = "cart")
public class Cart
{
    @Id
    public String cartItemId;
    public int cartItemQty;
    @Column(name = "productId",nullable=false,insertable=true,updatable=true)
    public String productId;
    

    
    //Empty Constructor
    public Cart()
    {

    }

    //parameterized Constructor
    public Cart(String cartItemId, int cartItemQty,String productId)
    {
        this.cartItemId = cartItemId;
        this.cartItemQty = cartItemQty;
        this.productId=productId;
    }


   
    //getter and setter
    public String getCartItemId() 
    {
        return this.cartItemId;
    }

    public void setCartItemId(String cartItemId) 
    {
        this.cartItemId = cartItemId;
    }

    public int getCartItemQty() 
    {
        return this.cartItemQty;
    }

    public void setCartItemQty(int cartItemQty) 
    {
        this.cartItemQty = cartItemQty;
    }

    public String getProductId() 
    {
        return this.productId;
    }

    public void setProductId(String productId) 
    {
        this.productId = productId;
    }


    

    @Override
    public String toString() 
    {
        return "{" +
            " cartItemId='" + getCartItemId() + "'" +
            ", cartItemQty='" + getCartItemQty() + "'" +
            ", productId='" + getProductId() + "'" +
            "}";
    }

   
    
    
}






    

