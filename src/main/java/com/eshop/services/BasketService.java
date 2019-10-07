package com.eshop.services;

import com.eshop.database.Database;
import com.eshop.entities.Basket;
import com.eshop.entities.Product;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.servlet.http.Cookie;
import org.springframework.stereotype.Service;

@Service
public class BasketService {

    /*  Add Basket to Database.   */
    public void addBasketToDatabase(Basket basket) {
        Database.getAllBaskets().add(basket);

    }

    /*  Add Product to the Basket.   */
    public static Basket addProductToBasket(Product product, Basket basket) {
        ArrayList<Product> productList = basket.getProducts();
        productList.add(product);
        basket.setProducts(productList);

        return basket;
    }

    /*   Calculate the total cost of the basket products(without discount and shipping cost)   */
    public static double calculateCostOfTheBasketWithoutDiscountAndShippingCost(Basket basket) {
        double totalcost = 0, sum = 0;
        ArrayList<Product> productList = basket.getProducts();
        for (Product product : productList) {
            sum += product.getPrice();
        }
        totalcost += sum;

        return totalcost;
    }

    /*  Calculate shipping cost for all basket products.  */
    public static double calculateShippingCostofTheBasket(Basket basket) {
        double productShippingCost, basketShippingCost = 0;
        ArrayList<Product> productlist = basket.getProducts();
        if (basket == null) {
            return 0;
        } else {
            for (Product product : productlist) {
                productShippingCost = 5 * ProductService.getWeightfactorOfTheProduct(product); //fixed €5 per item , multiplied by the weight factor of all the products
                basketShippingCost += productShippingCost;
            }
            return basketShippingCost;
        }
    }

    /*  Get the basket of the user from Database by basketid.  */
    public static Basket getTheBasketofTheUser(String basketid) {
        ArrayList<Basket> basketlist = Database.getAllBaskets();
        int x = 0;
        for (Basket basket : basketlist) {
            if (basket.getBasketId().equals(basketid)) {
                break;
            } else {
                x++;
            }
        }
        Basket basket = basketlist.get(x);

        return basket;
    }

    /* Apply Discount when the cost exceed a certain amount of money. */
    public static double applyDiscountWhenCostExceedsAnAmountOfMoney(Basket basket, double cernainAmountOfMoney, double discountRate) {
        double discountedCost = 0;
        double cost = basket.getCostWithoutDiscount();
        if (cost > cernainAmountOfMoney) {
            discountedCost = discountRate * cost / 100;
        }
        cost -= discountedCost;

        return cost;
    }

    /* Calculate the cost with discount, without discount, and the Shipping Cost. */
    public Basket calculateAllTheCosts(Basket basket) {
        double costWithoutDiscount = BasketService.calculateCostOfTheBasketWithoutDiscountAndShippingCost(basket);
        basket.setCostWithoutDiscount(costWithoutDiscount);
        double costWithDicount = BasketService.applyDiscountWhenCostExceedsAnAmountOfMoney(basket, 100, 10);// ApplyDiscount: When total exceeds €100 then apply 10% discount.
        basket.setCostWithDiscount(costWithDicount);
        double shippingCost = BasketService.calculateShippingCostofTheBasket(basket);
        basket.setShippingCost(shippingCost);

        return basket;
    }

    /* Delete Product from the productList of the Basket.  */
    public Basket deleteProductFromBasket(Product productTodelete, Basket basket) {
        int x = 0;
        int productToDeleteId = productTodelete.getProductId();
        ArrayList<Product> productList = basket.getProducts();
        for (Product product : productList) {

            if (product.getProductId() == productToDeleteId) {
                break;
            } else {
                x++;
            }
        }
        productList.remove(x);

        return basket;
    }

}
