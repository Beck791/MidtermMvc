<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<meta charset="UTF-8">
<title>產品資料</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
</head>
<body style="background-color:#fdf5e6" >
<div align="center">
<h2 class="bg-dark text-white">產品資料</h2>
<!-- 	<a href="/MidtermMvc/product/Product.jsp">回首頁</a><br> -->
	<a href="<c:url value="/product/Product.jsp"/>">回首頁</a><br>
<!-- 	<input type ="button" onclick="history.back()" value="回上一頁"></input> -->
	<form method="post" action="/MidtermMvc/GetProduct">
		輸入產品編號 : <input type="text" id="idName" name="productId" maxlength="4" autofocus placeholder="請輸入四位數字" required="required" onblur="checkName()"/><br><br>
		<input type="submit"  value="確定" class="btn btn-primary" />	<br>
		 <span class="sp" id="idspName" style="color:red"></span><br>
<!-- 		<span>(1.不可空白，2.輸入四個數字，3.必須全部為數字)</span><br> -->
		<font color='red' size="-1">${errorMsg.productId}</font><br>
	</form>
	

<hr>

<jsp:useBean id="pdb" scope="request" class="com.camp.bean.ProductBean"/>
<table class="btn btn-dark">
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
<script>

function checkName() {
    let NameObjVal = document.getElementById("idName").value;
    let spName = document.getElementById("idspName");
    let NameObjValLen = NameObjVal.length;
    if (NameObjVal == "") {
        spName.innerHTML = "內容不可以為空白";
    }
    else if (NameObjValLen >= 4) {
             spName.innerHTML = "<span style=\"font-size:1em\">格式正確</span>";
//              spName.innerHTML += "<img src=\"images/correct.jpg\" width = 20px height =20px>";           
        
    } else {
        spName.innerHTML = "請至少輸入四個數字";
//         spName.innerHTML += "<img src=\"images/error.jpg\" width = 20px height =20px>";
    }
}
    </script>



</body>
</html>