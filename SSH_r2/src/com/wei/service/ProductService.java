package com.wei.service;

import org.springframework.transaction.annotation.Transactional;

import com.wei.dao.ProductDao;
import com.wei.domain.Product;

/**
 * 商品管理的业务层
 */
@Transactional
public class ProductService {
	
	// 业务层注入DAO类
	private ProductDao productDao;
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	
	/**
	 * 业务层保存商品的方法
	 */
	public void save(Product product) {
		System.out.println("Service中的save方法执行了....");
		productDao.save(product);
	}
}
