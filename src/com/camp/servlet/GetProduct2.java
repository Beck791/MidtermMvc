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
import com.camp.dao.ProductDaoImp;

@WebServlet("/GetProduct2")
public class GetProduct2 extends HttpServlet {
	private static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=Midterm";
	private static final String USER = "sa";
	private static final String PASSWORD = "passw0rd";
	private static final String SQL = "SELECT * FROM product WHERE productId =? ";

	private static final long serialVersionUID = 1L;
	Connection conn = null;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productId = request.getParameter("productId");
		try {
//		ProductDaoImp dao = new ProductDaoImp();
//		dao.createConn();
//		dao.queryOne(Integer.parseInt(productId));
		Class.forName(JDBC_DRIVER);
		conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
		PreparedStatement stmt = conn.prepareStatement(SQL);
		stmt.setInt(1, Integer.valueOf(productId));
		ResultSet rs = stmt.executeQuery();
		ProductBean pdb = new ProductBean();
		if (rs.next()) {
			pdb.setProductId(rs.getInt("productId"));
			pdb.setProduct(rs.getString("product"));
			pdb.setBrand(rs.getString("brand"));
			pdb.setPrice(rs.getDouble("price"));
			pdb.setProductNo(rs.getString("productNo"));
			pdb.setStock(rs.getInt("stock"));
			pdb.setCategory(rs.getString("category"));
			pdb.setBrandId(rs.getInt("brandId"));
		}
		request.setAttribute("pdb", pdb);
		stmt.close();
		request.getRequestDispatcher("/product/GetProduct.jsp").forward(request, response);
//		dao.closeConn();
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
