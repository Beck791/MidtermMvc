package com.camp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.camp.bean.ProductBean;

public class ProductDaoImp implements ProductDao {

	private static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=Midterm";
	private static final String USER = "sa";
	private static final String PASSWORD = "passw0rd";
//	private static final String SQL = "SELECT * FROM employee WHERE empno =? ";
	private Connection conn = null;

	@Override
	public void insert(ProductBean pdb) {
		try {
			createConn();
			String sqlStr = "INSERT INTO Product(product,brand,price,productNo,stock,category,brandId)VALUES(?,?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sqlStr);
			pstmt.setString(1, pdb.getProduct());
			pstmt.setString(2, pdb.getBrand());
			pstmt.setDouble(3, pdb.getPrice());
			pstmt.setString(4, pdb.getProductNo());
			pstmt.setInt(5, pdb.getStock());
			pstmt.setString(6, pdb.getCategory());
			pstmt.setInt(7, pdb.getBrandId());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(ProductBean pdb) {
		try {
			createConn();
			String sqlStr = "UPDATE product SET product=?,brand=?,price=?,productNo=?,stock=?,category=?,brandId=? WHERE productId =?";
			PreparedStatement pstmt = conn.prepareStatement(sqlStr);
			pstmt.setString(1, pdb.getProduct());
			pstmt.setString(2, pdb.getBrand());
			pstmt.setDouble(3, pdb.getPrice());
			pstmt.setString(4, pdb.getProductNo());
			pstmt.setInt(5, pdb.getStock());
			pstmt.setString(6, pdb.getCategory());
			pstmt.setInt(7, pdb.getBrandId());
			pstmt.executeUpdate();
			pstmt.close();
//			System.out.println("Update count = " + num);
			closeConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteAll() {
		try {
			String sqlStr = "DELETE FROM Midterm ";
			PreparedStatement pstmt = conn.prepareStatement(sqlStr);
			int num = pstmt.executeUpdate();
			pstmt.close();
			System.out.println("Delete count = " + num);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteOne(int productId) {

		try {
			createConn();
			String sqlStr = "DELETE FROM product WHERE productId = ? ";
			PreparedStatement pstmt = conn.prepareStatement(sqlStr);
			pstmt.setInt(1, productId);
			pstmt.executeUpdate();
			pstmt.close();
//			System.out.println("Delete count = " + num);
			closeConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<ProductBean> queryAll() throws SQLException {
		List<ProductBean> pdbs = null;
//		pdbs = new ArrayList<>();
		try {
			String sqlStr = "SELECT * FROM Product";
			PreparedStatement pstmt = conn.prepareStatement(sqlStr);
			ResultSet rs = pstmt.executeQuery();
			pdbs = new ArrayList<>();
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
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pdbs;
	}

	@Override
	public ProductBean queryOne(int productId) {
		ProductBean pdb = new ProductBean();
		try {
			String sqlStr = "SELECT * FROM product WHERE productId =? ";
			PreparedStatement stmt = conn.prepareStatement(sqlStr);
			stmt.setInt(1, productId);
			ResultSet rs = stmt.executeQuery();
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pdb;
	}

	@Override
	public ProductBean querylast() throws SQLException {
		createConn();
		ProductBean pdb = null;
		PreparedStatement stmt1 = conn.prepareStatement("SELECT TOP (1) * FROM Product ORDER BY productId DESC");
		ResultSet rs = stmt1.executeQuery();
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
		createConn();
		return pdb;
	}

	@Override
	public void createConn() {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
//			System.out.println("SQL Sever Connection open status: " + !conn.isClosed());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void closeConn() {
		try {

			if (conn != null) {
				conn.close();
//				System.out.println("Connection closed");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
