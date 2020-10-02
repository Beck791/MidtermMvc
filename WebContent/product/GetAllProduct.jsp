<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.camp.bean.ProductBean" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%! @SuppressWarnings("unchecked") %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>產品資料</title>
</head>
<body style="background-color:#fdf5e6">
<div align="center">
<h2>產品資料</h2>
<a href="<c:url value="/product/Product.jsp"/>">回首頁</a>
	
	<form method="get" action="/MidtermMvc/DeleteProduct">
       輸入刪除的產品編號 : <input type="text" name="productId" />
	<input type="submit"  value="確定" />	
	</form>
		
<table border="1">
<tr style="background-color:#a8fefa">
<th>ProductId<th>Product<th>Brand<th>Price<th>ProductNo<th>Stock<th>Category<th>BrandId
<c:forEach var="product" items="${pdbs}">
<tr><td>${product.productId}</td>
<td>${product.product}</td>
<td>${product.brand}</td>
<td>${product.price}</td>
<td>${product.productNo}</td>
<td>${product.stock}</td>
<td>${product.category}</td>
<td>${product.brandId}</td></tr>
</c:forEach>
</table>
<h3>共${pdbs.size()}筆員工資料</h3>
</div>
</body>
</html>