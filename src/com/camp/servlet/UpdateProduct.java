package com.camp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.camp.bean.ProductBean;
import com.camp.service.ProductService;

@WebServlet("/UpdateProduct")
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
			ProductService pdService = new ProductService();
			pdb.setProduct(product);
			pdb.setBrand(brand);
			pdb.setPrice(Double.valueOf(price));
			pdb.setProductNo(productNo);
			pdb.setStock(Integer.valueOf(stock));
			pdb.setCategory(category);
			pdb.setBrandId(Integer.valueOf(brandId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("pdb", result);

		request.getRequestDispatcher("/product/GetProduct.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
