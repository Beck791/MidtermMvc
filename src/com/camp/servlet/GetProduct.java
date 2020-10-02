package com.camp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.camp.bean.ProductBean;
import com.camp.service.ProductService;

@WebServlet("/GetProduct")
public class GetProduct extends HttpServlet {
private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String productId = request.getParameter("productId");
		try {
			ProductService pdService = new ProductService();
			ProductBean result = pdService.queryone(Integer.parseInt(productId));

			request.setAttribute("pdb", result);

			request.getRequestDispatcher("/product/GetProduct.jsp").forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
