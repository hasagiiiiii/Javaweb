<%@page import="java.util.List"%>
<%@page import="VanTrung.vn.beans.Product"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product</title>
</head>
<body>
<% List<Product> listProduct = (List<Product>) request.getAttribute("productList");

	
%>

	<p>Trung dnajsidajsdj</p>

<section class = "container">
        <h3>Product List</h3>
        <a href="productCreate" class="btn btn-success">Create Product</a>
        <p> ${errorString}</p>
        <table class="table table-bordered">
        <thead>
            <tr>
                <th>Code</th>
                <th>Name</th>
                <th>Price</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
        </thead>
        <tbody>
            <% for (Product product : listProduct) { %>
            <tr>
                <td><%= product.getCode() %></td>
                <td><%= product.getName() %></td>
                <td><%= product.getPrice() %></td>
                <td><a href ="productEdit?code=<%= product.getCode() %>">Edit</a></td>
                <td><a href ="productDelete?code=<%= product.getCode() %>">Delete</a></td>
            </tr>
            <% } %>
        </tbody>
        </table>

    </section>


</body>
</html>