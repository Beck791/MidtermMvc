package com.camp.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
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
		Map<String, String> errorMsg = new HashMap<>();
		request.setAttribute("errorMsg", errorMsg);
		String productId = request.getParameter("productId");
		if (productId == null || productId.trim().length() == 0) {
			errorMsg.put("productId", "產品編號欄必須輸入");
		}
		if (!errorMsg.isEmpty()) {
			request.getRequestDispatcher("/product/GetProduct.jsp").forward(request, response);
			return;
		}
		try {
			ProductService pdService = new ProductService();
			ProductBean result = pdService.queryone(Integer.parseInt(productId));
			request.setAttribute("pdb", result);
			request.getRequestDispatcher("/product/GetProduct.jsp").forward(request, response);		
		} catch (Exception e) {
			errorMsg.put("DBError", e.getMessage());
			e.printStackTrace();
		}
		if (!errorMsg.isEmpty()) {
			request.getRequestDispatcher("/product/GetProduct.jsp").forward(request, response);
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
