/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eshop.utils;

import com.eshop.entities.Product;
import java.util.ArrayList;

/**
 *
 * @author christy
 */
public class ProductDummyData {
    
    
    public static ArrayList makeDummyProductData(){
    ArrayList <Product> allProducts = new ArrayList<Product>();
    allProducts.add(new Product(1,"Shoes typeA",50, 2.5));
    allProducts.add(new Product(2,"T-shirt",20, 0.2));
    allProducts.add(new Product(4,"Trousers",30, 1.5));
    allProducts.add(new Product(3,"Hat",15, 0.3));
    allProducts.add(new Product(5,"Shoes typeB",70, 2.2));
    
    return allProducts;
   
    }
    
    
}
