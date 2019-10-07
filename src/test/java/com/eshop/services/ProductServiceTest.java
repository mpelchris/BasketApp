package com.eshop.services;

import com.eshop.database.Database;
import com.eshop.entities.Product;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author christy
 */
public class ProductServiceTest {

    public ProductServiceTest() {
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
     * Test of getWeightfactorOfTheProduct method, of class ProductService.
     */
    @Test
    public void testGetWeightfactorOfTheProduct() {

        Product product = new Product(1, "Shoes typeA", 50, 2.5);

        double expResult = 0.25;
        double result = ProductService.getWeightfactorOfTheProduct(product);
        assertEquals(expResult, result, 0.0);

    }

}
