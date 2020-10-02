package com.camp.dao;

import java.sql.SQLException;
import java.util.List;

import com.camp.bean.ProductBean;

public interface ProductDao {

	public void insert(ProductBean pdb) throws SQLException;

	public void update(ProductBean pdb) throws SQLException;

	public void deleteAll() throws SQLException;

	public void deleteOne(int productId) throws SQLException;

	public List<ProductBean> queryAll() throws SQLException;

	public ProductBean queryOne(int i) throws SQLException;

	public void createConn() throws SQLException;

	public void closeConn() throws SQLException;
	
	public ProductBean querylast() throws SQLException;



}
