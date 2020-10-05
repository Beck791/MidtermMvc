<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+TC:wght@700&display=swap" rel="stylesheet">
<meta charset="UTF-8">
<style>
* {
    font-family: 'Noto Sans TC', sans-serif;
}
</style>
<title>Insert title here</title>
</head>
<body style="background-color:#fdf5e6">
<div align="center">
<h1 class="bg-dark text-white">露營商品管理</h1>
<!-- 	<input type="button" value="查詢單筆資料" onclick="location.href='GetProduct.jsp'"><br> -->
<!-- 	<button onclick=""><a href="GetProduct.jsp">查詢單筆資料</a></button><br> -->
<!-- 	<button onclick="location.href='InsertProduct.jsp'">新增資料</button><br><br> -->
	<a href="/MidtermMvc/product/GetProduct.jsp" class="btn btn-primary">查詢單筆資料 </a><br><br>
<!-- 	<button onclick="location.href='/MidtermMvc/GetAllProduct'">查詢全部資料</button><br><br> -->
<!-- 	<form method="post" action="/MidtermMvc/GetAllProduct"> -->
<!-- 	<input type="submit" value="查詢全部資料"></input> -->
<!--     </form> -->
    <a href="/MidtermMvc/GetAllProduct" class="btn btn-primary">查詢全部資料</a><br><br>
	<a href="/MidtermMvc/product/InsertProduct.jsp" class="btn btn-primary">新增資料</a><br><br>
<!-- 	<a href="/MidtermMvc/product/UpdateProduct.jsp">更新資料</a><br><br> -->
</div>
</body>
</html>