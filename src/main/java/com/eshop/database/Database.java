/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eshop.database;

import com.eshop.entities.Basket;
import com.eshop.entities.Product;
import com.eshop.services.BasketService;
import com.eshop.utils.ProductDummyData;
import java.util.ArrayList;

/**
 *
 * @author christy
 */
public class Database {

    public static ArrayList<Product> AllProducts = new ArrayList<Product>();
    public static ArrayList<Basket> AllBaskets = new ArrayList<Basket>();

    public static ArrayList getAllProducts() {
        ArrayList<Product> allproducts = ProductDummyData.makeDummyProductData();
        return allproducts;
    }

   

    public static ArrayList<Basket> getAllBaskets() {
        return AllBaskets;
    }

    
    
    
}
