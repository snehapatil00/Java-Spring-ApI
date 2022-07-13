package com.adapty.onlineshopping.ServicTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.adapty.onlineshopping.Entities.Cart;
import com.adapty.onlineshopping.Repository.CartRepository;
import com.adapty.onlineshopping.Services.CartImpl;

@ExtendWith(MockitoExtension.class)
public class TestCartService {

    @InjectMocks
    CartImpl srvObj;

    @Mock
    CartRepository repoObj;

    // @Test
    //  public void fetchAllProductsTest(){
    //     List<Cart> list1=new LinkedList<Cart>();
    //     Cart c1= new Cart("cart-001", 2, "E101");
    //     Cart c2= new Cart("cart-002", 1, "M101");
    //     list1.add(c1);
    //     list1.add(c2);

    //     when(repoObj.findAll()).thenReturn(list1);
    //     List<Cart> cartList=srvObj.fetchAllProducts();
    //     assertEquals(2, cartList.size());
    //     verify(repoObj,times(1)).findAll();

    // }
    
}
