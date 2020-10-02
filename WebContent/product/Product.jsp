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
<h1>露營商品管理</h1>
<!-- 	<input type="button" value="查詢單筆資料" onclick="location.href='GetProduct.jsp'"><br> -->
<!-- 	<button onclick=""><a href="GetProduct.jsp">查詢單筆資料</a></button><br> -->
<!-- 	<button onclick="location.href='InsertProduct.jsp'">新增資料</button><br><br> -->
	<a href="/MidtermMvc/product/GetProduct.jsp">查詢單筆資料</a><br><br>
<!-- 	<button onclick="location.href='/MidtermMvc/GetAllProduct'">查詢全部資料</button><br><br> -->
<!-- 	<form method="post" action="/MidtermMvc/GetAllProduct"> -->
<!-- 	<input type="submit" value="查詢全部資料"></input> -->
<!--     </form> -->
    <a href="/MidtermMvc/GetAllProduct">查詢全部資料</a><br><br>
	<a href="/MidtermMvc/product/InsertProduct.jsp">新增資料</a><br><br>
</div>
</body>
</html>