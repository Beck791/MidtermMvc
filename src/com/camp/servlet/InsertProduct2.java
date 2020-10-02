package com.camp.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.camp.bean.ProductBean;


@WebServlet("/InsertProduct2")
public class InsertProduct2 extends HttpServlet {
	private static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=Midterm";
	private static final String USER = "sa";
	private static final String PASSWORD = "passw0rd";
	private static final String SQL = "INSERT INTO Product(product,brand,price,productNo,stock,category,brandId)VALUES(?,?,?,?,?,?,?)";

	private static final long serialVersionUID = 1L;
	Connection conn = null;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String product = request.getParameter("product");
		String brand = request.getParameter("brand");
		String price = request.getParameter("price");
		String productNo = request.getParameter("productNo");
		String stock = request.getParameter("stock");
		String category = request.getParameter("category");
		String brandId = request.getParameter("brandId");
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			PreparedStatement stmt = conn.prepareStatement(SQL);
			stmt.setString(1, product);
			stmt.setString(2, brand);
			stmt.setString(3, price);
			stmt.setString(4, productNo);
			stmt.setString(5, stock);
			stmt.setString(6, category);
			stmt.setString(7, brandId);
			stmt.executeUpdate();
			stmt.close();
			
			PreparedStatement stmt1 = conn.prepareStatement("SELECT TOP (1) * FROM Product ORDER BY productId DESC");			
			ResultSet rs = stmt1.executeQuery();
			ProductBean pdb = new ProductBean();
			while (rs.next()) {
				pdb = new ProductBean();
				pdb.setProductId(rs.getInt("productId"));
				pdb.setProduct(rs.getString("product"));
				pdb.setBrand(rs.getString("brand"));
				pdb.setPrice(rs.getDouble("price"));
				pdb.setProductNo(rs.getString("productNo"));
				pdb.setStock(rs.getInt("stock"));
				pdb.setCategory(rs.getString("category"));
				pdb.setBrandId(rs.getInt("brandId"));
			}
//			pdb.setProductId(Integer.parseInt(productId));
//			pdb.setProduct(product);
//			pdb.setBrand(brand);
//			pdb.setPrice(Double.parseDouble(price));
//			pdb.setProductNo(productNo);
//			pdb.setStock(Integer.parseInt(stock));
//			pdb.setCategory(category);
//			pdb.setBrandId(Integer.parseInt(brandId));
//			stmt.setInt(1, pdb.getProductId());
//			stmt.setString(2, pdb.getProduct());
//			stmt.setString(3, pdb.getBrand());
//			stmt.setDouble(4, pdb.getPrice());
//			stmt.setString(5, pdb.getProductNo());
//			stmt.setInt(6, pdb.getStock());
//			stmt.setString(7, pdb.getCategory());
//			stmt.setInt(8, pdb.getBrandId());
//			stmt.executeUpdate();
//			ResultSet rs = stmt.executeUpdate();
//			ProductBean pdb = new ProductBean();
//			if (rs.next()) {
//				pdb.setProductId(rs.getInt("productId"));
//				pdb.setProduct(rs.getString("product"));
//				pdb.setBrand(rs.getString("brand"));
//				pdb.setPrice(rs.getDouble("price"));
//				pdb.setProductNo(rs.getString("productNo"));
//				pdb.setStock(rs.getInt("stock"));
//				pdb.setCategory(rs.getString("category"));
//				pdb.setBrandId(rs.getInt("brandId"));
//			}
			request.setAttribute("pdb", pdb);

			stmt1.close();
			request.getRequestDispatcher("/product/InsertProduct.jsp").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
