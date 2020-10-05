<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.camp.bean.ProductBean" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%! @SuppressWarnings("unchecked") %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<meta charset="UTF-8">
<title>產品資料</title>
</head>
<body style="background-color:#fdf5e6">
<div align="center">
<h2 class="bg-dark text-white">更新資料</h2>
<a href="<c:url value="/product/Product.jsp"/>">回首頁</a><br><br>
<!--  <a href="/MidtermMvc/GetAllProduct">繼續修改其它資料</a><br><br> -->
<!-- <a href="/MidtermMvc/GetAllProduct">查詢全部資料</a><br><br> -->
<!-- <form method="post" action="/MidtermMvc/UpdateProduct">		 -->
<%-- <%String s =(String)request.getAttribute("num");%> --%>
<%-- ${num}，${sessionScope.userphone} --%>
<form method="post" action="/MidtermMvc/UpdateProduct">
<%-- <c:forEach items="${pdb}" var="product">  --%>
<table><th class="bg-dark text-white">欲更新商品資料<th class="bg-dark text-white">更新後商品資料<tr><td>
<table align="left" class="table table-dark table-striped">
<%-- 	<tr><td>輸入產品編號 :<td><input type="text" name="productId" readonly="readonly" value="${product.productId}" /> --%>
	<jsp:useBean id="pdbs" scope="request" class="com.camp.bean.ProductBean"/>
	<tr><td>輸入產品編號 :<td><input type="text" name="productId" readonly="readonly" value="${pdbs.productId}" />
	<tr><td>輸入產品 :<td><input type="text" name="product" value="${pdbs.product}" />
	<tr><td>輸入品牌 :<td><input type="text" name="brand" value="${pdbs.brand}" />
	<tr><td>輸入價格 :<td><input type="text" name="price" value="${pdbs.price}" />
	<tr><td>輸入廠商產品編號 :<td><input type="text" name="productNo" value="${pdbs.productNo}" />
	<tr><td>輸入數量 :<td><input type="text" name="stock" value="${pdbs.stock}" />
	<tr><td>輸入種類 :<td><input type="text" name="category" value="${pdbs.category}" />
	<tr><td>輸入廠商代碼 :<td><input type="text" name="brandId" value="${pdbs.brandId}"/>
</table>
<%-- </c:forEach> --%>

	<td>		
	<jsp:useBean id="pdb" scope="request" class="com.camp.bean.ProductBean"/>
	<table align="left" class="table table-dark table-striped">
	<tr><td>產品編號<td><input type="text" disabled value="${pdb.productId}">
	<tr><td>產品<td><input type="text" disabled value="${pdb.product}">
	<tr><td>品牌<td><input type="text" disabled value="${pdb.brand}">
	<tr><td>價格<td><input type="text" disabled value="${pdb.price}">
	<tr><td>廠商產品編號<td><input type="text" disabled value="${pdb.productNo}">
	<tr><td>數量<td><input type="text" disabled value="${pdb.stock}">
	<tr><td>種類<td><input type="text" disabled value="${pdb.category}">
	<tr><td>廠商代碼<td><input type="text" disabled value="${pdb.brandId}">
	</table>
<!-- </form> -->
</table>
<%-- <h3>共${pdbs.size()}筆員工資料</h3> --%>
			<input type="submit" value="新增" class="btn btn-primary" />
			<input type="reset" value="取消" class="btn btn-primary" />
</form><br>
<button onclick="location.href='/MidtermMvc/GetAllProduct'" class="btn btn-primary">繼續更改其它資料</button><br>
</div>
</body>
</html>