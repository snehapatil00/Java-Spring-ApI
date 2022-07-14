package com.adapty.onlineshopping.ServicTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.adapty.onlineshopping.Entities.CATEGORIES;
import com.adapty.onlineshopping.Entities.Product;
import com.adapty.onlineshopping.Entities.STATUS;
import com.adapty.onlineshopping.Repository.ProductRepository;
import com.adapty.onlineshopping.Services.ProductImpl;

@ExtendWith(MockitoExtension.class)
public class TestProductService
{
    
    @InjectMocks
     ProductImpl srvObj;

     @Mock
     ProductRepository repoObj;

    @Test
    public void fetchAllProductsTest()
    {
        List<Product> list1=new LinkedList<Product>();

        Product p1=new Product("prd-001", "Iphone",CATEGORIES.MOBILES, 4567.f, "abcc", "https://rukminim1.flixcart.com/image/416/416/k2jbyq80pkrrdj/mobile-refurbished/y/k/z/iphone-11-64-a-mwlx2hn-a-apple-0-original-imafkg24ymsjav9h.jpeg?q=70oductImage", STATUS.ACTIVE);
        Product p2=new Product("prd-002", "Iphone",CATEGORIES.MOBILES, 4567.f, "abcc", "https://rukminim1.flixcart.com/image/416/416/k2jbyq80pkrrdj/mobile-refurbished/y/k/z/iphone-11-64-a-mwlx2hn-a-apple-0-original-imafkg24ymsjav9h.jpeg?q=70oductImage", STATUS.ACTIVE);
        list1.add(p1);
        list1.add(p2);

        when(repoObj.findAll()).thenReturn(list1);
        List<Product> productList=srvObj.fetchAllProducts();
        assertEquals(2, productList.size());
        verify(repoObj,times(1)).findAll();

    }


    @Test
    public  void fetchProductByIdTest()
    {
        Product p1 = new Product("E101", "Iphone", CATEGORIES.MOBILES,   345.54f, "AAcc","https://rukminim1.flixcart.com/image/416/416/k2jbyq80pkrrdj/mobile-refurbished/y/k/z/iphone-11-64-a-mwlx2hn-a-apple-0-original-imafkg24ymsjav9h.jpeg?q=70oductImage" , STATUS.ACTIVE);
        repoObj.save(p1);
        when(repoObj.findById("E101")).thenReturn(java.util.Optional.of(p1));
    
        Optional<Product> p2 = srvObj.fetchProductById(p1);
        assertEquals(STATUS.ACTIVE, p2.get().getProductStatus());
        assertEquals(p1.getProductId(),p2.get().getProductId());
        assertEquals(p1.getProductName(), p2.get().getProductName());
        assertEquals(p1.getProductCategory(), p2.get().getProductCategory());
        assertEquals(p1.getProductImage(),p2.get().getProductImage());
        assertEquals(p1.getProductPrice(), p2.get().getProductPrice());
        assertEquals(p1.getProductDescription(), p2.get().getProductDescription());
        assertEquals(p1.getProductStatus(), p2.get().getProductStatus());

    }

    @Test
    public void deleteByProductIdTest()
    {
        Product p1 = new Product("E101", "Iphone", CATEGORIES.MOBILES,   345.54f, "AAcc","https://rukminim1.flixcart.com/image/416/416/k2jbyq80pkrrdj/mobile-refurbished/y/k/z/iphone-11-64-a-mwlx2hn-a-apple-0-original-imafkg24ymsjav9h.jpeg?q=70oductImage" , STATUS.ACTIVE);

        when(repoObj.findById("E101")).thenReturn(Optional.of(p1));
        String msg=srvObj.deleteByProductID(p1);
        assertEquals("Object Deleted Successfully", msg);
    }

    @Test
    public void addProductTest()
    {
        Product p1 = new Product("E101", "Iphone", CATEGORIES.MOBILES,   345.54f, "AAcc","https://rukminim1.flixcart.com/image/416/416/k2jbyq80pkrrdj/mobile-refurbished/y/k/z/iphone-11-64-a-mwlx2hn-a-apple-0-original-imafkg24ymsjav9h.jpeg?q=70oductImage" , STATUS.ACTIVE);

        //repoObj.save(p1);
        when(repoObj.save(p1)).thenReturn(p1);

        Product p2 = srvObj.addProduct(p1);
        assertNotNull(p2, "Object created");
    }


    @Test
    public void updateProductByIdTest()
    {
        Product p1 = new Product("E101", "Iphone", CATEGORIES.MOBILES,   345.54f, "AAcc","https://rukminim1.flixcart.com/image/416/416/k2jbyq80pkrrdj/mobile-refurbished/y/k/z/iphone-11-64-a-mwlx2hn-a-apple-0-original-imafkg24ymsjav9h.jpeg?q=70oductImage" , STATUS.ACTIVE);
    
        p1.setProductName("Redmi");
        p1.setProductPrice(9876.67f);


         Assertions.assertThat(p1.getProductName()).isEqualTo("Redmi");
        Assertions.assertThat(p1.getProductPrice()).isEqualTo(9876.67f);
    }

}
