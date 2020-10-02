<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>產品資料</title>
</head>
<body style="background-color:#fdf5e6">
<div align="center">
<h2>產品資料</h2>
<!-- 	<a href="/MidtermMvc/product/Product.jsp">回首頁</a><br> -->
	<a href="<c:url value="/product/Product.jsp"/>">回首頁</a><br>
<!-- 	<input type ="button" onclick="history.back()" value="回上一頁"></input> -->
	<form method="post" action="/MidtermMvc/GetProduct">
		輸入產品編號 : <input type="text" name="productId" /><p>
		<input type="submit"  value="確定" />	
	</form>
	

<hr>

<jsp:useBean id="pdb" scope="request" class="com.camp.bean.ProductBean"/>
<table>
<tr><td>產品編號<td><input type="text" disabled value="${pdb.productId}">
<tr><td>產品<td><input type="text" disabled value="${pdb.product}">
<tr><td>品牌<td><input type="text" disabled value="${pdb.brand}">
<tr><td>價格<td><input type="text" disabled value="${pdb.price}">
<tr><td>廠商產品編號<td><input type="text" disabled value="${pdb.productNo}">
<tr><td>數量<td><input type="text" disabled value="${pdb.stock}">
<tr><td>種類<td><input type="text" disabled value="${pdb.category}">
<tr><td>廠商代碼<td><input type="text" disabled value="${pdb.brandId}">

</table>

</div>
</body>
</html>