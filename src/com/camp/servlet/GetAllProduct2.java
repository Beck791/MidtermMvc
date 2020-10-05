package com.camp.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.camp.bean.ProductBean;
import com.camp.dao.ProductDaoImp;
import com.camp.service.ProductService;
import com.camp.service.ProductService;

@WebServlet("/GetAllProduct2")
public class GetAllProduct2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=Midterm";
	private static final String USER = "sa";
	private static final String PASSWORD = "passw0rd";
	private static final String SQL = "SELECT * FROM Product";
	Connection conn = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			PreparedStatement stmt = conn.prepareStatement(SQL);
			ResultSet rs = stmt.executeQuery();
			List<ProductBean> pdbs = new ArrayList<>();
			ProductBean pdb = null;
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
				pdbs.add(pdb);
			}
//			List<ProductBean> pdbs = (ArrayList<ProductBean>)request.getAttribute("pdbs");
//			for(ProductBean pdb : pdbs) ;
			stmt.close();
			request.setAttribute("pdbs", pdbs);
			request.getRequestDispatcher("/MidtermMvc/product/GetAllProduct.jsp").forward(request, response);
			 
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
