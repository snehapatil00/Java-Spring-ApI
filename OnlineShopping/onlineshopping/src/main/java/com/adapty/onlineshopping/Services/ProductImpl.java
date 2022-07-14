package com.adapty.onlineshopping.Services;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.adapty.onlineshopping.Entities.Product;
import com.adapty.onlineshopping.Entities.STATUS;
import com.adapty.onlineshopping.Repository.ProductRepository;


@Service
public class ProductImpl implements ProductInterface 
{
    @Autowired
    private ProductRepository repoObj;                //product Repository Object
    
    public List<Product>fetchAllProducts()
    {
        
        return repoObj.findAll();
    }

    public Optional<Product> fetchProductById(Product obj)
    {
        if(obj.getProductStatus()==STATUS.ACTIVE)
        {
             return repoObj.findById(obj.getProductId());
        }
        else
        {
            return null;
        }
    }


    public Product addProduct(Product productobj)
    {
        repoObj.save(productobj);
        return productobj;

    }


    public Product updateProductById(Product obj)
    {
        if (obj.getProductId()==null)
        {
            return null;
        }
        else
        {
            Optional<Product> p1=repoObj.findById(obj.getProductId());
            p1.get().setProductCategory(obj.getProductCategory());
            p1.get().setProductDescription(obj.getProductDescription());
            p1.get().setProductImage(obj.getProductImage());
            p1.get().setProductName(obj.getProductName());
            p1.get().setProductPrice(obj.getProductPrice());
            p1.get().setProductStatus(obj.getProductStatus());
            repoObj.deleteById(obj.getProductId());
            repoObj.save(p1.get());
            return obj;
        }
    }

        

        // public Optional<List<Product>>findProductByProductCategory(CATEGORIES category)
        // {
        //     return  repoObj.findProductByProductCategory(category);
        //  }



        public String deleteByProductID(Product productObj)
        {
           
            if(productObj.getProductId() == null) 
            {
                return "Enter a Valid Id";
            }
            else
            {
                Optional<Product> d1 = repoObj.findById(productObj.getProductId());
                if(d1.get().getProductStatus() == STATUS.ACTIVE)
                {
                    d1.get().setProductStatus(STATUS.INACTIVE);
                    repoObj.save(d1.get());
                    return "Object Deleted Successfully";
                 
                }
                else
                {
                    return "Object does not exists";
                }
            
            }
       }

}


    

