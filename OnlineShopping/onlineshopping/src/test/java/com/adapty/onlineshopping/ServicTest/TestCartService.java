package com.adapty.onlineshopping.ServicTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.adapty.onlineshopping.Entities.Cart;
import com.adapty.onlineshopping.Repository.CartRepository;
import com.adapty.onlineshopping.Services.CartImpl;


@ExtendWith(MockitoExtension.class)
public class TestCartService
{

    @InjectMocks
    CartImpl srvObj;

    @Mock
    CartRepository repoObj;

    // @Test
    //  public void fetchAllProductsTest()
    //  {
    //     List<Cart> list1=new ArrayList<Cart>();
    //     Cart c1= new Cart("cart-001", 2, "E101");
    //     Cart c2= new Cart("cart-002", 1, "M101");
    //     list1.add(c1);
    //     list1.add(c2)
    //     ;
    //     when(repoObj.findAll()).thenReturn(list1);
    //     ArrayList<Cart> cList=srvObj.fetchAllProducts();
    //     assertEquals(2, cList.size());
    //     verify(repoObj,times(1)).findAll();

    // }


    @Test
    public void fetchByCartIdTest()
    {
        Cart c1=new Cart("C101", 2, "M101");
        when(repoObj.findById("C101")).thenReturn(Optional.of(c1));
        Optional<Cart> p=srvObj.fetchByCartItemId(c1.getCartItemId());
        assertEquals(c1.getCartItemId(), p.get().cartItemId);
    }


    @Test
    public void deleteByCartIdTest()
    {
        
        Cart c1=new Cart("C101", 2, "M101");
        String msg=srvObj.deleteByCartId(c1.getCartItemId());
        assertEquals("Object deleted", msg);
    }


    @Test
    public void addToCartTet()
    {
        Cart c1=new Cart("C101", 2, "M101");
        repoObj.save(c1);
        verify(repoObj,times(1)).save(c1);
    }


    @Test
    public void updateProductByIdTest()
    {
        Cart c1=new Cart("C101", 2, "M101");
    
        c1.setCartItemQty(4);
        c1.setProductId("E101");


         Assertions.assertThat(c1.getCartItemQty()).isEqualTo(4);
        Assertions.assertThat(c1.getProductId()).isEqualTo("E101");
    }


    @Test
    public void deleteItemByProductId()
    {
        Cart c1=new Cart("C101", 2, "M101");

        String msg=srvObj.deleteItemByProductId(c1.getProductId());
        assertEquals("deleted", msg);
    }

    
}
