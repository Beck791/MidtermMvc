package com.camp.service;

import java.sql.SQLException;
import java.util.List;

import com.camp.bean.ProductBean;
import com.camp.dao.ProductDaoImp;

public class ProductService {

	private ProductDaoImp dao;

	public ProductService() throws Exception {
		this.dao = new ProductDaoImp();
	}

	public List<ProductBean> queryAll() throws SQLException {
		dao.createConn();
		List<ProductBean> resultList = dao.queryAll();
		dao.closeConn();
		return resultList;
	}

	public ProductBean queryone(int productId) throws SQLException {
		dao.createConn();
		ProductBean result = dao.queryOne(productId);
		dao.closeConn();
		return result;
	}

	public void insert(ProductBean pdb) throws SQLException {
		dao.createConn();
		dao.insert(pdb);
		dao.closeConn();
	}

	public ProductBean querylast() throws SQLException {
		dao.createConn();
		ProductBean result = dao.querylast();
		dao.closeConn();
		return result;
	}
	
	public void deleteOne(int productId) throws SQLException {
		dao.createConn();
		dao.deleteOne(productId);
		dao.closeConn();
	}

}



