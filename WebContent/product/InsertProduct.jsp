<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background-color:#fdf5e6">
<div align="center">
	<h2>新增產品資料</h2>

<%-- 	<a href="<c:url value="/product/Product.jsp"/>">回首頁</a><br> --%>
	<a href="/MidtermMvc/product/Product.jsp">回首頁</a><br><br>
	
	<form method="post" action="/MidtermMvc/InsertProduct">
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
	<hr>
	<h2>產品資料</h2>
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