package com.eshop.services;

import com.eshop.database.Database;
import com.eshop.entities.Product;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    
    
    /*  Search and returns the Product from its id.    */
    public Product findProductByProductId(int productid) {
        ArrayList<Product> allproducts = Database.getAllProducts(); 
        int x = 0;
        for (Product product : allproducts) { 
            if (product.getProductId() == productid) { 
                break;
            } else {
                x++; 
            }
        }
        Product product = allproducts.get(x);
        return product;
    }
    
     /*  Get the weight factor for the Product    */
   public static double getWeightfactorOfTheProduct(Product product) {

        double productWeight = product.getWeight();
        if (productWeight > 10) { // if the weight of the product weights MORE than 10kg,
            return 1.0;          
        } else {                  
            return productWeight / 10;  // get as weightfactor the wight of the product derived from 10.
        }
    }

  
}
