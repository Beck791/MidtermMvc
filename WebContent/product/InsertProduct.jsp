<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background-color:#fdf5e6">
<div align="center">
	<h2 class="bg-dark text-white">輸入新增資料</h2>

<%-- 	<a href="<c:url value="/product/Product.jsp"/>">回首頁</a><br> --%>
	<a href="/MidtermMvc/product/Product.jsp">回首頁</a><br><br>
	
	<form method="post" action="/MidtermMvc/InsertProduct">
	<table class="btn btn-secondary">
		<tr><td>輸入產品 :<td><input type="text" name="product" />
		<tr><td>輸入品牌 :<td><input type="text" name="brand" />
		<tr><td>輸入價格 :<td><input type="text" name="price" />
		<tr><td>輸入廠商產品編號 :<td><input type="text" name="productNo" />
		<tr><td>輸入數量 :<td><input type="text" name="stock" />
		<tr><td>輸入種類 :<td><input type="text" name="category" />
		<tr><td>輸入廠商代碼 :<td><input type="text" name="brandId" />
	</table>
	<br><br>
			<input type="submit" value="新增" class="btn btn-primary" />
			<input type="reset" value="取消" class="btn btn-primary" />
	</form>
	<hr>
	<h2 class="bg-dark text-white">新增產品資料</h2>
	<jsp:useBean id="pdb" scope="request" class="com.camp.bean.ProductBean"/>
	<table class="btn btn-secondary">
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