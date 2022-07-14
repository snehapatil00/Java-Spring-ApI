package com.adapty.onlineshopping.Services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.adapty.onlineshopping.Entities.Cart;
import com.adapty.onlineshopping.Entities.Product;
import com.adapty.onlineshopping.Entities.STATUS;
import com.adapty.onlineshopping.Repository.CartRepository;
import com.adapty.onlineshopping.Repository.ProductRepository;


@Service
public class CartImpl  implements CartInterface {
    @Autowired
    CartRepository CrepoObj;         //cart Repository Object
    @Autowired
    ProductRepository repoObj;       //product repository Object

//     public ArrayList fetchAllProducts(){
//         float totalPrice=0;
//         int i = 0;
//         ArrayList list = new ArrayList();
//         List<Cart> c1 = CrepoObj.findAll();
//         System.out.println(c1);
//         Optional<Product> c2 = repoObj.findById(c1.get(i).getProductId());
//         for(i = 0; i<c1.size();i++){
//             int c3 = c1.get(i).getCartItemQty();
//             totalPrice = totalPrice + (c3*c2.get().getProductPrice());  
//             }
//     List<Float> c4=new LinkedList<Float>();
//     c4.add(totalPrice);
//     list.add(Arrays.asList(c2.get().getProductImage(),c2.get().getProductName(),c2.get().getProductPrice(),c2.get().getProductCategory(),c2.get().getProductDescription(),c2.get().getProductStatus()));
   
//     //List<Object> newList =Stream.of(c1,c4,c5).flatMap(Collection::stream).collect(Collectors.toList());
//     return list;

// }
        //return CrepoObj.findAll();

        
    public ArrayList fetchAllProducts() throws NoSuchElementException
    {
            float totalPrice=0;
            int i=0;
            ArrayList list = new ArrayList();
            List<Cart> c1 = CrepoObj.findAll();
            for(i = 0; i<c1.size();i++)
            {
                
                Optional<Product> c2 = repoObj.findById(c1.get(i).getProductId());
                int c3 = c1.get(i).getCartItemQty();
                totalPrice = totalPrice + (c3*c2.get().getProductPrice()); 
                list.add(Arrays.asList(c2.get().getProductImage(),c2.get().getProductName(),c2.get().getProductPrice(),c2.get().getProductCategory(),c2.get().getProductDescription(),c2.get().getProductStatus()));  
                list.add(totalPrice);
                list.add(c1.get(i).getProductId());
                list.add(c1.get(i).getCartItemQty());
                
            }
            return list;
    }
    

    public Optional<Cart> fetchByCartItemId(String cartItemId)
    {
        return CrepoObj.findById(cartItemId);
    }


    public String addTocart(Cart cartObj)
    {
        Optional<Product> obj = repoObj.findById(cartObj.getProductId());
        if(obj.isPresent())
        {
          if(obj.get().getProductStatus()==STATUS.ACTIVE)
           {
            CrepoObj.save(cartObj);
            return "Added Successfully";
           }
         else
           {
            return "Not Found";
           }
        }
        else
        {
            return " Product unavailable";
        }
      
    }


    public String deleteByCartId(String id)
    {
        CrepoObj.deleteById(id);
          return "Object deleted";
    }
    

    public Cart updateByCartId(Cart cartObj)
    {
        if (cartObj.getCartItemId()==null)
        {
            return null;
        }
        else
        {
            Optional<Cart> p1=CrepoObj.findById(cartObj.getCartItemId());
            p1.get().setCartItemQty(cartObj.getCartItemQty());
            p1.get().setProductId(cartObj.getProductId());

            CrepoObj.deleteById(cartObj.getCartItemId());
            CrepoObj.save(p1.get());
            return cartObj;
        }

    }
       

    public String deleteItemByProductId(String productId)
    {
        CrepoObj.deleteByProductId(productId);
        return "deleted";
    }
    
   
}    
