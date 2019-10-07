package com.eshop.controllers;

import com.eshop.database.Database;
import com.eshop.entities.Basket;
import com.eshop.entities.Product;
import com.eshop.services.BasketService;
import com.eshop.services.ProductService;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductContoller {

    @Autowired
    BasketService basketservice;

    @Autowired
    ProductService productservice;

    /* Get the dummy products. Get Jsessionid. Construct a new basket. The Id of the Basket is the Jsessionid.*/
    @RequestMapping(value = "showallproducts", method = RequestMethod.GET)
    public String getAllProductsFromDatabase(ModelMap mm, HttpServletRequest request, HttpSession session) {
        NumberFormat formatter = new DecimalFormat("#0.00");
        ArrayList<Product> productList = Database.getAllProducts();
        String jSessionId = request.getSession().getId();
        Basket basket = new Basket(jSessionId, new ArrayList<Product>());
        session.setAttribute("totalShippingCost", formatter.format(0.0));
        mm.addAttribute("productList", productList);
        session.setAttribute("basket", basket);
        return "products";
    }

    /* 
      Get the basket of the User that use this jsessionid. Get the product that is clicked to be added to the basket.Add product to the basket
      Calculate the cost with discount, without discount, and the Shipping Cost
     */
    @RequestMapping(value = "dotakeproduct/{productid}", method = RequestMethod.GET)
    public String addPruductToBasket(ModelMap mm, @PathVariable int productid, HttpSession session) {
        NumberFormat formatter = new DecimalFormat("#0.00");
        Basket basket = (Basket) session.getAttribute("basket");
        Product product = productservice.findProductByProductId(productid);
        basketservice.addProductToBasket(product, basket);
        basket = basketservice.calculateAllTheCosts(basket); 
        session.setAttribute("totalShippingCost", formatter.format(BasketService.calculateShippingCostofTheBasket(basket)));
        return "redirect:../products";
    }
    
    /* 
      Get the basket of the User that use this jsessionid. Get the product that is clicked to be added to the basket.Delete product from the basket.
      Calculate the cost with discount, without discount, and the Shipping Cost
     */
    @RequestMapping(value = "deleteproduct/{productid}", method = RequestMethod.GET)
    public String deleteProductFromBasket(ModelMap mm, @PathVariable int productid, HttpSession session) {
        NumberFormat formatter = new DecimalFormat("#0.00"); 
        Basket basket = (Basket) session.getAttribute("basket"); 
        Product product = productservice.findProductByProductId(productid);
        basketservice.deleteProductFromBasket(product, basket);
        basket = basketservice.calculateAllTheCosts(basket); 
        session.setAttribute("totalShippingCost", formatter.format(BasketService.calculateShippingCostofTheBasket(basket)));
        return "redirect:../products";
    }

    @RequestMapping(value = "products", method = RequestMethod.GET)
    public String getTheRedirectdPage(ModelMap mm, HttpServletRequest request, HttpSession session) {
        ArrayList<Product> productList = Database.getAllProducts();
        mm.addAttribute("productList", productList);
        return "products";

    }

    @RequestMapping(value = "exiteshopapplication", method = RequestMethod.GET)
    public String exitFromTheApplication(ModelMap mm, HttpServletRequest request, HttpSession session) {

        return "index";

    }
}
