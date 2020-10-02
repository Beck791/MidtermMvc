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

@WebServlet("/InsertProduct")
public class InsertProduct extends HttpServlet {

	private static final long serialVersionUID = 1L;
	Connection conn = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ProductBean pdb = new ProductBean();
		String product = request.getParameter("product");
		String brand = request.getParameter("brand");
		String price = request.getParameter("price");
		String productNo = request.getParameter("productNo");
		String stock = request.getParameter("stock");
		String category = request.getParameter("category");
		String brandId = request.getParameter("brandId");
		try {
			ProductService pds = new ProductService();
			pdb.setProduct(product);
			pdb.setBrand(brand);
			pdb.setPrice(Double.valueOf(price));
			pdb.setProductNo(productNo);
			pdb.setStock(Integer.valueOf(stock));
			pdb.setCategory(category);
			pdb.setBrandId(Integer.valueOf(brandId));
			pds.insert(pdb);
			pdb = pds.querylast();
			request.setAttribute("pdb", pdb);

			request.getRequestDispatcher("/product/InsertProduct.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
