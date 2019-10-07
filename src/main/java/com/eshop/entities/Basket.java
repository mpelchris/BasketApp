package com.eshop.entities;

import java.util.ArrayList;

public class Basket {

    
    private String basketId;
    private double totalCostWithDiscountAndShippingCost;
    private double costWithoutDiscount;
    private double costWithDiscount;
    private double shippingCost;
    private double totalWeight;
    public ArrayList <Product> products;

     public Basket() {
    }

    public Basket(String basketId, ArrayList<Product> products) {
        this.basketId = basketId;
        this.products = products;
    }
    
    

    public String getBasketId() {
        return basketId;
    }

    public void setBasketId(String basketId) {
        this.basketId = basketId;
        
        
    }

    public double getTotalCostWithDiscountAndShippingCost() {
         this.totalCostWithDiscountAndShippingCost=  this.costWithDiscount+this.shippingCost;
        return totalCostWithDiscountAndShippingCost;
    }

    public void setTotalCostWithDiscountAndShippingCost(double totalCostWithDiscountAndShippingCost) {
     this.totalCostWithDiscountAndShippingCost = totalCostWithDiscountAndShippingCost;
    }

    public double getCostWithoutDiscount() {
        return costWithoutDiscount;
    }

    public void setCostWithoutDiscount(double costWithoutDiscount) {
        this.costWithoutDiscount = costWithoutDiscount;
    }

    public double getCostWithDiscount() {
        return costWithDiscount;
    }

    public void setCostWithDiscount(double costWithDiscount) {
        this.costWithDiscount = costWithDiscount;
    }
   

    public double getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
    }

  
   
     
}