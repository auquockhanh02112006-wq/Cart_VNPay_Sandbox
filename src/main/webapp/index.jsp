<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="murach.data.ProductDB, murach.business.Product, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>
<h1>CD list</h1>

<%
    List<Product> products = ProductDB.getProducts();
    request.setAttribute("products", products);
%>

<table>
    <tr>
        <th>Description</th>
        <th class="price">Price</th>
        <th></th>
    </tr>
    <c:forEach var="product" items="${products}">
    <tr>
        <td>${product.description}</td>
        <td class="price">${product.priceFormatted}</td>
        <td>
            <form action="cart" method="post">
                <input type="hidden" name="action" value="add">
                <input type="hidden" name="productCode" value="${product.code}">
                <input type="submit" value="Add To Cart">
            </form>
        </td>
    </tr>
    </c:forEach>
</table>

</body>
</html>