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
<!-- <a href="/MidtermMvc/GetAllProduct">查詢全部資料</a><br><br> -->
<!-- <form method="post" action="/MidtermMvc/UpdateProduct">		 -->

<form method="post" action="/MidtermMvc/UpdateProduct">
<table>
	<tr><td>輸入產品 :<td><input type="text" name="product" />
	<tr><td>輸入品牌 :<td><input type="text" name="brand" />
	<tr><td>輸入價格 :<td><input type="text" name="price" />
	<tr><td>輸入廠商產品編號 :<td><input type="text" name="productNo" />
	<tr><td>輸入數量 :<td><input type="text" name="stock" />
	<tr><td>輸入種類 :<td><input type="text" name="category" />
	<tr><td>輸入廠商代碼 :<td><input type="text" name="brandId" />
</table>
			<input type="submit" value="新增" />
			<input type="reset" value="取消" />
</form>





<table border="1">
<tr style="background-color:#a8fefa">
<th><th>ProductId<th>Product<th>Brand<th>Price<th>ProductNo<th>Stock<th>Category<th>BrandId
<c:forEach var="product" items="${pdbs}">
<tr><td><input type="submit"  value="修改" />	
<td>${product.productId}</td>
<td>${product.product}</td>
<td>${product.brand}</td>
<td>${product.price}</td>
<td>${product.productNo}</td>
<td>${product.stock}</td>
<td>${product.category}</td>
<td>${product.brandId}</td></tr>
</c:forEach>
</table>
<!-- </form> -->
<h3>共${pdbs.size()}筆員工資料</h3>
</div>
</body>
</html>