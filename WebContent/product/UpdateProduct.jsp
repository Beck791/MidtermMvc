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
	

<form method="get" action="/MidtermMvc/UpdateProduct">
			
<table border="1">
<tr style="background-color:#a8fefa">
<th>ProductId<th>Product<th>Brand<th>Price<th>ProductNo<th>Stock<th>Category<th>BrandId
<c:forEach var="product" items="${pdbs}">
<tr><td>產品編號<td><input type="text" disabled value="${pdb.productId}">
<tr><td>產品<td><input type="text" name="product" value="${pdb.product}">
<tr><td>品牌<td><input type="text" name="brand" value="${pdb.brand}">
<tr><td>價格<td><input type="text" name="price" value="${pdb.price}">
<tr><td>廠商產品編號<td><input type="text" name="productNo" value="${pdb.productNo}">
<tr><td>數量<td><input type="text" name="stock" value="${pdb.stock}">
<tr><td>種類<td><input type="text" name="category" value="${pdb.category}">
<tr><td>廠商代碼<td><input type="text" name="brandId" value="${pdb.brandId}">
</c:forEach>
</table>
<input type="submit"  value="確定修改" />	
</form>
<h3>共${pdbs.size()}筆員工資料</h3>
</div>
</body>
</html>