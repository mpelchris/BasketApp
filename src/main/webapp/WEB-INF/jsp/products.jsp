<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springForm"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="w3-container">
                      <div  class="w3-panel  w3-padding-small  w3-blue w3-center">
                            <h1>List of the Products</h1> 
                            <a href="exiteshopapplication" class="w3-button w3-right fa fa-home"> Exit from E-shop </a>  
                     </div>
           
            <div class="w3-responsive">
                <table class="w3-table-all">
                    <thead>
                        <tr class="w3-light-grey">
                            <th> </th>
                            <th>Price</th>
                            <th> Weight</th>
                            <th> </th>


                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var = "product" items="${productList}">
                            <tr class="w3-hover-blue">
                                <td>
                                    <c:out value="${product.name}"/>
                                </td>
                                <td>
                                    <c:out value="${product.price}"/> &euro;
                                </td>
                                <td>
                                    <c:out value="${product.weight}"/> kg
                                </td>
                                <td>

                                    <a href = "${pageContext.request.contextPath}/dotakeproduct/${product.productId}" class="btn btn-primary" id="myBtn2">Take it!</a>
                                </td>   
                                <td>

                                </td>

                            </tr>
                        </c:forEach>

                    </tbody><br>
                </table><br>
            </div>
        </div>

                   <div  class="w3-panel  w3-padding-small  w3-grey w3-center">
                            <h1> Your Basket</h1> 
                  </div>
       
      
            
            
            <div class="w3-responsive">
                <table class="w3-table-all">
                    <thead>
                        <tr class="w3-light-grey">
                            <th> </th>
                            <th> </th>
                            <th> <c:if test="${sessionScope.basket.costWithoutDiscount  > 100}">
                                    
                                    <h4> 10% discount </h4>

                                </c:if></h2></th>
                            <th><h6> Cost: <c:out value='${sessionScope.basket.costWithDiscount}'/> &euro;</h6> 
                                <h6>Shipping Cost: <c:out value='${sessionScope.totalShippingCost}'/>&euro;</h6> </th>
                            <th><h4><center> Totalcost:(<c:out value='${sessionScope.basket.costWithDiscount}'/>&euro;+ <c:out value='${sessionScope.totalShippingCost}'/> &euro;)=  <c:out value='${sessionScope.basket.totalCostWithDiscountAndShippingCost}'/>&euro;  </center></h4> 
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var = "product" items="${sessionScope.basket.products}">
                            <tr class="w3-hover-blue">
                                <td>
                                    <c:out value="${product.name}"/>
                                </td>
                                <td>
                                    <c:out value="${product.price}"/> &euro;
                                </td>
                                <td>
                                    <c:out value="${product.weight}"/> kg
                                </td>
                                <td>
                                    <a href="${pageContext.request.contextPath}/deleteproduct/${product.productId}" class="btn btn-primary" id="myBtn2">Remove From Basket</a>
                                </td>   
                                <td>

                                </td>

                            </tr>
                        </c:forEach>

                    </tbody><br>
                </table><br>
            </div>
        </div>



</body>
</html>
