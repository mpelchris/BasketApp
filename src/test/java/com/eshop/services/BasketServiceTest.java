package com.eshop.services;

import com.eshop.entities.Basket;
import com.eshop.entities.Product;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class BasketServiceTest {

    public BasketServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

  
    /**
     * Test of calculateCostOfTheBasketWithoutDiscountAndShippingCost method, of
     * class BasketService.
     */
    @Test
    public void testCalculateCostOfTheBasketWithoutDiscountAndShippingCost() {

        ArrayList<Product> productList = new ArrayList<>();
        Basket basket = new Basket("xikari", productList);
        productList.add(new Product(1, "Shoes typeA", 50, 2.5));
        productList.add(new Product(2, "Shoes typeA", 70, 3.0));
        productList.add(new Product(3, "Shoes typeA", 20, 2.0));
        double expResult = 140;
        double result = BasketService.calculateCostOfTheBasketWithoutDiscountAndShippingCost(basket);
        Assert.assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of calculateShippingCostofTheBasket method, of class BasketService.
     */
    @Test
    public void testCalculateShippingCostofTheBasket() {
        ArrayList<Product> productList = new ArrayList<>();
        Basket basket = new Basket("xikari", productList);
        productList.add(new Product(1, "Shoes typeA", 50, 2.5));
        productList.add(new Product(2, "Shoes typeA", 70, 3.0));
        double expResult = 2.75;
        double result = BasketService.calculateShippingCostofTheBasket(basket);
        assertEquals(expResult, result, 0.0);

    }

   
}
